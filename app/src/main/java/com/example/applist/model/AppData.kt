package com.example.applist.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class AppData (
    val name: String,
    val logo: @RawValue Drawable,
    val size: Double,
    val installation_date: Long,
    val target_sdk_version:Int
):Parcelable