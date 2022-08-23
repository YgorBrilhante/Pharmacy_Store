package com.example.farmatec

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.farmatec.Adapter.MyFragmentPageAdapter
import com.example.farmatec.databinding.ActivityMainBinding
import com.example.farmatec.ui.main.Product
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = MyFragmentPageAdapter(this.supportFragmentManager, resources.getStringArray(R.array.titles_tab), listOf(
            Product()
        ));
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener {
            val intent = Intent(applicationContext, CarrinhoActivity::class.java);
            startActivity(intent)
        }
    }
}