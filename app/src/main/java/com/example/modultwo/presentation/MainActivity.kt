package com.example.modultwo.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.modultwo.R
import com.example.modultwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuItemAdapter.Listener {

    private lateinit var mainactivity: ActivityMainBinding

    private var list = listOf(
        MenuItem(0, R.drawable.discussion, "Обсуждения"),
        MenuItem(1, R.drawable.selection, "Подборка"),
        MenuItem(2, R.drawable.heart, "Избранное")
    )
    private val adapter = MenuItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainactivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainactivity.root)

        mainactivity.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        mainactivity.recyclerView.adapter = adapter
        adapter.addMenu(list)
    }

    override fun onClick(itemId: Int) {
        when (itemId) {
            0 -> {
                startActivity(Intent(this@MainActivity, ChatListActivity::class.java))
            }
            1 -> {
                startActivity(Intent(this@MainActivity, MoviesActivity::class.java))
            }
        }
    }
}