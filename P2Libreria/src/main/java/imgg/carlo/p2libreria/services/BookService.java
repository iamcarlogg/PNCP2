package imgg.carlo.p2libreria.services;

import imgg.carlo.p2libreria.entities.Book;
import imgg.carlo.p2libreria.entities.dto.CreateBookDto;
import imgg.carlo.p2libreria.repositories.BookRepositories;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class BookService {

    @Autowired
    private BookRepositories bookRepositories;

    public void createBook(CreateBookDto bookInfo) {
        Book book = new Book();
        book.setTitle(bookInfo.getTitle());
        book.setAuthor(bookInfo.getAuthor());
        book.setISBN(bookInfo.getISBN());
        book.setPublicationYear(bookInfo.getPublicationYear());
        book.setLanguage(bookInfo.getLanguage());
        book.setPages(bookInfo.getPages());
        book.setGenre(bookInfo.getGenre());
        bookRepositories.save(book);
    }
    public Book getISBN(String ISBN) {
        Optional<Book> optionalBook =
                bookRepositories.findBookByISBN(ISBN);
        if(optionalBook.isEmpty()) {
            throw new RuntimeException("ISBN Not found");
        }
        return optionalBook.get();

    }
    public List<Book> getAllBooks() {
        return bookRepositories.findAll();
    }
    public List<Book> getBooksByAuthor(String author) {
        List<Book> optionalList =
                bookRepositories.findBooksByAuthor(author);
        if(optionalList.isEmpty()) {
            throw new RuntimeException("No hay libros de ese we xd");
        }
        return optionalList;
    }
    public  List<Book> getBooksByGenre(String genre) {
        List<Book> list =
                bookRepositories.findBooksByGenre(genre);
        if(list.isEmpty()) {
            throw new RuntimeException("No hay libros de ese " +
                    "genero rebuscado xd");
        }
        return list;
    }
    public List<Book> getBooksByLanguage(String language) {
        List<Book> list =
                bookRepositories.findBooksByLanguage(language);
        if(list.isEmpty()) {
            throw new RuntimeException("fuera gringo: ñ");
        }
        return list;
    }
    public List<Book> getBooksByPagesBetween(Integer pagesAfter, Integer pagesBefore) {
        List<Book> list = bookRepositories.findBooksByPagesBetween(pagesAfter, pagesBefore);
        if(list.isEmpty()) {
            throw new RuntimeException("Solo hay libros tamaño " +
                    "promedio");
        }
        return list;

    }

    public void deleteByISBN(String ISBN) {
        Optional<Book> optionalBook =
                bookRepositories.findBookByISBN(ISBN);
        if(optionalBook.isEmpty()) {
            throw new RuntimeException("ISBN Not found");
        }
        bookRepositories.delete(optionalBook.get());
    }
    public void UpdateBook(String ISBN, String title,
                           String language){
        Optional<Book> optionalBook =
                bookRepositories.findBookByISBN(ISBN);
        if(optionalBook.isEmpty()) {
            throw new RuntimeException("ISBN Not found");
        }
        optionalBook.get().setTitle(title);
        optionalBook.get().setLanguage(language);

    }
}
