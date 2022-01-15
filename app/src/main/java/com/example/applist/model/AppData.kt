package com.example.applist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppData (
    val name: String,
    val logo: String,
    val size: Double,
    val installation_date: Long,
    val target_sdk_version:Int
):Parcelable