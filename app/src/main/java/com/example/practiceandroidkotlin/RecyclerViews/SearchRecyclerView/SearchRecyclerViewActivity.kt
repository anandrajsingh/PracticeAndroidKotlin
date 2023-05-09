package com.example.practiceandroidkotlin.RecyclerViews.SearchRecyclerView

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceandroidkotlin.R
import java.util.Locale

class SearchRecyclerViewActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchview)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }

    private fun filterList(query: String?) {
        if(query != null){
            val filterList = ArrayList<LanguageData>()
            for(i in mList){
                if (i.title.toLowerCase(Locale.ROOT).contains(query)){
                    filterList.add(i)
                }
            }

            if(filterList.isEmpty()){
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filterList)
            }
        }
    }

    private fun addDataToList(){
        mList.add(LanguageData("Java", R.drawable.java))
        mList.add(LanguageData("Javascript", R.drawable.javascript))
        mList.add(LanguageData("Kotlin", R.drawable.kotlin))
        mList.add(LanguageData("Python", R.drawable.python))
        mList.add(LanguageData("HTML", R.drawable.html))
        mList.add(LanguageData("C++", R.drawable.cplusplus))
        mList.add(LanguageData("C#", R.drawable.csharp))
        mList.add(LanguageData("Swift", R.drawable.swift))
    }
}