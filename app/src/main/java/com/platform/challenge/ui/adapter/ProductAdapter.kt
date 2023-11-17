/*
 * Copyright (c) 2023 DevCulture Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * DevCulture Inc. ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with DevCulture Inc.
 */

package com.platform.challenge.ui.adapter;

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.platform.challenge.R
import com.platform.challenge.databinding.ItemProductBinding
import com.platform.challenge.ui.model.ProductUI

class ProductAdapter(val listener: (item: ProductUI, position: Int) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    val listFull = ArrayList<ProductUI>()

    var list: ArrayList<ProductUI> = ArrayList()
        @SuppressLint("NotifyDataSetChanged")
        set(value){
            field = value
            listFull.addAll(list)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ProductViewHolder(view: View, val context: Context): RecyclerView.ViewHolder(view) {
        private val binding = ItemProductBinding.bind(view)
        fun bind(item: ProductUI, position: Int) {
            binding.textViewTitle.text = item.name
            binding.textViewPrice.text = "Precio: $${item.price}"
            Glide.with(binding.imageViewProduct).load(item.image).into(binding.imageViewProduct)
            binding.root.setOnClickListener {
                listener.invoke(item, position)
            }
        }
    }

}
