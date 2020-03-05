package com.fbiankevin.reactive.springbootreactiverestcrudexample.controller


import com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.CreateStudent
import com.fbiankevin.reactive.springbootreactiverestcrudexample.interactor.GetStudents
import com.fbiankevin.reactive.springbootreactiverestcrudexample.request.StudentForm
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.Duration
import java.time.temporal.ChronoUnit


@RestController
@RequestMapping("/students")
class StudentController(
        private val createStudent: CreateStudent,
        private val getStudents: GetStudents
//        private val updateStudent: UpdateStudent,
//        private val deleteStudent: DeleteStudent
) {

    @PostMapping
    fun createStudent(@RequestBody studentForm: StudentForm) = createStudent.execute(studentForm)

//    @PutMapping
//    fun updateStudent(@RequestBody studentForm: StudentForm) = updateStudent.execute(studentForm)
//
//    @DeleteMapping("/{id}")
//    fun deleteStudent(@PathVariable id:Long) = deleteStudent.execute(id)
//
    @GetMapping
    fun getStudents() = getStudents.execute()


    ///Open your google chrome and enter this http://localhost:8080/students/stream
    @GetMapping("/stream", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getStreamedSatudent() = getStudents.execute().delayElements(Duration.of(1, ChronoUnit.SECONDS))
}