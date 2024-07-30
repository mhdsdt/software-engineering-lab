package classes;

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
        book1 = new Book("Book One", "Author One", 1);
        book2 = new Book("Book Two", "Author Two", 2);
        student1 = new Student("Student One", 1);
        student2 = new Student("Student Two", 2);

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
    public void testLendBookThatIsNotRegistered() {
        Book unregisteredBook = new Book("Unregistered Book", "Unknown Author", 99);
        assertFalse(library.lendBook(unregisteredBook, student1));
    }

    @Test
    public void testLendBookStudentAlreadyHas() {
        library.lendBook(book1, student1); // First lending
        student1.displayBooks();
        assertFalse(library.lendBook(book1, student1)); // Second lending attempt should fail
    }

    @Test
    public void testLendUnregisteredBook() {
        Book unregisteredBook = new Book("Unregistered Book", "Unknown Author", 99);
        assertFalse(library.lendBook(unregisteredBook, student1));
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
    public void testReturnBookNotRegisteredStudent() {
        Book book = new Book("Book-1", "Author-1", 10);
        Student unregisteredStudent = new Student("Unregistered Student", 99);
        library.addBook(book);
        assertFalse(library.returnBook(book, unregisteredStudent));
    }

    @Test
    public void testReturnBookStudentDoesNotHave() {
        assertFalse(library.returnBook(book1, student1));
    }

    @Test
    public void testSearchStudentsById() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(1);
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
        keys.add(1);
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

    @Test
    public void testSearchStudentsInvalidSearchType() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(1);
        ArrayList<Student> result = library.searchStudents(SearchByType.TITLE, keys);
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchBooksInvalidSearchType() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Some name");
        ArrayList<Book> result = library.searchBooks(SearchByType.NAME, keys);
        assertEquals(0, result.size());
    }

    @Test
    public void testDisplayBooks() {
        library.displayBooks();
        // No assertion needed, we just want to ensure this runs without errors
    }

    @Test
    public void testDisplayStudents() {
        library.displayStudents();
        // No assertion needed, we just want to ensure this runs without errors
    }
}
