package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

/**
 * This is a utility class to help generate XML format properly.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Component
@XmlRootElement(name = "films")
public class Films {

    // XmlElement sets the name of the entities
    @XmlElement(name = "film")
    private ArrayList<Film> filmList = new ArrayList<Film>();

    // Setter
    public void setFilmList(ArrayList<Film> filmListParam) {
        this.filmList = filmListParam;
    }

    // Getter
    public ArrayList<Film> getFilmsList() {
        return filmList;
    }
}
