package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class RatingResponse(
    @SerializedName("Weiss")
    val weiss: WeissResponse
)