package library.models;

import jakarta.validation.constraints.*;

import java.sql.Date;

public class Person {
    private int id;

    @NotEmpty(message = "The name cannot be empty")
    @Size(min = 2, max = 255, message = "The name size should be between 2 and 255")
    private String name;

    @PastOrPresent(message = "The birthday may not be in the future")
    private Date birthday;

    @NotEmpty(message = "The email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "The phone cannot be empty")
    @Pattern(regexp = "^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}$",
            message = "Phone number must be in format +7 (XXX) XXX-XX-XX")
    private String phone;

    public Person() {}

    public Person(int id, String name, Date birthday, String email, String phone) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
