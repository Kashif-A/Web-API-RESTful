package controller;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import model.Film;
import model.Films;
import service.FilmService;

/**
 * RestController to get specific film based on ID, title, year, director or stars.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@RestController
public class ReadFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FilmService filmService;
	@Autowired
	Films films;
	private Gson gson = new Gson();

	/**
	 * GET REQUEST to /searchfilm directed here.
	 * @param response response to send response to browser.
	 * @param request to get 'Origin' header.
	 * @param dataType to control whether response is in JSON, XML, TEXT or CSV.
	 * @param searchCriteria to search by id, title, year etc
	 * @param searchString what the user searched for
	 * @return String object containing film as JSON, XML, TEXT or CSV based on user choice.
	 */
	@RequestMapping(value = "{dataType}/searchfilm/{searchCriteria}/{searchString}", 
					method = RequestMethod.GET, 
					produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getFilmFormSubmit(HttpServletResponse response, 
									HttpServletRequest request,
									@PathVariable String dataType,
									@PathVariable String searchCriteria,
									@PathVariable String searchString) {
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
			List<Film> searchedFilms = filmService.getFilm(searchCriteria, searchString);
			if (!searchedFilms.isEmpty()) {
				switch (dataType){
					
					// Generate JSON
					case "json":
						return gson.toJson(searchedFilms);
						
					// Generate XML
					case "xml":
						Writer writer = new StringWriter();
		    				films.getFilmsList().clear();
		    				for (Film f : searchedFilms) {
		    					films.getFilmsList().add(f);
		    				}
		    				//System.out.println(films.getFilmsList().toString());
							try {
								// create JAXB context and instantiate marshaller
			    		        JAXBContext context = JAXBContext.newInstance(Films.class);
			    		        Marshaller m = context.createMarshaller();
			    		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			    		        m.marshal(films, writer);
			    		        searchResult.setLength(0);
			    		        searchResult.append(writer.toString());
			    		        writer.close();
							} catch (JAXBException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						break;
						
					// Generate CSV
					case "csv":
						for (Film f : searchedFilms) {
							searchResult.append(f.toCSVString());
						}
						break;
				}
			} else {
				searchResult.append("{\"SERVER RESPONSE\": \"No results found.\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  
		searchResult.append("");
		return searchResult.toString();
	}
}