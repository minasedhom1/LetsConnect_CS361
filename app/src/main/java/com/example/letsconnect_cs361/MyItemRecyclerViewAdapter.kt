package com.example.letsconnect_cs361

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

import com.example.letsconnect_cs361.placeholder.PlaceholderContent.PlaceholderItem
import com.example.letsconnect_cs361.databinding.FragmentGroupListBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
    private val onClick: (PlaceholderItem) -> Unit)
    : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentGroupListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_groupList_to_belovedsFragment)
        )
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentGroupListBinding,  val onClick: (PlaceholderItem) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        private var currentItem: PlaceholderItem? = null

//        init {
//            itemView.setOnClickListener {
//                currentItem?.let {
//                    onClick(it)
//                }
//            }
//        }
        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}