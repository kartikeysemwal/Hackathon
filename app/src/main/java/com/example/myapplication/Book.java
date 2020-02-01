package com.example.myapplication;

public class Book {
    private String Title;
    private String Author;
    private String ISBN;
    private String Category;

    public Book() {
    }

    public Book(String title, String author, String ISBN, String category) {
        Title = title;
        Author = author;
        this.ISBN = ISBN;
        Category = category;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
