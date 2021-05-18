package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "jpj", "Finish the Angular Tutorial", new Date(), false));
        todos.add(new Todo(++idCounter, "jpj", "Youtube Videos", new Date(), true));
        todos.add(new Todo(++idCounter, "jpj", "Website", new Date(), false));
        todos.add(new Todo(++idCounter, "jpj", "Visit India", new Date(), false));
    }

    public Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        } else{
            this.deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteById(long id){

        Todo todo = findById(id);

        if(todo == null){
            return null;
        }

        if(todos.remove(todo)){
            return todo;
        }

        return null;

    }

    public Todo findById(long id){
        for(Todo todo:todos){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

}
