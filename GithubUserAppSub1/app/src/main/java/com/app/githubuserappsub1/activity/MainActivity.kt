package com.app.githubuserappsub1.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.githubuserappsub1.R
import com.app.githubuserappsub1.adapter.DataUserAdapter
import com.app.githubuserappsub1.data.MainViewModel
import com.app.githubuserappsub1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: DataUserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DataUserAdapter()
        adapter.notifyDataSetChanged()
        binding.recviewlist.layoutManager = LinearLayoutManager(this)
        binding.recviewlist.adapter = adapter

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
        mainViewModel.setData(this)
        mainViewModel.getData().observe(this, {
            if (it != null) {
                adapter.setDataAdapter(it)

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.id_share_btn -> {
            val intent: Intent = Intent(Intent.ACTION_SEND).setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, "https://github.com/FauzanNR/Apps")
            startActivity(Intent.createChooser(intent, "Share Via"))
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}