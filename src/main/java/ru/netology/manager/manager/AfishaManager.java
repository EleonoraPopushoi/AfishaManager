package ru.netology.manager.manager;

import ru.netology.manager.domain.Movie;

public class AfishaManager {
    int afishaLength = 10;
    private Movie[] movies = new Movie[0];


    public AfishaManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public AfishaManager() {

    }

    public void addMovie(Movie movie) {
        int movieLength = movies.length;
        Movie[] tmpArray = new Movie[movieLength + 1];
        System.arraycopy(movies, 0, tmpArray, 0, movieLength);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = movie;
        movies = tmpArray;
    }


    public Movie[] getLastMovieAdded() {
        int representMax = Math.min(movies.length, afishaLength);
        Movie[] film = new Movie[representMax];
        // c - current film
        for (int c = 0; c < film.length; c++) {
            int result = movies.length - c - 1;
            film[c] = movies[result];
        }
        return film;

    }
}
