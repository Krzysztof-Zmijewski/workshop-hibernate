package main.pl.coderslab.workshophibernate.repository;

import main.pl.coderslab.workshophibernate.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
