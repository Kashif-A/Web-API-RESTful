package controller;

import javax.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * RestController to serve 'create.jsp', 'read.jsp', 'update.jsp' and 'delete.jsp'.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@RestController
public class CRUDController extends HttpServlet {
	private static final long serialVersionUID = -4514966525022166356L;
	
	/**
	 * GET REQUEST to /create directed here.
	 * @return 'create.jsp' View.
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("create");
		return view;
    }	
	
	/**
	 * GET REQUEST to /read directed here.
	 * @return 'read.jsp' View.
	 */
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public ModelAndView read() {
		ModelAndView view = new ModelAndView("read");
		return view;
    }	
	
	/**
	 * GET REQUEST to /update directed here.
	 * @return 'update.jsp' View.
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update() {
		ModelAndView view = new ModelAndView("update");
		return view;
    }	
	
	/**
	 * GET REQUEST to /delete directed here.
	 * @return 'delete.jsp' View.
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete() {
		ModelAndView view = new ModelAndView("delete");
		return view;
    }	
	
	/**
	 * GET REQUESTS to /CRUD directed to here. Serves 'CRUD.jsp'.
	 * @return 'CRUD.jsp' View.
	 */
	@RequestMapping(value = "CRUD", method = RequestMethod.GET)
	public ModelAndView crud() {
		ModelAndView view = new ModelAndView("CRUD");
		return view;
    }	
}