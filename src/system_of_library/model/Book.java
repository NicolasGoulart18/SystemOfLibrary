package system_of_library.model;

public class Book {
    private static int contador = 1;
    private int id;
    private String title;
    private String author;
    private int releaseyear;
    private boolean available;

    public Book(String title, String author, int releaseyear) {
        this.id = contador++;
        this.title = title;
        this.author = author;
        this.releaseyear = releaseyear;
        this.available = true;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getReleaseyear() { return releaseyear; }
    public boolean isAvailable() { return available; }

    public boolean emprestarLivro() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    public boolean devolverLivro() {
        if (!available) {
            available = true;
            return true;
        }
        return false;
    }
}