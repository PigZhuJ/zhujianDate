package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class clockIn {
    //时间段
    private SimpleIntegerProperty number;
    //时间
    private SimpleStringProperty date;

    public clockIn(int number,String date) {
        this.number =new SimpleIntegerProperty(number);
        this.date= new SimpleStringProperty(date);
    }

    public int getNumber() {
        return number.get();
    }

    public void setNumber(int number) {
        this.number = new SimpleIntegerProperty(number);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
    }
}
