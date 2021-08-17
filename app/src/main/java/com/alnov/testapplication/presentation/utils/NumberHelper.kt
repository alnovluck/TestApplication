package com.alnov.testapplication.presentation.utils

import java.text.DecimalFormat

object NumberHelper {

    fun formatPriceChanges(value: Double): String {
        return DecimalFormat("##.##").format(value)
    }

    fun formatPrice(value: Double): String {
        return DecimalFormat("#,###").format(value)
    }
}