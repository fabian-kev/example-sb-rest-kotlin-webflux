package com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.impl

import com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.DeleteStudent
import com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.repository.StudentRepository
import com.fbiankevin.reactive.springbootreactiverestcrudexample.response.StudentResource
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DeleteStudentImpl(
        private val studentRepository: StudentRepository
) : DeleteStudent {
    override fun execute(id: String): Mono<StudentResource> {
        return studentRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap {
                    studentRepository.delete(it).then(Mono.just(it))
                }
                .map {
                    StudentResource(
                            id = it.id,
                            age = it.age,
                            name = it.name,
                            createdDate = it.createdDate
                    )
                }
    }
}