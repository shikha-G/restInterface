package rs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.model.Group;

@RestController
@RequestMapping("/group")
public class GroupController extends GenericController<Group> {

}
