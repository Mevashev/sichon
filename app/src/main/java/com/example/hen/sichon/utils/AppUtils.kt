package com.example.hen.sichon.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
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
  }
}