package com.khairo.dotassignment.ui.repos

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khairo.dotassignment.R
import com.khairo.dotassignment.common.App
import com.khairo.dotassignment.data.models.repo.Repo
import com.khairo.dotassignment.data.repositories.repo.RepoRepository
import com.khairo.utils.ResponseHelper
import com.khairo.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ReposViewModel @ViewModelInject constructor(private val repository: RepoRepository) :
    ViewModel() {

    val isLoading = ObservableField(false)

    val repos = MutableLiveData<List<Repo>?>().apply {
        isLoading.set(true)
        viewModelScope.launch(Dispatchers.IO) {
            postValue(repository.getRepos()).apply { isLoading.set(false) }
        }
    }
}
