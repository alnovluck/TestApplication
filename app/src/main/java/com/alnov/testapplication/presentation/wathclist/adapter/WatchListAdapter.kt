package com.alnov.testapplication.presentation.wathclist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alnov.testapplication.domain.model.CryptoModel
import com.alnov.testapplication.R
import com.alnov.testapplication.databinding.ItemWatchListBinding
import com.alnov.testapplication.presentation.utils.NumberHelper
import com.alnov.testapplication.presentation.utils.addPrefix
import com.alnov.testapplication.presentation.utils.changeTextColor

class WatchListAdapter(
    private val onBottomReached: () -> Unit
) : ListAdapter<CryptoModel, RecyclerView.ViewHolder>(CryptoItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemWatchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun submitList(list: List<CryptoModel>?) {
        super.submitList(if (list != null) list else null)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(getItem(position))
        }
        if (position == itemCount - 1) {
            onBottomReached()
        }
    }

    inner class ItemViewHolder(private val binding: ItemWatchListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cryptoModel: CryptoModel) {
            with(binding) {
                textViewCode.text = cryptoModel.name
                textViewCompanyName.text = cryptoModel.fullName
                textViewPriceChange.changeTextColor(cryptoModel.changePrice, itemView.context)
                textViewPrice.text = NumberHelper.formatPrice(cryptoModel.currentPrice)
                val changePercentage =
                    NumberHelper.formatPriceChanges(cryptoModel.changePricePercent).addPrefix()
                val changePrice =
                    NumberHelper.formatPriceChanges(cryptoModel.changePrice).addPrefix()
                textViewPriceChange.text =
                    itemView.context.getString(R.string.changes_info, changePrice, changePercentage)
            }
        }
    }

    class CryptoItemDiffCallback : DiffUtil.ItemCallback<CryptoModel>() {
        override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
            return oldItem == newItem
        }
    }
}
