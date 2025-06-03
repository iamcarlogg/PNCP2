package imgg.carlo.p2libreria.entities.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String ISBN;

    @NotBlank
    @NotNull
    @Min(value = 1900)
    @Max(value = 2025)
    private Integer publicationYear;


    @NotBlank
    @NotNull
    private String language;

    @NotBlank
    @NotNull
    @Min(value = 10)
    private Integer pages;

    @NotBlank
    @NotNull
    private String genre;
}
