package com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.impl

import com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.CreateStudent
import com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.entity.StudentDocument
import com.fbiankevin.reactive.springbootreactiverestcrudexample.persistence.repository.StudentRepository
import com.fbiankevin.reactive.springbootreactiverestcrudexample.request.StudentForm
import com.fbiankevin.reactive.springbootreactiverestcrudexample.response.StudentResource
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CreateStudentImpl(
        private val studentRepository: StudentRepository
) : CreateStudent {
    override fun execute(studentForm: StudentForm): Mono<StudentResource> {


        var entity = StudentDocument(
                name = studentForm.name,
                age = studentForm.age
        )


        return studentRepository.save(entity)
                .map {
                    StudentResource(
                            id = it.id,
                            name = it.name,
                            age = it.age
                    )
                }


    }
}