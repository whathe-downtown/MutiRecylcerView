package com.example.mutirecylcerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mutirecylcerview.databinding.ItemView2Binding
import com.example.mutirecylcerview.databinding.ItemView3Binding
import com.example.mutirecylcerview.databinding.ItemViewBinding

class MultiviewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<MultiData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        val view : View?
        return when(viewType) {
            multi_type1 -> {
                val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return  MultiViewHolder1(binding)
            }
            multi_type2 -> {
                val binding = ItemView2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
                return  MultiViewHolder2(binding)
            }
            else -> {
                val binding = ItemView3Binding.inflate(LayoutInflater.from(parent.context),parent,false)
                return  MultiViewHolder3(binding)
            }
        }
    }
    override fun getItemCount(): Int = datas.size

    override fun getItemViewType(position: Int): Int {
        return datas[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(datas[position].type) {
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(datas[position])
                holder.setIsRecyclable(false)
            }
            multi_type2 -> {
                (holder as MultiViewHolder2).bind(datas[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as MultiViewHolder3).bind(datas[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    inner class MultiViewHolder1(private val binding:ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {



        fun bind(item: MultiData) {
            binding.tvRvName.text = item.name
            binding.tvRvAge.text = item.age.toString()
            Glide.with(binding.root).load(item.image).into(binding.imgRvPhoto)

        }
    }
    inner class MultiViewHolder2(private val binding: ItemView2Binding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: MultiData) {
            binding.tvRvName.text = item.name
            binding.tvRvAge.text = item.age.toString()
            Glide.with(binding.root).load(item.image).into(binding.imgRvPhoto)

        }
    }

    inner class MultiViewHolder3(private val binding: ItemView3Binding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: MultiData) {
            binding.tvRvName.text = item.name
            Glide.with(binding.root).load(item.image).into(binding.imgRvPhoto)

        }
    }
}