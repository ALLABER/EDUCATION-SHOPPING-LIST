package ru.allaber.shoppinglist.domain.usecase

import ru.allaber.shoppinglist.domain.model.ShopItem
import ru.allaber.shoppinglist.domain.repository.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(id: Int): ShopItem {
        return shopListRepository.getShopItem(id = id)
    }
}
