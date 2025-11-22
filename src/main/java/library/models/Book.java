package library.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public class Book {
    private int id;

    @NotEmpty(message = "The name cannot be empty")
    @Size(min = 1, max = 255, message = "The name size should be between 1 and 255")
    private String name;

    @NotEmpty(message = "The author cannot be empty")
    @Size(min = 2, max = 127, message = "The author size should be between 2 and 127")
    private String author;

    @PastOrPresent(message = "The release date may not be in the future")
    private Date release_date;

    @Min(value = 0, message = "The number of books cannot be negative")
    private int count;

    public Book() {}

    public Book(int id, String name, String author, Date release_date, int count) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.release_date = release_date;
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
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
