package com.app.githubuserappsub1.data

import android.os.Parcel
import android.os.Parcelable

data class GithubUser(
    val username: String?,
    val name: String?,
    val company: String?,
    val location: String?,
    val repo: String?,
    val avatar: String?,
    val follower: Int,
    val following: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(name)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(repo)
        parcel.writeString(avatar)
        parcel.writeInt(follower)
        parcel.writeInt(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GithubUser> {
        override fun createFromParcel(parcel: Parcel): GithubUser {
            return GithubUser(parcel)
        }

        override fun newArray(size: Int): Array<GithubUser?> {
            return arrayOfNulls(size)
        }
    }
}
