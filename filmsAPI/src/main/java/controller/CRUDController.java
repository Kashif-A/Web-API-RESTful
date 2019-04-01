package controller;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to serve 'create.jsp', 'read.jsp', 'update.jsp' and 'delete.jsp'.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Controller
public class CRUDController extends HttpServlet {
	private static final long serialVersionUID = -4514966525022166356L;
	/**
	 * GET REQUEST to /create directed here.
	 * @return 'create.jsp' page.
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create() {
		return "create";
    }	
	
	/**
	 * GET REQUEST to /read directed here.
	 * @return 'read.jsp' page.
	 */
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String read() {
		return "read";
    }	
	
	/**
	 * GET REQUEST to /update directed here.
	 * @return 'update.jsp' page.
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update() {
		return "update";
    }	
	
	/**
	 * GET REQUEST to /delete directed here.
	 * @return 'delete.jsp' page.
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete() {
		return "delete";
    }	
	
	/**
	 * GET REQUESTS to /CRUD directed to here. Serves 'CRUD.jsp'.
	 * @return 'CRUD.jsp' page.
	 */
	@RequestMapping(value = "CRUD", method = RequestMethod.GET)
	public String crud() {
		return "CRUD";
    }	
}