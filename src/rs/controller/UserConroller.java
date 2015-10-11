package rs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.model.User;

@RestController
@RequestMapping("/user")
public class UserConroller extends GenericController<User> {

}
