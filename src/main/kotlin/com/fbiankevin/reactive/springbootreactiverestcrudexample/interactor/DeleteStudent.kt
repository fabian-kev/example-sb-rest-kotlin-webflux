package com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor

import com.fbiankevin.reactive.springbootreactiverestcrudexample.response.StudentResource
import reactor.core.publisher.Mono

interface DeleteStudent {
    fun execute(id:String): Mono<StudentResource>
}