package com.example.modultwo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modultwo.R
import com.example.modultwo.databinding.ActivityChatListBinding

class ChatListActivity : AppCompatActivity() {

    private lateinit var chatlist: ActivityChatListBinding
    private var list = listOf(
        Chat("Lucifer"),
        Chat("The Witcher"),
        Chat("LOST"),
        Chat("The Magicans")
    )
    private val adapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatlist = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(chatlist.root)

        chatlist.Chats.layoutManager = LinearLayoutManager(this@ChatListActivity)
        chatlist.Chats.adapter = adapter
        adapter.addChats(list)
    }
}