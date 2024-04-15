package ru.allaber.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import ru.allaber.shoppinglist.data.repository.ShopListRepositoryImpl
import ru.allaber.shoppinglist.domain.model.ShopItem
import ru.allaber.shoppinglist.domain.usecase.DeleteShopItemUseCase
import ru.allaber.shoppinglist.domain.usecase.EditShopItemUseCase
import ru.allaber.shoppinglist.domain.usecase.GetShopListUseCase

class MainViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(item: ShopItem) {
        deleteShopItemUseCase.deleteShopList(item = item)
    }

    fun editShopItem(item: ShopItem) {
        val newItem =
            item.copy(
                enabled = !item.enabled,
            )
        editShopItemUseCase.editShopList(item = newItem)
    }
}
