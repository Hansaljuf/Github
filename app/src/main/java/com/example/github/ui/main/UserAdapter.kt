package com.example.github.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.github.databinding.UserItemBinding
import com.example.github.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val list = ArrayList<User>()
    private var onItemClickCallback: OnItemClickCallback? = null


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(users: ArrayList<User>){
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()

    }
    inner class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(user)
            }
            binding.apply {
                Glide.with(itemView)
                    .load(user.avatarUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(imgItemPhoto)
                tvItemName.text = user.login
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: User)
    }

}