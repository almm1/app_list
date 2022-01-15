package com.example.applist.view.adapters

import com.example.applist.model.AppData

interface ActionListener {
    fun onAppDetails(app: AppData)
}