package controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import model.Film;
import service.FilmService;

/**
 * RestController to update film using Film ID.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@RestController
public class UpdateFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;
	private Gson gson = new Gson();

	/**
	 * GET REQUEST to /updatefilm/id directed here.
	 * @param id used to update specific film.
	 * @param film Request body containing update information.
	 * @return JSON String representing updated film.
	 */
	@RequestMapping(value = "/updatefilm/id/{id}", method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addFilmSubmit(@PathVariable("id") String id,
							    @RequestBody String film) {
		
		// Convert received Film as JSON into Film object and Update
		Film jsonFilmObjectFromServer = gson.fromJson(film, Film.class);
		filmService.updateFilm(jsonFilmObjectFromServer, Integer.parseInt(id));
		
		return gson.toJson(film);
	}
}