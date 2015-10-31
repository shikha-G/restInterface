package rs.controller;



/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	/*@ResponseBody
    //@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public List<String> validationErrorHandle(HttpMessageNotReadableException error){
		List<String> fields = new ArrayList<String>();
		error.printStackTrace();
		JsonMappingException ex = (JsonMappingException)error.getCause();
		for (Reference ref : ex.getPath()) {
			fields.add(ref.getFieldName());
		}
		return fields;
	}*/
}
