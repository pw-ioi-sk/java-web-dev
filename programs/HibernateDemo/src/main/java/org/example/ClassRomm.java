package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClassRomm {
    @Id
    private int id;
    private int capacity;
    private String batch;
    private String serial;

    public ClassRomm() {
    }

    public ClassRomm(int id, int capacity, String batch, String serial) {
        this.id = id;
        this.capacity = capacity;
        this.batch = batch;
        this.serial = serial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "ClassRomm{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", batch='" + batch + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
