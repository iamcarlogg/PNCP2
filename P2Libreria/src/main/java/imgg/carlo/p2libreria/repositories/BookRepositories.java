package imgg.carlo.p2libreria.repositories;

import imgg.carlo.p2libreria.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositories extends JpaRepository<Book, Integer> {
}
