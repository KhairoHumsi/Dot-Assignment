package com.khairo.dotassignment.ui.repos

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.khairo.bases.data.BaseFragment
import com.khairo.dotassignment.R
import com.khairo.dotassignment.databinding.ReposFragmentBinding
import com.khairo.utils.SpaceItemDecoration
import com.khairo.utils.dpToPx
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReposFragment : BaseFragment<ReposFragmentBinding>(R.layout.repos_fragment) {

    @Inject
    lateinit var adapter: ReposAdapter
    private lateinit var viewModel: ReposViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReposViewModel::class.java)

        binding.repoRecycler.apply {
            addItemDecoration(SpaceItemDecoration(1, requireContext().dpToPx(8), true))
            adapter = this@ReposFragment.adapter
        }

        viewModel.repos.observe(requireActivity(), {
            adapter.apply {
                setAnimationEnabled(true)
                if (!it.isNullOrEmpty()) setItems(it)
                notifyDataSetChanged()
            }
        })
    }
}
