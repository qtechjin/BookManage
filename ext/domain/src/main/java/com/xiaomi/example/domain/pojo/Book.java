package com.xiaomi.example.domain.pojo;

/**
 * Created by mi on 2017/2/15.
 */
public class Book {
    private String book_isbn;
    private String book_name;
    private String publish;
    private String author;
    private int count;
    private String remark;
    private double price;

    public Book() {
    }

    public Book(String book_isbn, String book_name, String publish, String author, int count, String remark, double price) {
        this.book_isbn = book_isbn;
        this.book_name = book_name;
        this.publish = publish;
        this.author = author;
        this.count = count;
        this.remark = remark;
        this.price = price;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_isbn='" + book_isbn + '\'' +
                ", book_name='" + book_name + '\'' +
                ", publish='" + publish + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", remark='" + remark + '\'' +
                ", price=" + price +
                '}';
    }
}
