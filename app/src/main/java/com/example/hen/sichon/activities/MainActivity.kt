package com.example.hen.sichon.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import com.afollestad.materialdialogs.MaterialDialog
import com.example.hen.sichon.R
import com.example.hen.sichon.adapters.LanguageAdapter
import com.example.hen.sichon.adapters.LanguageSelectorAdapter
import com.example.hen.sichon.decorators.LanguageItemDecorator
import com.example.hen.sichon.models.LanguageModel
import com.example.hen.sichon.models.SelectLanguageModel

class MainActivity : AppCompatActivity() {

    val SPAN_COUNT = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foreignLanguageRecyclerView = findViewById(R.id.recycler_view_foreign_language) as RecyclerView
        foreignLanguageRecyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT, GridLayoutManager.VERTICAL, false)
        val items: ArrayList<LanguageModel> = ArrayList()
        items.add(LanguageModel(R.drawable.ic_search_black_24dp, LanguageModel.Language.ENGLISH))
        items.add(LanguageModel(R.drawable.ic_search_black_24dp, LanguageModel.Language.HEBREW))
        items.add(LanguageModel(R.drawable.ic_search_black_24dp, LanguageModel.Language.RUSSIAN))
        foreignLanguageRecyclerView.adapter = LanguageAdapter(items)
        foreignLanguageRecyclerView.setHasFixedSize(true)
        foreignLanguageRecyclerView.addItemDecoration(LanguageItemDecorator(SPAN_COUNT))
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        val inflater: android.view.MenuInflater = menuInflater
        inflater.inflate(com.example.hen.sichon.R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.language -> {
                val mInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                val view = mInflater.inflate(R.layout.view_languages_selector, null, false)
                val selectLanguageRecyclerView = view.findViewById(R.id.recycler_view_languages) as RecyclerView
                val data = ArrayList<SelectLanguageModel>()
                data.add(SelectLanguageModel(R.drawable.ic_language_black_24dp, LanguageModel.Language.ENGLISH, true))
                data.add(SelectLanguageModel(R.drawable.ic_language_black_24dp, LanguageModel.Language.HEBREW, false))
                data.add(SelectLanguageModel(R.drawable.ic_language_black_24dp, LanguageModel.Language.RUSSIAN, false))
                selectLanguageRecyclerView.adapter = LanguageSelectorAdapter(data)
                selectLanguageRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                selectLanguageRecyclerView.setHasFixedSize(true)
                MaterialDialog.Builder(this).cancelable(false).positiveText("Select").negativeText("Cancel").customView(view, true).show()
            }
        }
        return true
    }

}
