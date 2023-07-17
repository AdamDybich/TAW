package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")


public class TestApi {

    @Autowired
    private SubjectDatabase subjectDatabase;

    @GetMapping("/test")

//http://localhost:8080/api/test

    public String testApi() {
        return "Hello World!";

        }
        @PostMapping(value = "Subjects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewSubject(@RequestBody Subject activity) {
            subjectDatabase.addSubject(activity);
    }
    @GetMapping(value = "Subjects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subject> getActivitiList(@RequestParam(required = false) Boolean egzamin, @RequestParam(required = false) String sala){
        return subjectDatabase.getSubjectList(egzamin, sala);
    }



    @DeleteMapping(value = "Subjects")
    public void deleteAll(){
        subjectDatabase.deleteAll();
    }

}
