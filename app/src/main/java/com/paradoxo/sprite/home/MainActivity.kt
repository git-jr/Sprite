package com.paradoxo.sprite.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.paradoxo.sprite.R
import com.paradoxo.sprite.databinding.ActivityMainBinding
import com.paradoxo.sprite.home.fragments.TabFragment1
import com.paradoxo.sprite.home.fragments.TabFragment2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragment1 = TabFragment1()
    private val fragment2 = TabFragment2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(binding.mainFragment.id, fragment1)
            commit()
        }

        setupTabLayout()

    }

    private fun setupTabLayout() {
        val tabLayout = binding.tabLayout
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

                val selectedFrament = when (tab?.position) {
                    0 -> fragment1
                    1 -> fragment2
                    else -> fragment1
                }
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_fragment, selectedFrament)
                    commit()
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
    }
}