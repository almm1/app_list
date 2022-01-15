package com.example.applist.utils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.app.Application

import com.example.applist.model.DataService
import com.example.applist.vievModels.ScanViewModel


class ScanViewModelFactory(private val dataService: DataService, private val mApplication: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ScanViewModel(dataService, mApplication) as T
    }
}