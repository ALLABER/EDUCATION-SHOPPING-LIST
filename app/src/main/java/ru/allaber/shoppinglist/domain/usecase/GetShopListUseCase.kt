package ru.allaber.shoppinglist.domain.usecase

import androidx.lifecycle.LiveData
import ru.allaber.shoppinglist.domain.model.ShopItem
import ru.allaber.shoppinglist.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}
