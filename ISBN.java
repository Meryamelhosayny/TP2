import java.util.Objects;
import java.util.regex.Pattern;

public record Isbn(String value) {
    private static final Pattern ISBN_PATTERN = Pattern.compile("\\d{3}-\\d{10}");

    public Isbn {
        Objects.requireNonNull(value, "ISBN ne doit pas être nul");
        if (!ISBN_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Format ISBN invalide (ex: 978-1234567890)");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
public class LibraryTest {
    public static void main(String[] args) {
        Isbn isbn = new Isbn("978-1234567890");
        Email email = new Email("test@mail.com");
        Book book = new Book(isbn, "Java Basics", "Author A", 2020);
        Member member = new Member(1, "Alice", email, java.time.LocalDate.now());

        Library library = new Library();
        library.addBook(book);
        library.registerMember(member);

        library.loanBook(book, member, java.time.LocalDate.now(), java.time.LocalDate.now().plusDays(7));

        System.out.println(library.getBooks());
        System.out.println(library.getCurrentLoans());
    }
}
