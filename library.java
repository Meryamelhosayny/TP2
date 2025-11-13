import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final Set<Book> books = new HashSet<>();
    private final Set<Member> members = new HashSet<>();
    private final Set<Loan> loans = new HashSet<>();

    public void addBook(Book book) {
        books.add(Objects.requireNonNull(book));
    }

    public void registerMember(Member member) {
        members.add(Objects.requireNonNull(member));
    }

    public void loanBook(Book book, Member member, java.time.LocalDate loanDate, java.time.LocalDate dueDate) {
        if (!books.contains(book)) throw new IllegalArgumentException("Livre inconnu");
        if (!members.contains(member)) throw new IllegalArgumentException("Membre inconnu");
        loans.add(new Loan(book, member, loanDate, dueDate));
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public Set<Member> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public Set<Loan> getCurrentLoans() {
        return Collections.unmodifiableSet(loans.stream()
                .filter(l -> l.getStatus().isActive())
                .collect(Collectors.toSet()));
    }
}
