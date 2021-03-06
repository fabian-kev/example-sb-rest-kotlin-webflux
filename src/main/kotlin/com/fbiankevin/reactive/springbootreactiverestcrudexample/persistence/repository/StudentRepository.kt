package com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.repository

import com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.entity.StudentDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface StudentRepository : ReactiveMongoRepository<StudentDocument, String>