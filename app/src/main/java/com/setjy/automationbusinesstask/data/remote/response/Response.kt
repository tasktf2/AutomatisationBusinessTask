package com.setjy.automationbusinesstask.data.remote.response

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.google.gson.annotations.SerializedName
import com.setjy.automationbusinesstask.domain.model.Product
import com.setjy.automationbusinesstask.domain.model.Store

data class GoodsRemote(
    @SerializedName("Наименование") val name: String,
    @SerializedName("Ссылка") val link: String,
    @SerializedName("Цена") val price: Int,
    @SerializedName("Картинка") val image: String
)

data class StoreRemote(
    @SerializedName("Наименование") val name: String,
    @SerializedName("Долгота") val longitude: Double,
    @SerializedName("Широта") val latitude: Double,
    @SerializedName("Адрес") val address: String
)

fun GoodsRemote.toDomain() = Product(
    productName = name,
    productLink = link,
    productPrice = price,
    productImage = mapBase64ToBitmap(image)
)

fun StoreRemote.toDomain() = Store(
    storeName = name,
    storeAddress = address,
    storeLongitude = longitude,
    storeLatitude = latitude
)

fun mapBase64ToBitmap(image: String): Bitmap? {
    val decodedBytes: ByteArray = Base64.decode(image, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
}