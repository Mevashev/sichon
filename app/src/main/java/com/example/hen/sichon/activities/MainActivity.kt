package com.example.hen.sichon.activities

import com.example.hen.sichon.R
import com.example.hen.sichon.fragments.PhrasesCategoryFragment

class MainActivity : BaseFragmentTransactionActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.hen.sichon.R.layout.activity_main)
        var bottomNavigationView = findViewById(com.example.hen.sichon.R.id.bottom_navigation) as android.support.design.widget.BottomNavigationView

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_phrases -> replaceFragment(false, PhrasesCategoryFragment.getInstance())
            }
            true
        }

        bottomNavigationView.findViewById(R.id.action_phrases).performClick()

    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        var inflater: android.view.MenuInflater = menuInflater
        inflater.inflate(com.example.hen.sichon.R.menu.main_menu, menu)
        return true
    }
}
