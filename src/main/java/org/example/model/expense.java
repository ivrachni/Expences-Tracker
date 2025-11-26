package org.example.model;

import java.util.Date;

public class expense {
    private int expense_id;
    private int user_id;
    private String category_id;
    private double amount;
    private String description;
    private Date expense_date;

    public expense() {}

    public expense(int expense_id, int user_id, String category_id, double amount, String description, Date expense_date) {
        this.expense_id = expense_id;
        this.user_id = user_id;
        this.category_id = category_id;
        this.amount = amount;
        this.description = description;
        this.expense_date = expense_date;
    }

    public int getExpense_id() {
        return expense_id;
    }
    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCategory_id() {
        return category_id;
    }
    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getExpense_date() {
        return expense_date;
    }
    public void setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
    }

    @Override
    public  String toString() {
        return "expense [expense_id=" + expense_id + ", user_id=" + user_id+ ", category_id=" + category_id + ", amount=" + amount + ", description=" + description + ", expense_date=" + expense_date + "]";
    }
}


