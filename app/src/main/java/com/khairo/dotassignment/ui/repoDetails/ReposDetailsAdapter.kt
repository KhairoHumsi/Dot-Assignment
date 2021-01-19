package com.khairo.dotassignment.ui.repoDetails

import android.view.View
import com.khairo.bases.data.BaseAdapter
import com.khairo.bases.data.BaseViewHolder
import com.khairo.dotassignment.R
import com.khairo.dotassignment.data.models.contributors.Contributors
import com.khairo.dotassignment.databinding.ContributorsItemBinding
import javax.inject.Inject

class ReposDetailsAdapter @Inject constructor() :
    BaseAdapter<Contributors, BaseViewHolder<Contributors>, ContributorsItemBinding>(R.layout.contributors_item) {

    override fun initBinding(view: View) {
        binding = ContributorsItemBinding.bind(view)
    }

    override fun initViewHolder(layout: Int, view: View): BaseViewHolder<Contributors> =
        ViewHolder()

    inner class ViewHolder : ViewHolders(binding = binding) {
        override fun bind(model: Contributors, position: Int) {
            binding.model = model
        }
    }
}
