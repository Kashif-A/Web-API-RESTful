package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.Film;
import service.FilmService;

/**
 * Controller to add new film to database. URL parameters or POST request body holds
 * the data used to generate new Film object, which is then added to the database.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Controller
public class AddFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;

	/**
	 * GET REQUEST to /createfilm directed here. URL parameters used to generate
	 * new film object that is then added to database.
	 * 
	 * @param title Film title URL parameter.
	 * @param year Film year URL parameter.
	 * @param director Film director URL parameter.
	 * @param stars Film stars URL parameter.
	 * @param review Film review URL parameter.
	 * @return String object containing HTML.
	 */
	@RequestMapping(value = "/createfilm", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addFilmFormSubmit(@RequestParam("title") String title,
				 				 	@RequestParam("year") String year,
				 				 	@RequestParam("director") String director,
				 				 	@RequestParam("stars") String stars,
				 				 	@RequestParam("review") String review) {
		filmService.addFilm(new Film(title, Integer.parseInt(year), director, stars, review));
		
		return "<h3><br>Film with title " + title + " added successfully</h3>"
				+ "<br><a href=\"https://filmsapi.appspot.com\">Home</a>";
	}
	
	/**
	 * POST REQUEST to /createfilmJSON directed here. Film data contained in request body.
	 * 
	 * @param postPayload contains request body sent via POST request.
	 * @param response to request.
	 * @param request received from browser.
	 * @return String object containing JSON response.
	 */
	@RequestMapping(name = "/createfilmJSON", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addFilmJSONFormSubmit(@RequestBody String postPayload, HttpServletResponse response, HttpServletRequest request) {
		System.out.println(postPayload);
		final Gson gson = new Gson();
		// Convert received JSON data into Film object
		Film jsonFilmObjectFromServer = gson.fromJson(postPayload, Film.class);
		filmService.addFilm(jsonFilmObjectFromServer); // Add film
		
		// Response headers
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		return "{ \"SERVER RESPONSE\":\"Successfully received JSON data and added film with name " + jsonFilmObjectFromServer.getTitle() + "\" }";
	}
}