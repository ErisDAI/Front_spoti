package edu.udelp.music.ui

import android.content.Context
import android.os.Build
import android.os.LocaleList
import java.util.Locale

object LanguageManager {
    fun applySystemLocale(context: Context) {
        // En Android 14+, el sistema gestiona mejor los locales si no intervenimos con APIs antiguas
    }

    fun setLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = context.resources
        val config = resources.configuration
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocales(LocaleList(locale))
        } else {
            @Suppress("DEPRECATION")
            config.locale = locale
        }
        
        @Suppress("DEPRECATION")
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}
