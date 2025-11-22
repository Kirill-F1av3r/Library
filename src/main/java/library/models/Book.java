package library.models;

import java.sql.Date;

public class Book {
    private int id;
    private String name;
    private String author;
    private Date release_date;
    private int count;

    public Book() {}

    public Book(int id, String name, String author, Date release_date, int count) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.release_date = release_date;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void editCount(int delta) {
        this.count += delta;
    }
}
