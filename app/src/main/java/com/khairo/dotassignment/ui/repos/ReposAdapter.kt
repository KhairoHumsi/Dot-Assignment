package com.khairo.dotassignment.ui.repos

import android.view.View
import com.khairo.bases.data.BaseAdapter
import com.khairo.bases.data.BaseViewHolder
import com.khairo.dotassignment.R
import com.khairo.dotassignment.data.models.repo.Repo
import com.khairo.dotassignment.databinding.RepoItemBinding
import com.khairo.dotassignment.ui.main.MainActivity
import javax.inject.Inject

class ReposAdapter @Inject constructor() :
    BaseAdapter<Repo, BaseViewHolder<Repo>, RepoItemBinding>(R.layout.repo_item) {

    override fun initBinding(view: View) {
        binding = RepoItemBinding.bind(view)
    }

    override fun initViewHolder(layout: Int, view: View): BaseViewHolder<Repo> = ViewHolder()

    inner class ViewHolder : ViewHolders(binding = binding) {
        override fun bind(model: Repo, position: Int) {
            binding.let {
                it.model = model
                it.viewHolder = this
            }
        }

        fun check(model: Repo) {
            MainActivity.instance.apply {
                R.id.action_reposFragment_to_reposDetailsFragment.navigate(model = model)
            }
        }
    }
}
