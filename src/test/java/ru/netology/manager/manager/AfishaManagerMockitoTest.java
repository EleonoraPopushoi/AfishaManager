package ru.netology.manager.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.manager.domain.Movie;
import ru.netology.manager.AfishaManager;
import ru.netology.manager.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerMockitoTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private Movie first = new Movie(12, "Eruption", "Mockito");
    private Movie second = new Movie(13, "Mountain", "Mockito");
    private Movie third = new Movie(14, "Flood", "Mockito");


    @BeforeEach
    @Test
    void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

    }

    @Test
    void shouldAddMovieWithMock() {
        int addMovie = 3;
        Movie[] returned = new Movie[]{first, second};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);

        manager.addMovie(third);
        Movie[] expected = new Movie[]{third, second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findById(14);
    }
}