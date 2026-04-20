package com.mbuh.project_food_app.ViewModel

import androidx.lifecycle.LiveData
import com.mbuh.project_food_app.Domain.CategoryModel
import com.mbuh.project_food_app.Repository.MainRepository

class MainViewModel {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }
}