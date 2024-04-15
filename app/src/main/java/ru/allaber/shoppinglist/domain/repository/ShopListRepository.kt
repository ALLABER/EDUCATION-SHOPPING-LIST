package ru.allaber.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import ru.allaber.shoppinglist.domain.model.ShopItem

interface ShopListRepository {
    fun addShopItem(item: ShopItem)

    fun deleteShopList(item: ShopItem)

    fun editShopList(item: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>
}
