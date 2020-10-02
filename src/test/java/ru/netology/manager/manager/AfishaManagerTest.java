package ru.netology.manager.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Movie;
import ru.netology.manager.manager.AfishaManager;


class AfishaManagerTest {

    private AfishaManager manager = new AfishaManager(5);
    private AfishaManager manager1 = new AfishaManager(9);
    private AfishaManager manager2 = new AfishaManager(0);


    private Movie item1 = new Movie(1, "Bloodshot", "action");
    private Movie item2 = new Movie(2, "Onward", "cartoon");
    private Movie item3 = new Movie(3, "The Belgrade Hotel ", "comedy");
    private Movie item4 = new Movie(4, "The Gentlemen", "action");
    private Movie item5 = new Movie(5, "Invisible Man", "horror");
    private Movie item6 = new Movie(6, "Trolls World Tour", "cartoon");
    private Movie item7 = new Movie(7, "Number One", "comedy");
    private Movie item8 = new Movie(8, "The Pursuit of Happyness", "drama");
    private Movie item9 = new Movie(9, "Mulan", "action");
    private Movie item10 = new Movie(10, "Pearl harbor", "action/drama");

    private Movie item11 = new Movie(11, "Mary Poppins", "comedy/fantasia");


    @BeforeEach
    @Test
    void setUp() {
        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);
        manager.addMovie(item8);
        manager.addMovie(item9);

    }

    @Test
    public void showMovieFromList() {
        Movie[] actual = manager.getLastMovieAdded();
        Movie[] expected = new Movie[]{
                item9, item8, item7, item6, item5
        };

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showAfishaLessDefaultLength() {
        manager1.addMovie(item8);
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{item8};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showAfishaWithDefaultLength() {
        manager1.addMovie(item10);
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{
                item10
        };
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showAfishaMoreDefaultLength() {
        manager1.addMovie(item10);
        manager1.addMovie(item11);
        Movie[] actual = manager1.getLastMovieAdded();
        Movie[] expected = new Movie[]{item11, item10};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void showNothing() {
        Movie[] actual = manager2.getLastMovieAdded();
        Movie[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }
}
