package com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor

import com.fbiankevin.reactive.springbootreactiverestcrudexample.request.StudentForm
import com.fbiankevin.reactive.springbootreactiverestcrudexample.response.StudentResource
import reactor.core.publisher.Mono

interface UpdateStudent {
    fun execute(studentForm:StudentForm): Mono<StudentResource>
}