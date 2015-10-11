package rs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.model.LoginRequest;

@RestController
@RequestMapping("/login")
public class LoginController extends GenericController<LoginRequest> {
	
}
