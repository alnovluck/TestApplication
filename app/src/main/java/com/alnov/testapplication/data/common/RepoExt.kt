package com.alnov.testapplication.data.common

import com.alnov.testapplication.data.mapper.Mapper
import com.alnov.testapplication.domain.common.Result
import com.alnov.testapplication.domain.common.SimpleError
import com.alnov.testapplication.domain.common.SimpleResult

fun <Response, Model> SimpleResponse<Response>.mapToResult(mapper: Mapper<Response, Model>): SimpleResult<Model> {
    return when {
        this.isSuccessful -> {
            val body = this.body()
            when {
                body?.data != null -> {
                    val mappedResult = mapper.mapFromResponse(body.data)
                    Result.Success.Data(mappedResult)
                }
                body?.message.equals("Success") -> {
                    Result.Success.NoData
                }
                else -> {
                    Result.Failure(SimpleError("Success but unknown failure"))
                }
            }
        }
        else -> Result.Failure(SimpleError(this.errorBody()?.string().orEmpty()))
    }
}