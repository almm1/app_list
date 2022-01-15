package com.example.applist.model

import android.content.Context
import android.content.pm.PackageManager
import java.io.File

class DataService {

    fun loadData(context: Context): List<AppData> {
        val apps: MutableList<AppData> = mutableListOf()
        val logotips = AppLogo
        val packageManager = context.packageManager

        val packages = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)

        packages.forEach {
            if (packageManager.getLaunchIntentForPackage(it.packageName)!=null) {
                val info = packageManager.getApplicationInfo(
                    it.packageName,
                    PackageManager.GET_META_DATA
                )
                val name = packageManager.getApplicationLabel(info).toString()
                val installTime = it.firstInstallTime
                val targetSdk = info.targetSdkVersion
                val logo = packageManager.getApplicationIcon(info)
                val file = File(info.publicSourceDir)
                val length = file.length()
                val size = length / 8.0 / 1024.0 / 1024.0 //bits to MB

                logotips.logoMap[logo.toString()] = logo
                val app = AppData(name, logo.toString(), size, installTime, targetSdk)
                apps.add(app)
            }
        }
        return apps
    }
}