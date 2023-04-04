package books.service;

import books.domain.Book;
import books.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public void addBook(Book book) {
          bookRepo.save(book);
    }


    public List<Book> getBooks() {
        return bookRepo.findAll();
    }
    public Book getBook(int id) {
        return bookRepo.getBook(id);
    }


    public void deleteBook(int id) {
        bookRepo.deleteBook(id);
    }

    public void updateBook(int id, Book book) {
        bookRepo.update(id,book);
    }

}
