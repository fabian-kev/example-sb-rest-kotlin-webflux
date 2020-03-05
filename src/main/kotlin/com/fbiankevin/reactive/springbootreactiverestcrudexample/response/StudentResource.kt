package com.fbiankevin.reactive.springbootreactiverestcrudexample.response

import java.util.*

data class StudentResource(
        var id: String? = null,
        var name: String?,
        var age: Int?,
        var createdDate: Date? = null
)