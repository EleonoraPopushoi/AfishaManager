package ru.netology.manager.repository;

import ru.netology.manager.domain.Movie;

public class AfishaRepository {

    private Movie[] movies = new Movie[0];
//    private Movie[] movies = {
//            new Movie(1, "Bloodshot", "action"),
//            new Movie(2, "Onward", "cartoon"),
//            new Movie(3, "The Belgrade Hotel ", "comedy"),
//            new Movie(4, "The Gentlemen", "action"),
//            new Movie(5, "Invisible Man", "horror"),
//            new Movie(6, "Trolls World Tour", "cartoon"),
//            new Movie(7, "Number One", "comedy"),
//            new Movie(8, "The Pursuit of Happyness", "drama"),
//            new Movie(9, "Mulan", "action"),
//            new Movie(10, "Pearl harbor", "action/drama"),
//
//    };

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        int moviesLength = movies.length;
        Movie[] tmpArray = new Movie[moviesLength + 1];
        System.arraycopy(movies, 0, tmpArray, 0, moviesLength);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = movie;
        movies = tmpArray;
    }

    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmpArray = new Movie[length];
        int i = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmpArray[i] = movie;
                i++;
            }
        }
        movies = tmpArray;
    }

    public void removeAll() {
        movies = new Movie[0];
    }
}
