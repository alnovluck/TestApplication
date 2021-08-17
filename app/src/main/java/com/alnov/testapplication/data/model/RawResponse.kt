package com.alnov.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class RawResponse(
    @SerializedName("IDR")
    val rawDetail: RawDetailResponse
)