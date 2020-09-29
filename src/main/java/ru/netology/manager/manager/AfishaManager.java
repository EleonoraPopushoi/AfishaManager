package ru.netology.manager.manager;

import ru.netology.manager.domain.Movie;

public class AfishaManager {

    private Movie[] movies = new Movie[0];
    int afishaLength = 9;
    public AfishaManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public AfishaManager() {

    }

    public void addMovie(Movie movie) {
        int moviesLength = movies.length;
        Movie[] tmpArray = new Movie[moviesLength + 1];
        System.arraycopy(movies, 0, tmpArray, 0, moviesLength);
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

    public Movie[] getAll() {
        Movie[] result = new Movie[movies.length];
        // c - current film
        for (int c = 0; c < result.length; c++) {
            int index = movies.length - c - 1;
            result[c] = movies[index];
        }
        return result;
    }


}
