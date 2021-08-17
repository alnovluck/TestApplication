package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class Subscription(
    @SerializedName("action")
    var action: String,
    @SerializedName("subs")
    var subs: List<String>
)