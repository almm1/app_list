package com.example.applist.view.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.applist.R
import com.example.applist.databinding.ActivityMainBinding
import com.example.applist.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val sharedPrefs by lazy {  getSharedPreferences(THEME, Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTheme()
        initThemeListener()

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHost.navController
    }

    private fun onDarkThemeButtonPressed() {
        setLightTheme()
    }

    private fun onLightThemeButtonPressed() {
        setDarkTheme()
    }
    private fun initTheme() {
        when (sharedPrefs.getInt(KEY_THEME, DEFAUULT_THEME)){
            LIGHT_THEME->setLightTheme()
            DARK_THEME->setDarkTheme()
            DEFAUULT_THEME->setLightTheme()
        }

    }
    private fun initThemeListener() {
        binding.buttonLight.setOnClickListener { onLightThemeButtonPressed() }
        binding.buttonDark.setOnClickListener { onDarkThemeButtonPressed() }
    }

    private fun setLightTheme(){
        binding.buttonLight.visibility= View.VISIBLE
        binding.buttonDark.visibility= View.GONE
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        sharedPrefs.edit().putInt(KEY_THEME, LIGHT_THEME).apply()
    }
    private fun setDarkTheme(){
        binding.buttonDark.visibility= View.VISIBLE
        binding.buttonLight.visibility= View.GONE
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        sharedPrefs.edit().putInt(KEY_THEME, DARK_THEME).apply()
    }
}

