package imgg.carlo.p2libreria.repositories;

import imgg.carlo.p2libreria.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepositories extends JpaRepository<Book, Integer> {
    public Optional<Book> findBookByISBN(String isbn);
    public List<Book> findBooksByAuthor(String author);
    public List<Book> findBooksByLanguage(String language);
    public List<Book> findBooksByGenre(String genre);
    public List<Book> findBooksByPagesBetween(Integer pagesAfter, Integer pagesBefore);


}
