package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "userCar", cascade = CascadeType.ALL)
    private User carUser;

    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getCarUser() {
        return carUser;
    }

    public User setCarUser(User carUser) {
        this.carUser = carUser;
        return carUser;
    }

    @Override
    public String toString() {
        return "Car: " +
                "Model= " + model + "; " +
                "Series= " + series;
    }






}
