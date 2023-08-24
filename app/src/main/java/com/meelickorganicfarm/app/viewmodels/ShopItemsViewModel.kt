package com.meelickorganicfarm.app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meelickorganicfarm.app.data.Item
import com.meelickorganicfarm.app.data.ItemRepository
import kotlinx.coroutines.launch

class ShopItemsViewModel : ViewModel() {
    private val repository = ItemRepository()

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    fun fetchVegetableItems() {
        viewModelScope.launch {
            try {
                val items = repository.getVegetableItems()
                _items.value = items
            } catch (e: Exception) {
                e.message?.let { Log.e("ShopItemsViewModel", it) }
            }
        }
    }
}