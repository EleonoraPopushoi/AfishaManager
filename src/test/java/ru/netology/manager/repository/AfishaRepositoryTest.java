package ru.netology.manager.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Movie;
import ru.netology.manager.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();

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


    private Movie itemToAdd = new Movie(13, "Mary Poppins", "comedy/fantasia");
    private Movie itemToSave = new Movie(14, "Up", "cartoon");

    @BeforeEach
    @Test
    void setUp() {
        // repository.save(movieToAdd);
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
        repository.save(item9);
        repository.save(item10);

    }

    @Test
    void shouldFindAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10,};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        repository.save(itemToSave);
        Movie[] actual = repository.findAll();
        Movie[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, itemToSave,};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Movie actual = repository.findById(9);
        Movie expected = item9;//new Movie(9, "Mulan", "action");
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);
        Movie[] actual = repository.findAll();
        Movie[] expected = {item2, item3, item4, item5, item6, item7, item8, item9, item10};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] expected = {};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotExistId() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(50));
    }
}
