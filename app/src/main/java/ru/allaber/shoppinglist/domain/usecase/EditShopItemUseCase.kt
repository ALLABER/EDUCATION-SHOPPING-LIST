package ru.allaber.shoppinglist.domain.usecase

import ru.allaber.shoppinglist.domain.model.ShopItem
import ru.allaber.shoppinglist.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopList(item: ShopItem) {
        shopListRepository.editShopList(item = item)
    }
}
