package com.example.hen.sichon.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.speech.tts.TextToSpeech
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

      fun textToSpeech(context: Context, locale: Locale): TextToSpeech
      {
          return object
          {
              val value: TextToSpeech get() = inner
              private val inner = TextToSpeech(context, TextToSpeech.OnInitListener {
                  val result = value.setLanguage(locale)
                  if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                  {
                      Log.e("TTS", "This Language is not supported")
                  }
              })
          }.value
      }
  }
}