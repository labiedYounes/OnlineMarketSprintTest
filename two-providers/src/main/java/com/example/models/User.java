package com.example.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name="shopper")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String email;
    private String locale;
    private Date last_login;
    @OneToMany()
    private Set<Product> products;

    @OneToMany(fetch=FetchType.LAZY)
    private Set<Review> reviews;

    @OneToMany(fetch=FetchType.LAZY)
    private Set<Bill> bills;

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public User(String fullname, String email, String locale, Date last_login) {
        this.fullname = fullname;
        this.email = email;
        this.locale = locale;
        this.last_login = last_login;
    }

    public User() {

    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }
}
