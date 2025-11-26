package org.example.model;

public class category {

    private int category_id;
    private String category_name;
    private int userId;

    public category() {}

    public category(int category_id, String category_name, int userId) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.userId = userId;
    }

    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "category [category_id=" + category_id + ", category_name=" + category_name + ", userId=" + userId+ " " + "}";}


}
