package com.meelickorganicfarm.app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.meelickorganicfarm.app.data.ItemRepository
import com.meelickorganicfarm.app.data.ShopItem
import kotlinx.coroutines.launch

class ShopItemsViewModel(
    private val itemRepository: ItemRepository
) : ViewModel() {
    private val _items = MutableLiveData<List<ShopItem>>()
    val items: LiveData<List<ShopItem>> = _items

    fun fetchShopItems() {
        viewModelScope.launch {
            try {
                val items = itemRepository.getShopItems()
                _items.value = items
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }

    companion object {
        val TAG: String = this::class.java.simpleName
    }
}

@Suppress("UNCHECKED_CAST")
class ShopItemsViewModelFactory(private val itemRepository: ItemRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShopItemsViewModel(itemRepository) as T
    }
}