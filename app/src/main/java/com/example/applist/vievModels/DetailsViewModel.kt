package com.example.applist.vievModels


import android.text.format.DateFormat
import androidx.lifecycle.ViewModel
import com.example.applist.model.AppData


class DetailsViewModel : ViewModel() {

    private lateinit var app: AppData
    val name: String
        get() {
            return app.name
        }
    val size: String
        get() {
            val size = String.format("%.2f", app.size)
            return "$size MB"
        }
    val sdkVersion: String
        get() {
            return app.target_sdk_version.toString()
        }

    val installDate:String
        get() {
            return DateFormat.format("dd.MM.yyyy", app.installation_date).toString()
        }

    fun setApp(appData: AppData) {
        app = appData
    }


}