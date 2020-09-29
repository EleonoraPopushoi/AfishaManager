package ru.netology.manager.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Movie {

    private int id;
    private String movieName;
    private String genre;
}
