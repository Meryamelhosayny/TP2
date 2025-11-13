import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$");

    public Email {
        Objects.requireNonNull(value, "Email ne doit pas être nul");
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Format d'email invalide");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
