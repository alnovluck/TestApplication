package com.alnov.testapplication.domain.common

data class SimpleError(
    var errorMessage: String = ""
) : Error()