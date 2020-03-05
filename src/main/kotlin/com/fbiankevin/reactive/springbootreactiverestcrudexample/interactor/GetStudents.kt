package com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor

import com.fbiankevin.reactive.springbootreactiverestcrudexample.response.StudentResource
import reactor.core.publisher.Flux

interface GetStudents {
    fun execute(): Flux<StudentResource>
}