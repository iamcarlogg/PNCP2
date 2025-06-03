package imgg.carlo.p2libreria.entities.dto;

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
    private Year publisher;

    @NotBlank
    @NotNull
    private Integer pages;

    @NotBlank
    @NotNull
    private String genre;
}
