package com.example.hen.sichon.managers

import android.content.Context
import com.example.hen.sichon.data.models.Data
import com.google.gson.GsonBuilder
import java.io.ByteArrayOutputStream
import java.io.IOException

object DataManager
{
    lateinit var data: Data

    fun init(context: Context)
    {
        val identifier = context.resources.getIdentifier("data", "raw", context.packageName)
        val inputStream = context.resources.openRawResource(identifier)

        val output = ByteArrayOutputStream()
        val buf = ByteArray(1024)
        var len = inputStream.read(buf)

        try
        {
            while (len != -1)
            {
                output.write(buf, 0, len)
                len = inputStream.read(buf)
            }
            output.close()
            inputStream.close()
        }
        catch (e: IOException)
        {

        }

        val gson = GsonBuilder().create()
        data = gson.fromJson(output.toString(), Data::class.java)
    }
}