@file:Suppress("DEPRECATION")

package com.example.picsartsapi


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.picsartsapi.Api.LoginResponse
import com.example.picsartsapi.Api.asDomainModel
import com.example.picsartsapi.databinding.FragmentLoginScreenBinding
import com.example.picsartsapi.domain.DomainUser


class LoginScreenFragment : Fragment() {
    private val viewModel: LoginScreenViewModel by lazy {
        ViewModelProviders.of(this).get(LoginScreenViewModel::class.java)
    }
    private lateinit var logUser: UserNamePassword
    private lateinit var loginUser: DomainUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginScreenBinding>(
            inflater,
            R.layout.fragment_login_screen,
            container,
            false
        )

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.logViewModel = viewModel

        binding.btn.setOnClickListener {
            logUser = UserNamePassword(
                binding.etusername.text.toString(),
                binding.etpassword.text.toString()
            )
            viewModel.loginUser(logUser)
            Log.e("sax exav", "")

        }

//        if (viewModel.loginSucces.equals(true)) {
//            viewModel.response.observe(viewLifecycleOwner, Observer { user ->
//                loginUser = user.asDomainModel()
//            })
//            view?.findNavController()
//                ?.navigate(
//                    LoginScreenFragmentDirections.actionLoginScreenFragmentToSearchScreenFragment(
//                        loginUser
//                    )
//                )
//        }

        return binding.root
    }
}







