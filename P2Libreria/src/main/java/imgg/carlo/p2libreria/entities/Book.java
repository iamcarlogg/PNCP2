package imgg.carlo.p2libreria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "ISBN", nullable = false, length = 13, unique = true)
    private String ISBN;
    @Column(name = "publicationYear", nullable = false)
    private Integer publicationYear;
    @Column (name = "language", nullable = true)
    private String language;
    @Column (name = "pages", nullable = false)
    private Integer pages;
    @Column (name = "genre" , nullable = false)
    private String genre;

}
