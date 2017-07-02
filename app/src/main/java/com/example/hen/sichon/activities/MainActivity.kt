package com.example.hen.sichon.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.example.hen.sichon.R
import com.example.hen.sichon.adapters.LanguageAdapter
import com.example.hen.sichon.adapters.LanguageSelectorAdapter
import com.example.hen.sichon.decorators.LanguageItemDecorator
import com.example.hen.sichon.enums.Language
import com.example.hen.sichon.managers.PersistenceManager
import com.example.hen.sichon.models.LanguageModel
import com.example.hen.sichon.models.SelectLanguageModel
import com.example.hen.sichon.utils.AppUtils
import com.example.hen.sichon.utils.DialogUtil

class MainActivity : AppCompatActivity() {
    private val SPAN_COUNT = 1
    var mLanguageSelectorAdapter: LanguageSelectorAdapter? = null
    var mSelectedLanguage: Language? = null
    var mAdapter: LanguageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PersistenceManager.init(applicationContext)
        initLanguageFlagsRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        val inflater: android.view.MenuInflater = menuInflater
        inflater.inflate(com.example.hen.sichon.R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.language -> {
                val view = createLanguageRecyclerView()
                val dialog = DialogUtil.createTwoButtonsConfirmationDialog(this, R.string.dialog_title_select_language, R.string.dialog_done, R.string.dialog_cancel,
                        MaterialDialog.SingleButtonCallback({ _, _ ->
                            mSelectedLanguage = mLanguageSelectorAdapter?.getSelectedLanguage()
                            AppUtils.setDefaultLocale(this@MainActivity, mSelectedLanguage?.locale)
                            mAdapter?.removeThisItem(mSelectedLanguage)
                            PersistenceManager.saveTranslateFromLanguage(mSelectedLanguage.toString())

                        }),
                        MaterialDialog.SingleButtonCallback({ dialog, _ -> dialog.dismiss() }))
                dialog.customView(view, true)
                dialog.show()
            }
        }
        return true
    }

    private fun initLanguageFlagsRecyclerView() {
        val languageRecyclerView = findViewById(R.id.recycler_view_language) as RecyclerView
        languageRecyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT, GridLayoutManager.VERTICAL, false)
        val items: ArrayList<LanguageModel> = ArrayList()
        items.add(LanguageModel(R.drawable.united_states, Language.ENGLISH))
        items.add(LanguageModel(R.drawable.israel, Language.HEBREW))
        items.add(LanguageModel(R.drawable.russia, Language.RUSSIAN))

        mAdapter = LanguageAdapter(items)
        mAdapter?.setLanguageClickListener(object : LanguageAdapter.OnLanguageClickListener {
            override fun onLanguageClick(selectedLanguage: Language) {
                PersistenceManager.saveTranslteToLanguage(selectedLanguage.toString())
                startActivity(SichonActivity.getIntent(this@MainActivity))
            }
        })
        languageRecyclerView.adapter = mAdapter
        languageRecyclerView.setHasFixedSize(true)
        languageRecyclerView.addItemDecoration(LanguageItemDecorator(SPAN_COUNT))
        val selectedLanguage = PersistenceManager.getTranslateFromLanguage()
        if (!TextUtils.isEmpty(selectedLanguage)) {
            val language = Language.getLanguageFromString(selectedLanguage)
            AppUtils.setDefaultLocale(this, language.locale)
            mAdapter?.removeThisItem(language)
        } else {
            mAdapter?.removeThisItem(Language.ENGLISH)
        }
    }

    private fun createLanguageRecyclerView(): View {
        val view = View.inflate(this, R.layout.view_languages_selector, null)
        val selectLanguageRecyclerView = view.findViewById(R.id.recycler_view_languages) as RecyclerView
        val data = ArrayList<SelectLanguageModel>()

        val selectedLanguage = PersistenceManager.getTranslateFromLanguage()
        mLanguageSelectorAdapter = LanguageSelectorAdapter(data)
        var language: Language? = null
        if (!TextUtils.isEmpty(selectedLanguage)) {
            language = Language.getLanguageFromString(selectedLanguage)
        } else {
            language = Language.ENGLISH
        }
        data.add(SelectLanguageModel(Language.ENGLISH, false))
        data.add(SelectLanguageModel(Language.HEBREW, false))
        data.add(SelectLanguageModel(Language.RUSSIAN, false))

        for (dataItem in data) {
            if(dataItem.language == language)
            {
                dataItem.isSelected = true
                break
            }
        }
        selectLanguageRecyclerView.adapter = mLanguageSelectorAdapter
        selectLanguageRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        selectLanguageRecyclerView.setHasFixedSize(true)
        return view
    }


}
