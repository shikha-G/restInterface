package rs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.model.Rumour;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@RestController
@RequestMapping("/rumour")
public class RumourController extends GenericController<Rumour>{

}
