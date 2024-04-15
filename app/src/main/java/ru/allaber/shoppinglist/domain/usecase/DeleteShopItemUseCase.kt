package ru.allaber.shoppinglist.domain.usecase

import ru.allaber.shoppinglist.domain.model.ShopItem
import ru.allaber.shoppinglist.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopList(item: ShopItem) {
        shopListRepository.deleteShopList(item = item)
    }
}
