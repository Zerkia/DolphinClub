import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Nikolaj
 */
public abstract class MotionistSvømmer implements Medlem{
  //Personal info
  private String name;
  private int age;

  public MotionistSvømmer(String name, int age){
    setName(name);
    setAge(age);
  }

  public String getName() { return name; }

  public int getAge() { return age; }

  public void setName(String name) { this.name = name; }

  public void setAge(int age) { this.age = age; }

  @Override
  public String toString() {
    return "Name = " + getName() + "\nAge = " + getAge();
  }
}
