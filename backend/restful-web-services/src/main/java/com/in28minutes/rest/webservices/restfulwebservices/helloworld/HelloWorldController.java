package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
public class HelloWorldController {

    @GetMapping(path="hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        //throw new RuntimeException("There is an error here");
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path="hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello world, " + name);
    }
}
