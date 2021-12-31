package Model;

public class Car implements Model {
    public int id;
    public String make;
    public String model;
    public int year;
    public float price;
    public String color;
    public String vinCode;

    public Car(int id, String make, String model, int year, float price, String color, String vinCode) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.vinCode = vinCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    @Override
    public String toString() {
        return make +
                ", " + model +
                "/" + color +
                "/" + vinCode +
                ", year of issue - " + year +
                ", price - " + price;
    }
}
