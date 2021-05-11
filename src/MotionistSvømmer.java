import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Nikolaj
 */
public class MotionistSvømmer implements Medlem{
  //Personal info
  private String name;
  private int age;
  private String ageGroup;
  private String status;
  private int price;
  private String time;

  public MotionistSvømmer(String name, int age, String ageGroup, String status, int price, String time){
    setName(name);
    setAge(age);
    setAgeGroup(ageGroup);
    setStatus(status);
    setPrice(price);
    setTime(time);
  }

  public String getName() { return name; }

  public int getAge() { return age; }

  public String getAgeGroup() { return ageGroup; }

  public String getStatus() { return status; }

  public int getPrice() { return price; }

  public String getTime() { return time; }

  public void setName(String name) { this.name = name; }

  public void setAge(int age) { this.age = age; }

  public void setAgeGroup(String ageGroup) { this.ageGroup = ageGroup; }

  public void setStatus(String status) { this.status = status; }

  public void setPrice(int price) { this.price = price; }

  public void setTime(String time) { this.time = time; }

  @Override
  public String toString() {
    return "Name = " + getName() + "\nAge = " + getAge() +
        "\nAge Group = " + getAgeGroup() + "\nSwimming Status = " + getStatus() +
        "\nPrice per year = " + getPrice() + "\nDate of creation = " + getTime();
  }
}
