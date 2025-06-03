package imgg.carlo.p2libreria.entities.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.Year;
import java.util.UUID;

@Getter
public class CreateBookDto {
    @NotNull
    private UUID id;

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String author;

    @NotBlank
    @NotNull
    private String isbn;


    @NotNull
    @Min(value = 1900)
    @Max(value = 2025)
    private Integer publicationYear;


    @NotBlank
    @NotNull
    private String language;


    @NotNull
    @Min(value = 10)
    private Integer pages;

    @NotBlank
    @NotNull
    private String genre;
}
