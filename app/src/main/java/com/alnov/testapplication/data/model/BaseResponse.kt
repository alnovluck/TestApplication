package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("Type")
    var type: Int? = 0,
    @SerializedName("Data")
    var data: T? = null,
    @SerializedName("Message")
    var message: String? = "",
    @SerializedName("SponsoredData")
    var sponsoredData: List<SponsoredDataResponse>? = null,
    @SerializedName("RateLimit")
    var rateLimit: RateLimitResponse? = null,
    @SerializedName("HasWarning")
    var hasWarning: Boolean? = false
)