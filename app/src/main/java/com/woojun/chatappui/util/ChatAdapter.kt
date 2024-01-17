package com.woojun.chatappui.util

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.woojun.chatappui.databinding.ChatItemBinding
import com.woojun.chatappui.databinding.OtherChatItemBinding
import com.woojun.chatappui.util.UtilFunction.dpToPx

class ChatAdapter(private val chatList: MutableList<Chat>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            1 -> {
                val binding = ChatItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )

                ChatViewHolder(binding).also { handler ->
                    binding.apply {

                    }
                }
            }
            else -> {
                val binding = OtherChatItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )

                OtherChatViewHolder(binding).also { handler ->
                    binding.apply {

                    }
                }
            }

        }
    }

    fun addChat(chat: Chat) {
        chatList.add(chat)

        notifyItemInserted(chatList.size - 1)
    }

    fun getChat(): List<Chat> {
        return chatList
    }

    override fun getItemViewType(position: Int): Int {
        return if (chatList[position].isUser) 1 else 0
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (chatList[position].isUser) {
            (holder as ChatViewHolder).bind(chatList[position])
        } else {
            (holder as OtherChatViewHolder).bind(chatList[position])
        }
    }

    class ChatViewHolder(private val binding: ChatItemBinding):
        ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.apply{
                messageText.text = chat.massage
                dateText.text = chat.date
                isShowText.visibility = View.VISIBLE

                dateText.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
                isShowText.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)

                val screenWidth = Resources.getSystem().displayMetrics.widthPixels
                val extraWidth = dateText.measuredWidth + isShowText.measuredWidth
                val maxWidth = screenWidth - (extraWidth + dpToPx(binding.root.context, 60))
                messageText.maxWidth = maxWidth
            }
        }
    }

    class OtherChatViewHolder(private val binding: OtherChatItemBinding):
        ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.apply{
                messageText.text = chat.massage
                dateText.text = chat.date
                isShowText.visibility = View.INVISIBLE

                dateText.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
                isShowText.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)

                val screenWidth = Resources.getSystem().displayMetrics.widthPixels
                val extraWidth = dateText.measuredWidth + isShowText.measuredWidth
                val maxWidth = screenWidth - (extraWidth + dpToPx(binding.root.context, 60))
                messageText.maxWidth = maxWidth
            }
        }
    }

}