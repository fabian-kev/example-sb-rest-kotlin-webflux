package com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@TypeAlias("student")
@Document(collection = "student")
data class StudentDocument(
        @Id
        var id: String? = null,
        var name: String?,
        var age: Int?,
        var createdDate: Date? = null
)