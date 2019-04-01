package controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.FilmService;

/**
 * RestController to delete film from database if it exists.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@RestController
public class DeleteFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;

	/**
	 * DELETE REQUEST to /deletefilm/id directed here.
	 * @param id of Film to be deleted.
	 * @return String object containing 
	 */
	@RequestMapping(value = "/deletefilm/id/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String deleteFilmFormSubmit(@PathVariable("id") String id) {
		// Delete film based on received ID
		return filmService.deleteFilm(Integer.parseInt(id))
			   + "<h3><br>Film with id " + id + " deleted successfully</h3>"
			   + "<br><a href=\"https://filmsRESTful.appspot.com\">Home</a>";
	}
}