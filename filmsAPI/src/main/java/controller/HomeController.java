package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class serves the homepage 'index.jsp' to GET requests to the base URL '/'.
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Controller
public class HomeController {
	/**
	 * This method serves the homepage 'index.jsp' to GET requests to the base URL '/'.
	 * @return 'index.jsp' homepage file.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
    }
}
