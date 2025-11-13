import java.util.Objects;

public class Book {
    private final Isbn isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    public Book(Isbn isbn, String title, String author, int publicationYear) {
        this.isbn = Objects.requireNonNull(isbn, "ISBN obligatoire");
        this.title = Objects.requireNonNull(title, "Titre obligatoire");
        this.author = Objects.requireNonNull(author, "Auteur obligatoire");
        if (publicationYear <= 0)
            throw new IllegalArgumentException("Année de publication invalide");
        this.publicationYear = publicationYear;
    }

    public Isbn getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book b)) return false;
        return isbn.equals(b.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return String.format("Book[%s, %s, %s, %d]", isbn, title, author, publicationYear);
    }
}
