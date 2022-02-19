package com.nazirov.facebookui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.facebookui.R
import com.nazirov.facebookui.adapter.FeedAdapter
import com.nazirov.facebookui.model.Feed
import com.nazirov.facebookui.model.Post
import com.nazirov.facebookui.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllFeeds())

    }

    private fun getAllFeeds(): ArrayList<Feed> {
        var stories: ArrayList<Story> = ArrayList()

        stories.add(Story())

        stories.add(Story(R.drawable.mine, "Nazirov Elmurod"))
        stories.add(Story(R.drawable.img_2, "Og`abek Matyakubov"))
        stories.add(Story(R.drawable.mine5, "Nazirov Elmurod"))
        stories.add(Story(R.drawable.img, "Jabbor Devoloper"))
        stories.add(Story(R.drawable.mine, "Nazirov Elmurod"))
        stories.add(Story(R.drawable.mine5, "Nazirov Elmurod"))
        stories.add(Story(R.drawable.mine, "Nazirov Elmurod"))
        stories.add(Story(R.drawable.img_2, "Og`abek Matyakubov"))
        stories.add(Story(R.drawable.mine5, "Nazirov Elmurod"))
        stories.add(Story(R.drawable.img, "Jabbor Devoloper"))
        stories.add(Story(R.drawable.mine, "Nazirov Elmurod"))
        stories.add(Story(R.drawable.mine5, "Nazirov Elmurod"))

        var feeds: ArrayList<Feed> = ArrayList()

        feeds.add(Feed())

        feeds.add(Feed(stories))

        feeds.add(Feed(Post(R.drawable.img_2, "Og`abek Matyakubov", R.drawable.b13group)))
        feeds.add(Feed(Post(R.drawable.mine, "Nazirov Elmurod", R.drawable.b13groupinfootbal)))
        feeds.add(Feed(Post(R.drawable.mine5, "Nazirov Elmurod", R.drawable.mosque)))
        feeds.add(Feed(Post(R.drawable.img, "Jabbor ", R.drawable.img)))
        feeds.add(Feed(Post(R.drawable.img_2, "Og`abek Matyakubov", R.drawable.b13group)))
        feeds.add(Feed(Post(R.drawable.mine, "Nazirov Elmurod", R.drawable.b13groupinfootbal)))
        feeds.add(Feed(Post(R.drawable.mine5, "Nazirov Elmurod", R.drawable.mosque)))
        feeds.add(Feed(Post(R.drawable.img, "Jabbor ", R.drawable.film)))

        return feeds

    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        var adapter = FeedAdapter(this, feeds)

        recyclerView.adapter = adapter


    }
}