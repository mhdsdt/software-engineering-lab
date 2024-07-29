package test.classes;

import main.classes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    public void testLendBookToNonRegisteredStudent() {
        Library library = new Library();
        Book book = new Book("Book-1", "Author-1", 10);
        Student student = new Student("Not-registered-student", 13);
        library.addBook(book);
        assertFalse(library.lendBook(book, student));
    }

    @Test
    public void testReturnBook() {
        Library library = new Library();
        Book book = new Book("Book-1", "Author-1", 10);
        Student student = new Student("Alice", 10);
        library.addBook(book);
        library.addStudent(student);
        library.lendBook(book, student);
        assertTrue(library.returnBook(book, student));
        assertFalse(student.hasBook(book));
    }
}
