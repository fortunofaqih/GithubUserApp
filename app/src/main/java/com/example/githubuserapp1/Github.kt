package com.example.githubuserapp1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Github(
    var username:String,
    var name:String,
    var location: String,
    var repository: String,
    var company:String,
    var followers: String,
    var following: String,
    var avatars:Int

):Parcelable
