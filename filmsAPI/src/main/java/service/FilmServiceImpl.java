package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.FilmDAO;
import model.Film;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmDAO filmDAO;
	
	@Override
	public List<Film> listFilm() {
		return filmDAO.listFilm();
	}

	@Override
	public List<Film> getFilm(String title) {
		return filmDAO.getFilm(title);
	}

	@Override
	public void addFilm(Film film) {
		filmDAO.addFilm(film);
	}

	@Override
	public void updateFilm(Film film, int id) {
		filmDAO.updateFilm(film, id);
	}

	@Override
	public String deleteFilm(int id) {
		return filmDAO.deleteFilm(id);
	}
}