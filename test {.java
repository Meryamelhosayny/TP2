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
