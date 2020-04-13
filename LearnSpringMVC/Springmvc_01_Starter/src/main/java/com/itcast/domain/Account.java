package com.itcast.domain;

import java.util.List;
import java.util.Map;

public class Account {

    private String firstName;
    private String password;
    private Double money;

    private User user;
    private List<Book> booksList;
    private Map<String, Book> booksMap;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public Map<String, Book> getBooksMap() {
        return booksMap;
    }

    public void setBooksMap(Map<String, Book> booksMap) {
        this.booksMap = booksMap;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", booksList=" + booksList +
                ", booksMap=" + booksMap +
                '}';
    }
}
