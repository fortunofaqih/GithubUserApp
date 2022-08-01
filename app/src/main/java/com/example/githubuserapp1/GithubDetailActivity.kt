package com.example.githubuserapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GithubDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_detail)
        val data = intent.getParcelableExtra<Github>("DATA")

    }
}