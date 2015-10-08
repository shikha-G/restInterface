package rs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.model.MyModel;

@RestController
@RequestMapping("/model")
public class MyController extends GenericController<MyModel>{

    
    
}
