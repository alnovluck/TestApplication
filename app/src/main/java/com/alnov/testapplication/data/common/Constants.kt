package com.alnov.testapplication.data.common

import com.alnov.testapplication.data.model.Subscription

object Constants {

    const val QUERY_PARAM_API_KEY = "api_key"
    const val QUERY_PARAM_LIMIT = "limit"
    const val QUERY_PARAM_PAGE = "page"
    const val QUERY_PARAM_TSYM = "tsym"
    val WEB_SOCKET_SUBSCRIBE_MODEL = Subscription("SubAdd", listOf("21~BTC", "21~ETH"))
}