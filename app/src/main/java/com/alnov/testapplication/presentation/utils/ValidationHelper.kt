package com.alnov.testapplication.presentation.utils

import android.util.Patterns
import androidx.annotation.StringRes
import com.afollestad.vvalidator.field.input.InputLayoutField

object ValidationHelper {

    fun InputLayoutField.assertNotEmpty(@StringRes stringRes: Int = -1) {
        if (stringRes != -1) isNotEmpty().description(stringRes)
        else isNotEmpty().description("Input your ${this.view.hint}")
    }

    fun InputLayoutField.assertEmail() {
        assert("Invalid email format") {
            Patterns.EMAIL_ADDRESS.matcher(it.editText?.text.toString()).matches()
        }
    }
}