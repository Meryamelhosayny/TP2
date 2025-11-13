import java.time.LocalDate;
import java.util.Objects;

public class Member {
    private final int id;
    private final String fullName;
    private final Email email;
    private final LocalDate registrationDate;

    public Member(int id, String fullName, Email email, LocalDate registrationDate) {
        if (id <= 0) throw new IllegalArgumentException("ID invalide");
        this.id = id;
        this.fullName = Objects.requireNonNull(fullName, "Nom obligatoire");
        this.email = Objects.requireNonNull(email, "Email obligatoire");
        this.registrationDate = Objects.requireNonNull(registrationDate, "Date obligatoire");
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public Email getEmail() { return email; }
    public LocalDate getRegistrationDate() { return registrationDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member m)) return false;
        return id == m.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Member[%d, %s, %s]", id, fullName, email);
    }
}
