package rs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.model.Communication;

@RestController
@RequestMapping("/communication")
public class CommunicationController extends GenericController<Communication> {

}
