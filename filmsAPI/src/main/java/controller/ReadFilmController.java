package controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.Film;
import model.Films;
import service.FilmService;

/**
 * Controller to get specific film based on ID, title, year, director or stars.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Controller
public class ReadFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;
	@Autowired
	Films films;
	private Gson gson = new Gson();

	/**
	 * GET REQUEST to /searchfilm directed here.
	 * @param response to send response to browser.
	 * @param request to get 'Origin' header.
	 * @param id URL parameter.
	 * @param title URL parameter.
	 * @param year URL parameter.
	 * @param director URL parameter.
	 * @param stars URL parameter.
	 * @return String object containing Film as JSON.
	 */
	@RequestMapping(value = "/searchfilm", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getFilmFormSubmit(HttpServletResponse response, 
									HttpServletRequest request,
							        @RequestParam(required=false, name="title") String title) {
		// Response headers
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		// Get film based on search criteria (ID, Title, Year etc)
		StringBuilder searchResult = new StringBuilder();
		try {
			List<Film> searchedFilms = filmService.getFilm(title);
			if (searchedFilms.size() > 0) {
				for (Film f : searchedFilms) {
					searchResult.append(gson.toJson(f));
				}
			} else {
				searchResult.append("<strong>No results found. Please try again...</strong>");
			}
			searchResult.append("<br><br><a href=\"https://filmsapi.appspot.com\">Home</a>");
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return searchResult.toString();
	}
}