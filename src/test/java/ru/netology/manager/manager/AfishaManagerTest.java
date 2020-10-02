package ru.netology.manager.manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Movie;


class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private AfishaManager manager1 = new AfishaManager(5);
    private AfishaManager manager2 = new AfishaManager(0);

    private Movie movie1 = new Movie(1, "Bloodshot", "action");
    private Movie movie2 = new Movie(2, "Onward", "cartoon");
    private Movie movie3 = new Movie(3, "The Belgrade Hotel ", "comedy");
    private Movie movie4 = new Movie(4, "The Gentlemen", "action");
    private Movie movie5 = new Movie(5, "Invisible Man", "horror");
    private Movie movie6 = new Movie(6, "Invisible Man", "horror");
    private Movie movie7 = new Movie(7, "Number One", "comedy");
    private Movie movie8 = new Movie(8, "The Pursuit of Happyness", "drama");
    private Movie movie9 = new Movie(9, "Mulan", "action");
    private Movie movie10 = new Movie(10, "Pearl harbor", "action/drama");
    private Movie movie11 = new Movie(11, "Mary Poppins", "comedy/fantasia");

    @BeforeEach
    void setUp() {
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
    }

    @BeforeEach
    @Test
    void setManager1Up() {
        manager1.addMovie(movie1);
        manager1.addMovie(movie2);
        manager1.addMovie(movie3);
        manager1.addMovie(movie4);
    }

    @Test
    public void showAfishaLessDefaultLength() {
        Movie[] actual = manager.getLastMovieAdded();
        Movie[] expected = new Movie[]{movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showAfishaWithDefaultLength() {
        manager.addMovie(movie10);
        Movie[] actual = manager.getLastMovieAdded();
        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showAfishaMoreDefaultLength() {
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        Movie[] actual = manager.getLastMovieAdded();
        Movie[] expected = new Movie[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void showLessMovieFromList() {
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{movie4, movie3, movie2, movie1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showMovieFromList() {
        manager1.addMovie(movie5);
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{movie5, movie4, movie3, movie2, movie1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showMoreMovieFromList() {
        manager1.addMovie(movie5);
        manager1.addMovie(movie6);
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{movie6, movie5, movie4, movie3, movie2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showNothing() {
        Movie[] actual = manager2.getLastMovieAdded();
        Movie[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }
}
