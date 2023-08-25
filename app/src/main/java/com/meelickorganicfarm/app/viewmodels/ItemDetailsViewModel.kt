package com.meelickorganicfarm.app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meelickorganicfarm.app.data.ItemRepository
import com.meelickorganicfarm.app.data.ShopItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val itemRepository: ItemRepository
) : ViewModel() {
    private val shopItemId: Int = checkNotNull(savedStateHandle["shopItemId"])

    private val _item = MutableLiveData<ShopItem>()
    val item: LiveData<ShopItem> = _item

    fun fetchItemDetails() {
        Log.d(
            ItemDetailsViewModel::class.java.simpleName,
            "Fetching item details for id: $shopItemId"
        )
        viewModelScope.launch {
            try {
                val item = itemRepository.getItemDetails(shopItemId)
                _item.value = item
            } catch (e: Exception) {
                Log.e(this@ItemDetailsViewModel::class.java.simpleName, e.message.toString())
            }
        }
    }
}