package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")


public class TestApi {

    @Autowired
    private ActivityDatabase activityDatabase;

    @GetMapping("/test")

//http://localhost:8080/api/test

    public String testApi() {
        return "Hello World!";

        }
        @PostMapping(value = "Activities",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewActivity(@RequestBody Activity activity) {
        activityDatabase.addActivity(activity);
    }
    @GetMapping(value = "Activities",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Activity> getActivitiList(){
        return activityDatabase.getActivityList();

    }

    @DeleteMapping(value = "Activities")
    public void deleteAll(){
        activityDatabase.deleteAll();
    }

}
