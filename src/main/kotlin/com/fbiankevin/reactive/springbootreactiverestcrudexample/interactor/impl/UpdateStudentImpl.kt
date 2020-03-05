package com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.impl

import com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.UpdateStudent
import com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.entity.StudentDocument
import com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.repository.StudentRepository
import com.fbiankevin.reactive.springbootreactiverestcrudexample.request.StudentForm
import com.fbiankevin.reactive.springbootreactiverestcrudexample.response.StudentResource
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class UpdateStudentImpl(
        private val studentRepository: StudentRepository
) : UpdateStudent {
    override fun execute(studentForm: StudentForm): Mono<StudentResource> {

        if( studentForm.id.isNullOrEmpty() ){
            throw RuntimeException("Please specify the student ID to update")
        }


        return studentRepository.findById(studentForm.id)
                .switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap {
                    it.age = studentForm.age
                    it.name = studentForm.name
                    studentRepository.save(it)
                }.map {
                    StudentResource(
                            id = it.id,
                            age = it.age,
                            name = it.name,
                            createdDate = it.createdDate
                    )
                }

    }
}