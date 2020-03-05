package com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.impl

import com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.GetStudents
import com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.repository.StudentRepository
import com.fbiankevin.reactive.springbootreactiverestcrudexample.response.StudentResource
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class GetStudentsImpl(
        private val studentRepository: StudentRepository
) : GetStudents {
    override fun execute(): Flux<StudentResource> {
        return studentRepository.findAll()
                .map { StudentResource(
                        it.id,
                        it.name,
                        it.age,
                        it.createdDate
                ) }
    }
}