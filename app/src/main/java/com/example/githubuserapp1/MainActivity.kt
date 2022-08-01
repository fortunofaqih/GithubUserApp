package com.example.githubuserapp1

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGithub: RecyclerView
    private val list = ArrayList<Github>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvGithub = findViewById(R.id.rv_github)

        rvGithub.setHasFixedSize(true)

        list.addAll(listGithub)
        showRecyclerList()





    }

    private val listGithub: ArrayList<Github>
        get() {
            val dataUserName = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val datafollowers = resources.getStringArray(R.array.followers)
            val datafollowing = resources.getStringArray(R.array.following)
            val dataPhoto = resources.obtainTypedArray(R.array.avatars)

            val listGithub = ArrayList<Github>()
            for (i in dataUserName.indices) {
                val github = Github(dataUserName[i],dataName[i], dataLocation[i], dataRepository[i], dataCompany[i], datafollowers[i], datafollowing[i],dataPhoto.getResourceId(i,-1))
                listGithub.add(github)

            }
            return listGithub
        }
    private fun showRecyclerList() {

        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvGithub.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvGithub.layoutManager = LinearLayoutManager(this)
        }

        val listGithubAdapter = ListGithubAdapter(list)
        rvGithub.adapter = listGithubAdapter

        listGithubAdapter.setOnItemClickCallback(object : ListGithubAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Github) {
                val intentToDetail = Intent(this@MainActivity, GithubDetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })

    }




}



