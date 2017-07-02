package com.example.hen.sichon.fragments

import android.content.Context
import android.os.Bundle
import android.support.annotation.ArrayRes
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hen.sichon.R
import com.example.hen.sichon.activities.interfaces.FragmentNavigation
import com.example.hen.sichon.adapters.CategoriesAdapter
import com.example.hen.sichon.enums.Category
import com.example.hen.sichon.models.CategoryModel

class CategoryFragment : Fragment()
{
    companion object
    {
        private const val RECYCLER_VIEW_SPAN_COUNT = 3

        fun getInstance(): CategoryFragment
        {
            return CategoryFragment()
        }
    }

    var mFragmentNavigationListener: FragmentNavigation? = null

    override fun onAttach(context: Context?)
    {
        super.onAttach(context)
        mFragmentNavigationListener = context as FragmentNavigation
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater?.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val categoryRecyclerView = view?.findViewById(R.id.recycler_view_categories) as RecyclerView
        categoryRecyclerView.layoutManager = StaggeredGridLayoutManager(RECYCLER_VIEW_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)

        val category1 = CategoryModel(Category.SOFT_LANDING)
        val category2 = CategoryModel(Category.CONVERSATION)
        val category3 = CategoryModel(Category.QUESTIONS)
        val category4 = CategoryModel(Category.COLORS)
        val category5 = CategoryModel(Category.NUMBERS)
        val category6 = CategoryModel(Category.CLOCK)
        val category7 = CategoryModel(Category.TRANSPORTATION)

        val categories = listOf(category1, category2, category3, category4, category5, category6, category7)
        val categoryAdapter = CategoriesAdapter(categories)
        categoryAdapter.setOnCategoryClickListener({ category -> mFragmentNavigationListener?.replaceFragment(true, PhrasesFragment.getInstance(category)) })

        categoryRecyclerView.adapter = categoryAdapter
    }
}