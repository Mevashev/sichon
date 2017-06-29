package com.example.hen.sichon.utils

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.speech.tts.TextToSpeech
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import java.util.*


class AppUtils
{
    companion object
    {
        fun getLocalizedResources(context: Context, locale: Locale): Resources
        {
            var conf = context.resources.configuration
            conf = Configuration(conf)
            conf.setLocale(locale)
            val localizedContext = context.createConfigurationContext(conf)
            return localizedContext.resources
        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP) fun textToSpeech(context: Context, locale: Locale, textToSpeech: String): TextToSpeech
        {
            return object
            {
                val value: TextToSpeech get() = inner
                private val inner = TextToSpeech(context, TextToSpeech.OnInitListener {
                    val result = value.setLanguage(locale)
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.e("TTS", "This Language is not supported")
                        val installIntent = Intent()
                        installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
                        startActivity(context, installIntent, null)
                    }
                    else
                    {
                        value.speak(textToSpeech, TextToSpeech.QUEUE_FLUSH, null, null)
                    }
                })
            }.value
        }

        fun setDefaultLocale(context: Context, locale: Locale?)
        {
            Locale.setDefault(locale)

            val config = context.resources.configuration
            config.setLocale(locale)
            context.createConfigurationContext(config)
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }
    }
}