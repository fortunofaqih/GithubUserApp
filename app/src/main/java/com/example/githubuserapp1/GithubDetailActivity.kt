package com.example.githubuserapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GithubDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_GITHUB = "extra_github"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_detail)
        //val data = intent.getParcelableExtra<Github>("DATA")
        
         val tvDataReceived: TextView = findViewById(R.id.tv_item_username)
          val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
          
        val data = intent.getParcelableExtra<Github>(EXTRA_GITHUB) as Github
        imgPhoto.setImageResource(data.avatars)
        val text = "Username : ${data.username.toString()},\nName : ${data.name},\nLocation : ${data.location},\nRepository : ${data.repository},\nCompany : ${data.company},\nFollowers : ${data.followers},\nFollowing : ${data.following}"
        tvDataReceived.text = text

    }
}
