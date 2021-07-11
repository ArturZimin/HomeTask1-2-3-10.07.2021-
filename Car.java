package by.minsk.itakademy.arturzimin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    String name;
    Object carModel;
    int capacity;

    public Car(String name, Object carModel, int capacity) {
        this.name = name;
        this.carModel = carModel;
        this.capacity = capacity;

    }
    public Car(){}

    public String getName() {
        return name;
    }

    public Object getCarModel() {
        return carModel;
    }

    public void setCarModel(Object carModel) {
        this.carModel = carModel;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getCapacity() == car.getCapacity() && Objects.equals(getName(), car.getName()) && Objects.equals(getCarModel(), car.getCarModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCarModel(), getCapacity());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("name='").append(name).append('\'');
        sb.append(", carModel=").append(carModel);
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}
