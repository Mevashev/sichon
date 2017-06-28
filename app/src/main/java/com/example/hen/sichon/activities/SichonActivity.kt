package com.example.hen.sichon.activities

import com.example.hen.sichon.R
import com.example.hen.sichon.fragments.AboutFragment
import com.example.hen.sichon.fragments.FavoritesFragment
import com.example.hen.sichon.fragments.PhrasesCategoryFragment

class SichonActivity : BaseFragmentTransactionActivity()
{

    override fun onCreate(savedInstanceState: android.os.Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(com.example.hen.sichon.R.layout.activity_sichon)
        val bottomNavigationView = findViewById(com.example.hen.sichon.R.id.bottom_navigation) as android.support.design.widget.BottomNavigationView

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId)
            {
                R.id.action_phrases -> replaceFragment(false, PhrasesCategoryFragment.getInstance())
                R.id.action_favorites -> replaceFragment(false, FavoritesFragment.getInstance())
                R.id.action_about -> replaceFragment(false, AboutFragment.getInstance())
            }
            true
        }

        bottomNavigationView.findViewById(R.id.action_phrases).performClick()

    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean
    {
        val inflater: android.view.MenuInflater = menuInflater
        inflater.inflate(com.example.hen.sichon.R.menu.main_menu, menu)
        return true
    }
}
