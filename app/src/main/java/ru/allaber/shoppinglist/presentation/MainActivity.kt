package ru.allaber.shoppinglist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.allaber.shoppinglist.R
import ru.allaber.shoppinglist.domain.model.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var llShopList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llShopList = findViewById(R.id.llShopList)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            showList(it)
        }
    }

    private fun showList(list: List<ShopItem>) {
        llShopList.removeAllViews()
        for (shopItem in list) {
            val layoutId =
                if (shopItem.enabled) {
                    R.layout.item_shop_enabled
                } else {
                    R.layout.item_shop_disabled
                }
            val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
            val tvName = view.findViewById<TextView>(R.id.tvName)
            val tvCount = view.findViewById<TextView>(R.id.tvCount)
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()

            view.setOnLongClickListener {
                viewModel.changeEnableState(shopItem)
                true
            }
            llShopList.addView(view)
        }
    }
}
