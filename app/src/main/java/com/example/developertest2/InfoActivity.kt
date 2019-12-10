package com.example.developertest2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val TitleTv : TextView = findViewById(R.id.title) as TextView
        val UserIdTv : TextView = findViewById(R.id.userid) as TextView
        val IdTv : TextView = findViewById(R.id.id1) as TextView
        val BodyTv : TextView = findViewById(R.id.body) as TextView

        val post = intent.getSerializableExtra("post") as Post

        TitleTv.text="Title:" + post.title
        UserIdTv.text="User Id: "+ post.userId.toString()
        IdTv.text="Id: " + post.id.toString()
        BodyTv.text="Content: "+ post.body


    }

}
