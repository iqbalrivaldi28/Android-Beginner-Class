package com.example.androidbeginner

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonDataClass(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
): Parcelable