package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("EnglishName")
    val englishName: String? = null,
    @SerializedName("ID")
    val iD: String? = null,
    @SerializedName("LocalizedName")
    val localizedName: String? = null
)