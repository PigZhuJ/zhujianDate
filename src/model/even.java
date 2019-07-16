package model;

import javafx.beans.property.SimpleStringProperty;

public class even {

    private SimpleStringProperty evenBeginTimeCol;
    private SimpleStringProperty evenEndTimeCol;
    private SimpleStringProperty evensCol;
    private SimpleStringProperty evenFinishedCol;

    public even(String evenBeginTimeCol, String evenEndTimeCol, String evensCol, String evenFinishedCol) {
        this.evenBeginTimeCol = new SimpleStringProperty(evenBeginTimeCol);
        this.evenEndTimeCol = new SimpleStringProperty(evenEndTimeCol);
        this.evensCol = new SimpleStringProperty(evensCol);
        this.evenFinishedCol = new SimpleStringProperty(evenFinishedCol);
    }

    public String getEvenBeginTimeCol() {
        return evenBeginTimeCol.get();
    }

    public SimpleStringProperty evenBeginTimeColProperty() {
        return evenBeginTimeCol;
    }

    public void setEvenBeginTimeCol(String evenBeginTimeCol) {
        this.evenBeginTimeCol.set(evenBeginTimeCol);
    }

    public String getEvenEndTimeCol() {
        return evenEndTimeCol.get();
    }

    public SimpleStringProperty evenEndTimeColProperty() {
        return evenEndTimeCol;
    }

    public void setEvenEndTimeCol(String evenEndTimeCol) {
        this.evenEndTimeCol.set(evenEndTimeCol);
    }

    public String getEvensCol() {
        return evensCol.get();
    }

    public SimpleStringProperty evensColProperty() {
        return evensCol;
    }

    public void setEvensCol(String evensCol) {
        this.evensCol.set(evensCol);
    }

    public String getEvenFinishedCol() {
        return evenFinishedCol.get();
    }

    public SimpleStringProperty evenFinishedColProperty() {
        return evenFinishedCol;
    }

    public void setEvenFinishedCol(String evenFinishedCol) {
        this.evenFinishedCol.set(evenFinishedCol);
    }
}
