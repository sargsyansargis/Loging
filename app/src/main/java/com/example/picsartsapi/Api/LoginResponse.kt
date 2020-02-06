package com.example.picsartsapi.Api

import android.os.Parcel
import android.os.Parcelable
import com.example.picsartsapi.domain.DomainUser
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("default_profile_pic")
    val hasPic: Boolean,
    @SerializedName("email")
    val email: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(photo)
        parcel.writeByte(if (hasPic) 1 else 0)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginResponse> {
        override fun createFromParcel(parcel: Parcel): LoginResponse {
            return LoginResponse(parcel)
        }

        override fun newArray(size: Int): Array<LoginResponse?> {
            return arrayOfNulls(size)
        }
    }

}

fun LoginResponse.asDomainModel(): DomainUser {
    return DomainUser(
        status = this.status,
        id = this.id,
        name = this.name,
        photo = this.photo,
        hasPic = this.hasPic

    )
}