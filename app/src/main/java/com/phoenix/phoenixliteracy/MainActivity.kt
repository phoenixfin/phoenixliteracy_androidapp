package com.phoenix.phoenixliteracy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBooklet: RecyclerView
    private var list: ArrayList<Booklet> = arrayListOf()
    private var title: String = "Booklet Phx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)
        rvBooklet = findViewById(R.id.rv_booklet)
        rvBooklet.setHasFixedSize(true)
        list.addAll(BookletData.listData)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBooklet.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(list)
        rvBooklet.adapter = listAdapter
        listAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Booklet) {
                showSelectedBooklet(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvBooklet.layoutManager = GridLayoutManager(this, 2)
        val gridAdapter = GridAdapter(list)
        rvBooklet.adapter = gridAdapter

        gridAdapter.setOnItemClickCallback(object : GridAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Booklet) {
                showSelectedBooklet(data)
            }
        })
    }

    private fun showSelectedBooklet(booklet: Booklet) {
        val detailedIntent = Intent(this@MainActivity, DetailedActivity::class.java)

        detailedIntent.putExtra(DetailedActivity.TITLE, booklet.title)
        detailedIntent.putExtra(DetailedActivity.DESC, booklet.description)
        detailedIntent.putExtra(DetailedActivity.PAGE, booklet.page)
        detailedIntent.putExtra(DetailedActivity.DATE, booklet.date)
        detailedIntent.putExtra(DetailedActivity.IMG, booklet.photo)
        detailedIntent.putExtra(DetailedActivity.URL, booklet.url)
        startActivity(detailedIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
    }
}