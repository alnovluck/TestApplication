package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("Type")
    var type: Int? = 0,
    @SerializedName("Data")
    var data: T? = null,
    @SerializedName("Message")
    var message: String? = "",
)