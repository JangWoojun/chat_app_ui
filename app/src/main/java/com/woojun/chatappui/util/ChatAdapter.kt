package com.woojun.chatappui.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woojun.chatappui.databinding.ChatItemBinding

class ChatAdapter(private val chatList: List<Chat>): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(private val binding: ChatItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(chat: Chat) {
                binding.apply{

                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ChatItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ChatViewHolder(binding).also { handler ->
            binding.apply {

            }
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(chatList[position])
    }

}