package library.models;

import java.sql.Date;

public class BorrowRecord {
    private int id;
    private int book_id;
    private int person_id;
    private Date borrow_date;
    private Date return_date;

    public BorrowRecord() {}

    public BorrowRecord(int id, int book_id, int person_id, Date borrow_date, Date return_date) {
        this.id = id;
        this.book_id = book_id;
        this.person_id = person_id;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
