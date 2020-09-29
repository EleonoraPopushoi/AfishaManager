package ru.netology.manager.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.manager.domain.Movie;
import ru.netology.manager.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerMockitoTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    Movie first = new Movie(12, "Eruption", "Mockito");
    Movie second = new Movie(13, "Mountain", "Mockito");
    Movie third = new Movie(14, "Flood", "Mockito");

    @Test
    void shouldAddMovieWithMock1() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);
        manager.addMovie(third);
        Movie[] expected = new Movie[]{third, second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMovieWithMock2() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);
        manager.addMovie(third);
        Movie[] expected = new Movie[]{third, second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMovieWithMock3() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);
        manager.addMovie(third);
        Movie[] expected = new Movie[]{third, second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}