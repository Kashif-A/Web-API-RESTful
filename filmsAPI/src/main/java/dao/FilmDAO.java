package dao;

import java.util.List;

import model.Film;

/**
 * FilmDAO Interface.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
public interface FilmDAO {

	   /**
	    * This method lists all films.
	    * 
	    * @return List<Film> collection containing all films.
	    */
	    public List<Film> listFilm();
	    
	    /**
	     * This method gets specific film based on search criteria.
	     * 
	     * @param ID Gets film based on ID.
	     * @param name Gets film based on film title.
	     * @param year Gets film based on year.
	     * @param dirctor Gets film based on director.
	     * @param stars Gets film based on stars.
	     * @return List<Film> collection containing all films matching search criteria.
	     */
	    public List<Film> getFilm(String title);
	    
	    /**
	     * This method adds a film to database.
	     * 
	     * @param film Film object to be added
	     */
	    public void addFilm(Film film);
	    
	    /**
	     * This method updates a film based on ID.
	     * 
	     * @param film updated film object to replace old film.
	     * @param id of the film to be updated.
	     */
	    public void updateFilm(Film film, int id);
	    
	    /**
	     * Delete film based on ID.
	     * 
	     * @param id of the film to be deleted.
	     * @return String object letting user know if film successfully deleted or not.
	     */
	    public String deleteFilm(int id);
	    
}