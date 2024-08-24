package com.motiky.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicId: Int,
    val noOfCourses: Int,
    @DrawableRes val topicImageId: Int
)
