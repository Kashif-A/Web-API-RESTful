package service;

import java.util.List;

import model.Film;

public interface FilmService {
	public List<Film> listFilm();
	public List<Film> getFilm(String searchCriteria, String searchString);
	public void addFilm(Film film);
	public void updateFilm(Film film, int id);
	public String deleteFilm(int id);
}
