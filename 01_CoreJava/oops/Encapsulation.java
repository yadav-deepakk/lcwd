class Car {
  private String color;
  private String brandName;
  private String mileage;

  public Car(String color, String brandName, String mileage) {
    this.color = color;
    this.brandName = brandName;
    this.mileage = mileage;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getMileage() {
    return mileage;
  }

  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  public void start() {
    System.out.println("Car is starting!");
  }

  public void accelerate() {
    System.out.println("Car speed has been increased");
  }

}

public class Encapsulation {
  public static void main(String[] args) {
    Car car = new Car("white", "land rover", "18mpg");
    System.out.println(car);
  }
}
