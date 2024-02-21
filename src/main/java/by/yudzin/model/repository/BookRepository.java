package by.yudzin.model.repository;

import by.yudzin.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public List<Book> getBooks(){
        List<Book> books=new ArrayList<>();
        Book book1=new Book("book1","Ivanov","abcd1",1990);
        Book book2=new Book("book2","Petrov","abcd2",2000);
        Book book3=new Book("book3","Sidorov","abcd3",2010);
        Book book4=new Book("book4","Fedorov","abcd4",1985);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        return books;
    }
}
