package com.cubidevs.mobiedbapp2022.server.model


import com.google.gson.annotations.SerializedName

data class Imperial(
    @SerializedName("Unit")
    val unit: String? = null,
    @SerializedName("UnitType")
    val unitType: Int? = null,
    @SerializedName("Value")
    val value: Double? = null
)