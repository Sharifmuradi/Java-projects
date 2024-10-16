package models;

import java.util.Objects;

public class Location {
    private Double x; //Поле не может быть null
    private double y;
    private String name; //Строка не может быть пустой, Поле может быть null

    public Location(Double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.y, y) != 0) return false;
        if (!Objects.equals(x, location.x)) return false;
        return Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = x != null ? x.hashCode() : 0;
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
