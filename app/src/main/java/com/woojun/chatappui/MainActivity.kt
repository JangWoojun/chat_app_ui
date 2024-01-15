package com.woojun.chatappui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.woojun.chatappui.databinding.ActivityMainBinding
import com.woojun.chatappui.util.Chat
import com.woojun.chatappui.util.ChatAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val chatList = mutableListOf(Chat("안녕하세요!", false, getDate()))
    private val adapter = ChatAdapter(chatList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            chatRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            chatRecycler.adapter = adapter

            backButton.setOnClickListener {
                finish()
            }
            submitButton.setOnClickListener {
                adapter.addChat(Chat(editMessage.text.toString(), true, getDate()))
                chatRecycler.scrollToPosition(adapter.getChat().size - 1)
            }
        }
    }


    private fun getDate(): String {
        try {
            val localDateTime = LocalDateTime.now()
            val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
            val formattedDateTime = localDateTime.format(dateTimeFormatter).toString()

            val timeString = formattedDateTime.substring(8, 12)
            var hour = timeString.substring(0, 2).toInt()
            val minute = timeString.substring(2, 4).toInt()

            val amPmText = if (hour >= 12) "오후 " else "오전 "
            if (hour > 12) hour -= 12

            return "$amPmText${String.format("%02d:%02d", hour, minute)}"
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("시간 변환 오류")
        }
    }

}