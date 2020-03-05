package com.fbiankevin.reactive.springbootreactiverestcrudexample.request

import java.util.*

data class StudentForm(
        val id: String?,
        var name: String?,
        var age: Int?
)