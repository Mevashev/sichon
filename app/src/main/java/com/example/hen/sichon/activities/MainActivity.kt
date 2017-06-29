package com.example.hen.sichon.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.hen.sichon.R
import com.example.hen.sichon.adapters.LanguageAdapter
import com.example.hen.sichon.decorators.LanguageItemDecorator
import com.example.hen.sichon.models.LanguageModel

class MainActivity : AppCompatActivity() {

    private val SPAN_COUNT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foreignLanguageRecyclerView = findViewById(R.id.recycler_view_foreign_language) as RecyclerView
        foreignLanguageRecyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT, GridLayoutManager.VERTICAL, false)
        val items: ArrayList<LanguageModel> = ArrayList()
        items.add(LanguageModel(R.drawable.united_states, LanguageModel.Language.ENGLISH))
        items.add(LanguageModel(R.drawable.israel, LanguageModel.Language.HEBREW))
        items.add(LanguageModel(R.drawable.russia, LanguageModel.Language.RUSSIAN))
        foreignLanguageRecyclerView.adapter = LanguageAdapter(items)
        foreignLanguageRecyclerView.setHasFixedSize(true)
        foreignLanguageRecyclerView.addItemDecoration(LanguageItemDecorator(SPAN_COUNT))
    }
}
