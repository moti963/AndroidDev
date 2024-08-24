package com.motiky.woof.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Doginfo(
    @DrawableRes val dogImageId: Int,
    @StringRes val dogNameId: Int,
    val dogAge: Int,
    @StringRes val hobbiesId: Int
)
