package controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Film;
import service.FilmService;

/**
 * Controller to update film using Film ID.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Controller
public class UpdateFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;

	/**
	 * GET REQUEST to /updatefilm directed here.
	 * @param id URL parameter.
	 * @param title URL parameter.
	 * @param year URL parameter.
	 * @param director URL parameter.
	 * @param stars URL parameter.
	 * @param review URL parameter.
	 * @return String object to inform user if update was successful or not.
	 */
	@RequestMapping(value = "/updatefilm", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addFilmSubmit(@RequestParam("id") String id,
							    @RequestParam("title") String title,
				  			    @RequestParam("year") String year,
						  	    @RequestParam("director") String director,
							    @RequestParam("stars") String stars,
							    @RequestParam("review") String review) {
		
		// Update film using received ID
		filmService.updateFilm(new Film(title, Integer.valueOf(year), director, stars, review), Integer.valueOf(id));
		return "<h3><br>Film with id " + id + " updated successfully</h3>"
		+ "<br><a href=\"https://filmsapi.appspot.com\">Home</a>";
	}
}