package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class SupplementalAdminArea(
    @SerializedName("EnglishName")
    val englishName: String? = null,
    @SerializedName("Level")
    val level: Int? = null,
    @SerializedName("LocalizedName")
    val localizedName: String? = null
)