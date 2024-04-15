package ru.allaber.shoppinglist.domain.usecase

import ru.allaber.shoppinglist.domain.model.ShopItem
import ru.allaber.shoppinglist.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(item: ShopItem) {
        shopListRepository.addShopItem(item = item)
    }
}
