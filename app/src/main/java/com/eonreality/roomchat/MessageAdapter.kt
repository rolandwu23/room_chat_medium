package com.eonreality.roomchat

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView


class MessageAdapter (private val context: Context,private val messages: List<Message>?) : RecyclerView.Adapter<MessageAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.message, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
            return messages?.size!!
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.itemView.animation = AnimationUtils.loadAnimation(context,R.anim.item_animation_fall_down)
        viewHolder.messageTV.text = messages?.get(index)?.message
    }


    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        var messageTV: TextView = itemView.findViewById(R.id.messageTextView) as TextView
    }

}