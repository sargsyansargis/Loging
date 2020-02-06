package com.example.picsartsapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picsartsapi.Api.LoginResponse
import com.example.picsartsapi.Api.PicsArtApi
import com.example.picsartsapi.Api.asDomainModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {

     val fakeUser = LoginResponse(
        "success", 260365127026102,
        "dududu94", "ddfz",
        "https://cdn21.picsart.com/145116821005201.png",
        true,
        "dududu9@gmail.com"
    )
    private val _response = MutableLiveData<LoginResponse>()
    val response: LiveData<LoginResponse>
        get() = _response

    private val _loginSucces =MutableLiveData<Boolean>(false)
    val loginSucces:LiveData<Boolean>
    get() = _loginSucces

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun loginUser(logUser:UserNamePassword) {
        coroutineScope.launch {
            val userDeferred = PicsArtApi.getApi().getUser(Gson().toJson(logUser))
            try {
                val response = userDeferred.await()
                Log.e("kpaaaanq", response.status)
                _response.value = fakeUser
                if(response.status.equals("success")) {
                    _loginSucces.value = true
                }
                _loginSucces.value = false
            } catch (e: Exception) {
                Log.e("qaaaaaaaaaq","")
                _response.value = null
                _loginSucces.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}