package com.motiky.woof.data

import com.motiky.woof.R
import com.motiky.woof.model.Doginfo

object Datasource {
    val dogs = listOf(
        Doginfo(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1),
        Doginfo(R.drawable.lola, R.string.dog_name_2, 16, R.string.dog_description_2),
        Doginfo(R.drawable.frankie, R.string.dog_name_3, 2, R.string.dog_description_3),
        Doginfo(R.drawable.nox, R.string.dog_name_4, 8, R.string.dog_description_4),
        Doginfo(R.drawable.faye, R.string.dog_name_5, 8, R.string.dog_description_5),
        Doginfo(R.drawable.bella, R.string.dog_name_6, 14, R.string.dog_description_6),
        Doginfo(R.drawable.moana, R.string.dog_name_7, 2, R.string.dog_description_7),
        Doginfo(R.drawable.tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),
        Doginfo(R.drawable.leroy, R.string.dog_name_9, 4, R.string.dog_description_9),
    )
}