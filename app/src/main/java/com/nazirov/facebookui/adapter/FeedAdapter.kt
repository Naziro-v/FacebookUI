package com.nazirov.facebookui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.nazirov.facebookui.R
import com.nazirov.facebookui.model.Feed
import com.nazirov.facebookui.model.Story

class FeedAdapter(var context: Context, var items: ArrayList<Feed>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2
    private val TYPE_ITEM_CHANGED = 3

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]

        if (position==5){
            return TYPE_ITEM_CHANGED
        }

        if (feed.isHeader)
            return TYPE_ITEM_HEAD
        else if (feed.stories.size>0)
            return TYPE_ITEM_STORY
        return TYPE_ITEM_POST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEAD){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_head,parent,false)
            return HeadViewHolder(context,view)
        } else if (viewType == TYPE_ITEM_STORY){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story,parent,false)
            return StoryViewHolder(context,view)
        }  else if (viewType == TYPE_ITEM_CHANGED){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_profile,parent,false)
            return PostViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post,parent,false)
        return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is HeadViewHolder){

        }
        if (holder is StoryViewHolder){
            var recyclerView = holder.recyclerView
            refreshAdapter(feed.stories,recyclerView)
        }
        if (holder is PostViewHolder){
            var feed = items[position]
            var iv_profile =holder.iv_profile
            var iv_photo = holder.iv_photo
            var tv_full_name= holder.tv_full_name

            iv_profile.setImageResource(feed.post!!.profile)
            iv_photo.setImageResource(feed.post!!.photo)
            tv_full_name.text = feed.post!!.fullname
        }
    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context,stories)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
       return items.size
    }
    class HeadViewHolder(context: Context, view: View):RecyclerView.ViewHolder(view){


    }
    class StoryViewHolder(context: Context,view: View):RecyclerView.ViewHolder(view){
        var recyclerView: RecyclerView
        init {
            recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            recyclerView.layoutManager = manager
        }
    }
    class PostViewHolder(var view: View):RecyclerView.ViewHolder(view){
        var iv_profile:ShapeableImageView
        var iv_photo:ImageView
        var tv_full_name: TextView
        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_photo = view.findViewById(R.id.iv_post)
            tv_full_name  =view.findViewById(R.id.tv_full_name)
        }
    }

}