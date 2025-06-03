package imgg.carlo.p2libreria.entities.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Year;
import java.util.UUID;

@AllArgsConstructor
@Data
public class BookDto {
    private UUID id;
    private String title;
    private String author;
    private String ISBN;
    private Integer publicationYear;
    private Integer pages;
    private String genre;

}
