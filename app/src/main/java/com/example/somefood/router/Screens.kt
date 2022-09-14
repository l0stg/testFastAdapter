package com.example.somefood.ui

import com.example.somefood.data.model.ProductListModel
import com.example.somefood.ui.FavoriteFood.FavoriteFoodFragment
import com.example.somefood.ui.Registration.RegistrationFragment
import com.example.somefood.ui.detailFood.DetailFoodFragment
import com.example.somefood.ui.fragmentAchievment.adapters.AchievmentFragment
import com.example.somefood.ui.helloScreen.HelloScreenFragment
import com.example.somefood.ui.historyOrderFragment.HistoryOrderFragment
import com.example.somefood.ui.orderBasket.OrderBasketFragment
import com.example.somefood.ui.orderByCreator.OrderByCreatorFragment
import com.example.somefood.ui.orderList.CreatorListFragment
import com.example.somefood.ui.productListClient.ProductListClientFragment
import com.example.somefood.ui.profile.ProfileFragment
import com.example.somefood.ui.signIn.SignInFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Screens {

    fun routeToHelloScreenFragment() = FragmentScreen { HelloScreenFragment() }
    fun openSignIn() = FragmentScreen { SignInFragment() }
    fun openRegistration() = FragmentScreen { RegistrationFragment() }
    fun routeToProductList() = FragmentScreen { ProductListClientFragment.newInstance() }
    fun routeToDetail(model: ProductListModel) =
        FragmentScreen { DetailFoodFragment.newInstance(model) }
    fun routeToFavorite() = FragmentScreen { FavoriteFoodFragment.newInstance() }
    fun routeToCreatorList() = FragmentScreen { CreatorListFragment() }
    fun routeToBascet() = FragmentScreen { OrderBasketFragment.newInstance() }
    fun routeToOrderByCreator() = FragmentScreen { OrderByCreatorFragment() }
    fun routeToProfile() = FragmentScreen { ProfileFragment() }
    fun routeToHistoryOrder() = FragmentScreen { HistoryOrderFragment.newInstance() }
    fun routeToAchievment() = FragmentScreen { AchievmentFragment() }
}