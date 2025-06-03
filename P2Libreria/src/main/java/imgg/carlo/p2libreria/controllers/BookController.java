package imgg.carlo.p2libreria.controllers;

import imgg.carlo.p2libreria.entities.Book;
import imgg.carlo.p2libreria.entities.dto.CreateBookDto;
import imgg.carlo.p2libreria.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody @Valid CreateBookDto info) {
        try{
            bookService.createBook(info);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
   
    @GetMapping("/{ISBN}")
    public ResponseEntity<Book> findBook(@PathVariable("ISBN") String ISBN) {
        try {
            return ResponseEntity.ok(bookService.getISBN(ISBN));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/")
    public void findBooks(@RequestParam(
            "author") String author, @RequestParam("language")  String language, @RequestParam("genre")  String genre, @RequestParam("minPages") Integer minPages, @RequestParam("maxPages")  Integer maxPages )  {
        try {
            if(!author.isEmpty())  ResponseEntity.ok(bookService.getBooksByAuthor(author));
            if(!genre.isEmpty()) ResponseEntity.ok(bookService.getBooksByGenre(genre));
            if(!language.isEmpty()) ResponseEntity.ok(bookService.getBooksByLanguage(language));
            if(minPages != 0 && maxPages != 0) {
                 ResponseEntity.ok(bookService.getBooksByPagesBetween(minPages, maxPages));
            }
            else{
                ResponseEntity.ok(bookService.getAllBooks());

            }

        } catch (Exception e){
             ResponseEntity.notFound().build();
        }
    }


}
