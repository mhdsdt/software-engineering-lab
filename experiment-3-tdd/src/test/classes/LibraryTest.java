package test.classes;

import main.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class LibraryTest {
    private Library library;
    private Book book1, book2;
    private Student student1, student2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1", "Book One", "Author One");
        book2 = new Book("2", "Book Two", "Author Two");
        student1 = new Student("1", "Student One");
        student2 = new Student("2", "Student Two");

        library.addBook(book1);
        library.addBook(book2);
        library.addStudent(student1);
        library.addStudent(student2);
    }

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

    @Test
    public void testSearchStudentsById() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("1");
        ArrayList<Student> result = library.searchStudents(SearchByType.ID, keys);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Student One", result.get(0).getName());
    }

    @Test
    public void testSearchStudentsByName() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Student Two");
        ArrayList<Student> result = library.searchStudents(SearchByType.NAME, keys);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Student Two", result.get(0).getName());
    }

    @Test
    public void testSearchBooksById() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("1");
        ArrayList<Book> result = library.searchBooks(SearchByType.ID, keys);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Book One", result.get(0).getTitle());
    }

    @Test
    public void testSearchBooksByTitle() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Book Two");
        ArrayList<Book> result = library.searchBooks(SearchByType.TITLE, keys);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Book Two", result.get(0).getTitle());
    }

    @Test
    public void testSearchBooksByAuthor() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Author One");
        ArrayList<Book> result = library.searchBooks(SearchByType.AUTHOR, keys);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Book One", result.get(0).getTitle());
    }
}
