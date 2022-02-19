package com.nazirov.facebookui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.nazirov.facebookui.R
import com.nazirov.facebookui.model.Story
import java.util.logging.SocketHandler

class StoryAdapter(var context: Context, var items: ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var ITEM_CREATE_STORY: Int = 0
    var ITEM_STORY: Int = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType==ITEM_CREATE_STORY){
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_create_story,parent,false)
            return CreatStoryViewHolder(view)
        }
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view,parent,false)
        return StoryViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].createStory){
            return ITEM_CREATE_STORY
        }
        return ITEM_STORY
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       var story = items[position]

        if (holder is StoryViewHolder){
            var iv_background = holder.iv_background
            var iv_profile = holder.iv_profile
            var tv_full_name = holder.tv_full_name

            iv_background.setImageResource(story.profile!!)
            iv_profile.setImageResource(story.profile!!)
            tv_full_name.text = story.fullname

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class StoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_background :ShapeableImageView = view.findViewById(R.id.iv_background)
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_full_name: TextView = view.findViewById(R.id.tv_full_name)

    }
    class CreatStoryViewHolder(view: View):RecyclerView.ViewHolder(view){

    }
}