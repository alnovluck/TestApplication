package com.alnov.testapplication.data.mapper

interface Mapper<Response, Model> {

    fun mapFromResponse(response: Response?): Model
}
