package controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.FilmService;

/**
 * Controller to delete film from database if it exists.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Controller
public class DeleteFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;

	/**
	 * GET REQUEST to /deletefilm directed here.
	 * @param id of Film to be deleted.
	 * @return String object containing 
	 */
	@RequestMapping(value = "/deletefilm", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteFilmFormSubmit(@RequestParam("id") String id) {
		// Delete film based on received ID
		return filmService.deleteFilm(Integer.parseInt(id))
			   + "<h3><br>Film with id " + id + " deleted successfully</h3>"
			   + "<br><a href=\"https://filmsapi.appspot.com\">Home</a>";
	}
}