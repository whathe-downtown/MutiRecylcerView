package com.example.mutirecylcerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mutirecylcerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var multiAdapter: MultiviewAdapter
    val datas = mutableListOf<MultiData>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycler()
    }

    private fun initRecycler() {
        multiAdapter = MultiviewAdapter(this)
        binding.rvProfile.apply {
            adapter = multiAdapter

        }
        datas.apply {
            add(MultiData(image = R.drawable.unnamed1, name = "mary", age = 24, multi_type3))
            add(MultiData(image = R.drawable.unamed2, name = "jenny", age = 26, multi_type2))
            add(MultiData(image = R.drawable.unnamed3, name = "jhon", age = 27, multi_type1))
            add(MultiData(image = R.drawable.unnamed4, name = "ruby", age = 21, multi_type2))
            add(MultiData(image = R.drawable.unnamed1, name = "yuna", age = 23, multi_type3))

            multiAdapter.datas = datas
            multiAdapter.notifyDataSetChanged()
        }

    }
}