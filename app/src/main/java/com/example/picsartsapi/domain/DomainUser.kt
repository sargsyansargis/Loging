package com.example.picsartsapi.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DomainUser(
    val status:String,
    @SerializedName("id")
    val id:Long,
    @SerializedName("name")
    val name:String,
    @SerializedName("photo")
    val photo:String,
    @SerializedName("default_profile_pic")
    val hasPic:Boolean
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(photo)
        parcel.writeByte(if (hasPic) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DomainUser> {
        override fun createFromParcel(parcel: Parcel): DomainUser {
            return DomainUser(parcel)
        }

        override fun newArray(size: Int): Array<DomainUser?> {
            return arrayOfNulls(size)
        }
    }

}