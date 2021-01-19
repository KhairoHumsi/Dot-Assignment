package com.khairo.dotassignment.ui.repoDetails

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khairo.dotassignment.data.models.contributors.Contributors
import com.khairo.dotassignment.data.repositories.repoDetails.RepoDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReposDetailsViewModel @ViewModelInject constructor(private val repository: RepoDetailsRepository) :
    ViewModel() {

    val isLoading = ObservableField(false)

    val contributors = MutableLiveData<List<Contributors>?>()

    fun getContributors(path: String) {
        isLoading.set(true)
        viewModelScope.launch(Dispatchers.IO) {
            contributors.postValue(repository.getContributors(path = path)).apply {
                isLoading.set(false)
            }
        }
    }
}
