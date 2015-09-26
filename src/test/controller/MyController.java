package test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.model.MyModel;

@RestController
public class MyController {

    @RequestMapping("/model")
    public MyModel getModel() {
        return new MyModel();
    }
}
