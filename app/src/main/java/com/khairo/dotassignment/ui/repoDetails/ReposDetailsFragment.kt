package com.khairo.dotassignment.ui.repoDetails

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.khairo.bases.data.BaseFragment
import com.khairo.dotassignment.R
import com.khairo.dotassignment.data.models.repo.Repo
import com.khairo.dotassignment.databinding.ReposDetailsFragmentBinding
import com.khairo.utils.SpaceItemDecoration
import com.khairo.utils.dpToPx
import com.khairo.utils.log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReposDetailsFragment :
    BaseFragment<ReposDetailsFragmentBinding>(R.layout.repos_details_fragment) {

    @Inject
    lateinit var adapter: ReposDetailsAdapter
    private lateinit var viewModel: ReposDetailsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReposDetailsViewModel::class.java)

        val repo = requireArguments().getParcelable<Repo>("repo")!!
        TAG.log("onActivityCreated()-> $repo")

        viewModel.getContributors(path = repo.contributorsUrl)
        binding.apply {
            model = repo
            detailsRecycler.apply {
                addItemDecoration(SpaceItemDecoration(1, requireContext().dpToPx(8), true))
                adapter = this@ReposDetailsFragment.adapter
            }
        }

        viewModel.contributors.observe(requireActivity(), {
            adapter.apply {
                setAnimationEnabled(true)
                if (!it.isNullOrEmpty()) setItems(it)
                notifyDataSetChanged()
            }
        })
    }

    companion object {
        const val TAG = "ReposDetailsFragment"
    }
}
