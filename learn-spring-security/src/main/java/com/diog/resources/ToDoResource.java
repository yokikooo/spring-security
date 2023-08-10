package com.diog.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<Todo> TODO_LIST = List.of(new Todo("in28minutes", "Learn AWS"),
            new Todo("in28minutes", "Get AWS Certificate"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){

        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username){

        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForSpecificUser(@PathVariable String username,
                                           @RequestBody Todo todo){
        logger.info("Creating {} for {}", username, todo);
    }
}

record Todo(String username, String description){}
