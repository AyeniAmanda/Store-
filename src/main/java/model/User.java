package model;

import enums.UserRole;


import java.util.HashMap;

public class User  {
    private Long id;
    private String name;
    private UserRole role;
    private HashMap<String , Product> carts;

    private Product product;

    private String ExperienceLevel;

    public User() {
    }

    public User(Long id, String name, UserRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.carts =  new HashMap<>();
    }

    public User(String name, UserRole role, String ExperienceLevel) {
        this.name = name;
        this.role = role;
        this.ExperienceLevel = ExperienceLevel;

    }

    public String getExperienceLevel() {
        return ExperienceLevel;
    }

    public String getName() {
        return name;
    }


    public UserRole getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public HashMap<String , Product>  getCarts() {
        return carts;
    }

    public void setCarts(HashMap<String , Product>  carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", product=" + product +
                '}';
    }



}

