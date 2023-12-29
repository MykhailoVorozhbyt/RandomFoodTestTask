//package com.example.randomfood.utils
//
//import android.os.Bundle
//import androidx.navigation.NavType
//import com.google.gson.Gson
//
//class AssetParamType<T>(
//    private var model: T
//) : NavType<model>(isNullableAllowed = false) {
//    override fun get(bundle: Bundle, key: String): model? {
//        return bundle.getParcelable(key)
//    }
//
//    override fun parseValue(value: String): model {
//        return Gson().fromJson(value, model::class.java)
//    }
//
//    override fun put(bundle: Bundle, key: String, value: model) {
//        bundle.putParcelable(key, value)
//    }
//}