package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import config.HibernateSessionFactory;
import model.Film;

/**
 * FilmDAO Interface Implementation. This class is used to carry out database
 * interactions using Hibernate.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Repository
public class FilmDAOImpl implements FilmDAO {
	
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory = HibernateSessionFactory.getSingletonSessionFactory();

	// Default constructor
	public FilmDAOImpl() {}
	
	/**
    * This method lists all films.
    * 
    * @return List<Film> collection containing all films.
    */
	@SuppressWarnings("unchecked")
	public List<Film> listFilm(){
	    Session session = sessionFactory.openSession();
		List<Film> allFilms = new ArrayList<Film>();
		session.beginTransaction();	
		Query<Film> query = session.createQuery("FROM Film");
		allFilms = query.list();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
	   return allFilms;
    }

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
	@SuppressWarnings("unchecked")
	public List<Film> getFilm(String title){
		Session session = sessionFactory.openSession();
		List<Film> searchedFilm = new ArrayList<Film>();	
		session.beginTransaction();
		
		// HQL query depends based on search criteria
		Query<Film> queryObject = session.createQuery("from Film where title like '%"+title+"%'");
		searchedFilm = queryObject.list();
		
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return searchedFilm;
	}

	/**
     * This method adds a film to database.
     * 
     * @param film Film object to be added
     */
	@Override
	public void addFilm(Film film) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Creating and saving Film");
		session.persist(film);
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		System.out.println("Success! Film was added to the database");
	}

	/**
     * This method updates a film based on ID.
     * 
     * @param film updated film object to replace old film.
     * @param id of the film to be updated.
     */
	@Override
	public void updateFilm(Film film, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Updating Film");
		Film filmToUpdate = (Film) session.load(Film.class, new Integer(id));
		filmToUpdate.setTitle(film.getTitle());
		filmToUpdate.setYear(film.getYear());
		filmToUpdate.setDirector(film.getDirector());
		filmToUpdate.setStars(film.getStars());
		filmToUpdate.setReview(film.getReview());
		session.saveOrUpdate(filmToUpdate);
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		System.out.println("Success! Film updated");
	}

	/**
     * Delete film based on ID.
     * 
     * @param id of the film to be deleted.
     * @return String object letting user know if film successfully deleted or not.
     */
	@Override
	public String deleteFilm(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String noEntityFound = "";
		try {
			Film film = (Film) session.load(Film.class, new Integer(id));
			if(film != null){
				session.delete(film);
				session.getTransaction().commit();
				return "Film with id " + film.getId() + " successfully deleted!";
			}
		} catch (EntityNotFoundException e) {
			noEntityFound = "No film with that id exists";
			session.close();
		}
		if (session.getTransaction() != null) {
			session.close();
		}
		return noEntityFound;
	}
}