package com.example.applist.vievModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.applist.model.AppData
import com.example.applist.model.DataService

class ScanViewModel(
    private val dataService: DataService,
    application: Application
) : AndroidViewModel(application) {

    private lateinit var appsData:List<AppData>
    fun loadData():Array<AppData> {
        appsData = dataService.loadData(getApplication())
        return appsData.toTypedArray()
    }
}