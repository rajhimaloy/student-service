package com.erp.studentservice.controllers;

import com.erp.studentservice.model.Student;
import com.erp.studentservice.services.iservices.IHelloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
 * Author: Rajib Kumer Ghosh
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private IHelloServices iHelloServices;


    /*GET http://localhost:8080/api/rest/hello/getbyid?id=1001&age=38*/
    @GetMapping("/getbyid")
    public String getByID(@RequestParam("id") Integer id, @RequestParam("age") Integer age) {
        return "Student: " + id + ", Name: Rajib, Age: " + age;
    }

    /*GET http://localhost:8080/api/rest/hello/getbyname/Rajib*/
    @GetMapping("/getbyname/{name}")
    public ResponseEntity<String> getByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(iHelloServices.getByName(name), HttpStatus.OK);
    }

    /*POST http://localhost:8080/api/rest/hello/createstudent
    {
        "id":"1",
        "name": "Rajib Kumer Ghosh",
        "age": 35
    }*/
    @PostMapping("/createstudent")
    public String createStudent(@RequestBody Student student) {
        return iHelloServices.createStudent(student);
    }

    /*PUT http://localhost:8080/api/rest/hello/updatestudent
    {
        "id":"1",
        "name": "Rajib Kumer Ghosh",
        "age": 38
    }*/
    @PutMapping("/updatestudent")
    public String updateStudent(@RequestBody Student student) {
        return iHelloServices.updateStudent(student);
    }

    /*PATCH http://localhost:8080/api/rest/hello/updatestudentage/1001
    {
        "age": 39
    }*/
    @PatchMapping("/updatestudentage/{id}")
    public String updateStudentAge(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        Integer age = (Integer) updates.get("age");
        return iHelloServices.updateStudentAge(id, age);
    }

    /*PATCH http://localhost:8080/api/rest/hello/updatestudentpartial/1001
    {
        "name": "Rajib Kumer Ghosh",
        "age": 39
    }*/
    @PatchMapping("/updatestudentpartial/{id}")
    public String updateStudentPartial(@PathVariable Integer id, @RequestBody Map<String, Object> student) {
        return iHelloServices.updateStudentPartial(id, student);
    }

    /*DELETE http://localhost:8080/api/rest/hello/deletestudent
    {
        "id":"1",
        "name": "Rajib Kumer Ghosh",
        "age": 39
    }*/
    @DeleteMapping("/deletestudent")
    public String deleteStudent(@RequestBody Student student) {
        return iHelloServices.deleteStudent(student);
    }
}
