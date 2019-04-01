package controller;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.google.gson.Gson;
import model.Film;
import model.Films;
import service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController to list all films and send the films as JSON, XML, TEXT or CSV format
 * depending on user choice.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@RestController
public class ListAllFilmsController extends HttpServlet {
	private static final long serialVersionUID = -4514973525022166356L;
	
	@Autowired
	private FilmService filmService;
	@Autowired
	Films films;
	final Gson gson = new Gson();
    
	/**
	 * GET REQUEST to /listfilms directed to here.
	 * @param typeOfData determines what data format the user wants; JSON, XML, TEXT or CSV.
	 * @return String object containing all films data.
	 */
	@RequestMapping(value = "/listfilms/{typeOfData}", method = RequestMethod.GET)
	@ResponseBody
	public String listFilms(@PathVariable(value="typeOfData") String typeOfData, HttpServletResponse response, HttpServletRequest request) {
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		
		// Generate XML
		final StringBuilder textFormattedData = new StringBuilder();
		final StringBuilder xmlFormattedData = new StringBuilder();
		Writer writer = new StringWriter();
		if (typeOfData.contentEquals("xml")) {
			films.getFilmsList().clear();
			for (Film f : filmService.listFilm()) {
				films.getFilmsList().add(f);
			}
			try {
				// create JAXB context and instantiate marshaller
		        JAXBContext context = JAXBContext.newInstance(Films.class);
		        Marshaller m = context.createMarshaller();
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		        m.marshal(films, writer);
		        xmlFormattedData.setLength(0);
		        xmlFormattedData.append(writer.toString());
		        writer.close();
			} catch (JAXBException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return xmlFormattedData.toString();
	        
		} else if (typeOfData.contentEquals("json")) { // Generate films data as JSON
			return gson.toJson(filmService.listFilm());
			
		} else if (typeOfData.contentEquals("text")) { // Generate films data as TEXT
			textFormattedData.setLength(0);
			for (Film f : filmService.listFilm()) {
				textFormattedData.append(f.toString());
			} 
			return textFormattedData.toString();
			
		} else if (typeOfData.contentEquals("csv")) { // Generate films data as CSV
			textFormattedData.setLength(0);
			for (Film f : filmService.listFilm()) {
				textFormattedData.append(f.toCSVString());
			}
			return textFormattedData.toString();
		}	
		return gson.toJson(filmService.listFilm());
   }
}