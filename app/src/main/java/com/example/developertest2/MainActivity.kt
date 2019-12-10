package com.example.developertest2

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.mancj.materialsearchbar.MaterialSearchBar

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.*

class MainActivity : AppCompatActivity(), OnRecyclerViewItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val searchBar = findViewById<MaterialSearchBar>(R.id.searchBar)
        searchBar.setHint("Search..")
        searchBar.setSpeechMode(true)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllPosts().enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                showData(response.body()!!)
                Log.d("jv", "onResponse")
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("jv", "onFailure")
            }
        })

        searchBar.addTextChangeListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //SEARCH FILTER
                //.getFilter().filter(charSequence)
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })




    }

    override fun onItemClick(post: Post) {
        val intent = Intent(applicationContext, InfoActivity::class.java)
        intent.putExtra("post", post)
        startActivity(intent)
    }

    private fun showData(posts: List<Post>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostsAdapter(posts, this@MainActivity)


        }


    }

}

