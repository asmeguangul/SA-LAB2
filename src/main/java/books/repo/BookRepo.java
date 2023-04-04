package books.repo;

import books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepo {

    private int id=10;


    List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book(4,"Author 1", "Tittle 1", 70),
            new Book(5,"Author 2", "Tittle 2", 89),
            new Book(5,"Author 2", "Tittle 2", 89))
    );


    public List<Book> findAll(){
        return books;
    }

    public Book getBook(int id){
        return books.stream().filter(i->i.getIsbn()==id).findFirst().orElse(null);
    }

    public void save(Book book){
        book.setIsbn(id);
        id++;
        books.add(book);
    }

    public void deleteBook(int id) {
        Book book = books.stream().filter(b -> b.getIsbn() == id).findFirst().get();

        books.remove(book);
    }

    public void update(int id, Book book) {
        Book book1= getBook(id);

        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
    }

}
