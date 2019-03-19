package com.myCompany.conferenceManagmentSystem.model;

import java.util.List;

public class Items<T> extends AbstractModel{
    private List<T> items;
    private int count;

    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        this.items = items;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
