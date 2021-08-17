package com.alnov.testapplication.data.common

import com.alnov.testapplication.data.model.BaseResponse
import retrofit2.Response

typealias SimpleResponse<T> = Response<BaseResponse<T>>