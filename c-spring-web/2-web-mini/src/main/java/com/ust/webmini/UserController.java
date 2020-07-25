package com.ust.webmini;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

// @Controller is a specialization of @Component
@RestController // @Controller plus @ResponseBody; >> returns a string or a domain object, not a view like a @Controller
// simply returns the object and object data is directly written into HTTP response as JSON or XML.

@RequestMapping("users") // careful with /
public class UserController {

    //------------------ GET  -----------------------------------

    @GetMapping("/help")
    public String showHelp() {
        return "Here is a help page";
    }

    @GetMapping // works for ("") by default. Will not work for("/")
    public List<User> getAllUsers() {
        return Arrays.asList(new User(1L, "Elle"), new User(2L, "Tracy"));
    }

    @GetMapping(value = "/{id}", // produces = MediaType.APPLICATION_JSON_VALUE (=application/json)
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable String id) {
        return new User(Long.parseLong(id), "John IDpassedByPAthVariable");
    }

    //------------------ POST, PUT, DELETE, PATCH  -----------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postUser(@RequestBody User user) {
        //  { "name": "Darek", "id": 1 } in Postman set: Body/raw/ application/json
        return user.getName() + " with id " + user.getId() + " saved";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateUser(@RequestBody User user) {
        return user.getName() + " with id " + user.getId() + " updated";
    }

    @DeleteMapping(value = "/{id}") // careful with {...}
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable String id) {
        return "User with " + id + " deleted";
    }

    @RequestMapping(path = "extra", method = RequestMethod.PATCH)
    public String extra() {

        return "Extra called";
    }
}
