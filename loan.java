import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueDate;
    private LoanStatus status;

    public Loan(Book book, Member member, LocalDate loanDate, LocalDate dueDate) {
        this.book = Objects.requireNonNull(book, "Livre obligatoire");
        this.member = Objects.requireNonNull(member, "Membre obligatoire");
        this.loanDate = Objects.requireNonNull(loanDate, "Date d'emprunt obligatoire");
        this.dueDate = Objects.requireNonNull(dueDate, "Date limite obligatoire");
        if (dueDate.isBefore(loanDate))
            throw new IllegalArgumentException("Date de retour avant la date d'emprunt !");
        this.status = LoanStatus.ONGOING;
    }

    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LoanStatus getStatus() { return status; }

    public boolean isLate() {
        return LocalDate.now().isAfter(dueDate) && status == LoanStatus.ONGOING;
    }

    public void markReturned() {
        if (!status.canTransitionTo(LoanStatus.RETURNED))
            throw new IllegalStateException("Impossible de marquer comme retourné");
        status = LoanStatus.RETURNED;
    }

    public void markLate() {
        if (isLate() && status.canTransitionTo(LoanStatus.LATE))
            status = LoanStatus.LATE;
    }

    @Override
    public String toString() {
        return String.format("Loan[%s -> %s, status=%s]", member.getFullName(), book.getTitle(), status);
    }
}
