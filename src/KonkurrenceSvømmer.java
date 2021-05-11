import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * @Nikolaj
 */
public class KonkurrenceSvømmer implements Medlem{
  //Personal info
  private String name;
  private int age;
  private String ageGroup;
  private int price;
  private String time;
  //Spørg om konkurrence kan være passiv
  //private String status;
  //KonkurrenceSvømmer info
  private String discipline;
  private String personalBest;
  private String date;
  //KonkurrenceSvømmer event info
  private String event;
  private int placement;
  private String eventTime;

  public KonkurrenceSvømmer(String name, int age, String ageGroup, int price, String time, String discipline,
                            String personalBest, String date, String event, int placement, String eventTime
                            ) {
    setName(name);
    setAge(age);
    setAgeGroup(ageGroup);
    setPrice(price);
    setTime(time);
    setDiscipline(discipline);
    setPersonalBest(personalBest);
    setDate(date);
    setEvent(event);
    setPlacement(placement);
    setEventTime(eventTime);
  }

  public String getName() { return name; }

  public int getAge() { return age; }

  public String getAgeGroup() { return ageGroup; }

  public int getPrice() {return price; }

  public String getTime() { return time; }

  public String getDiscipline() { return discipline; }

  public String getPersonalBest() { return personalBest; }

  public String getDate() { return date; }

  public String getEvent() { return event; }

  public int getPlacement() { return placement; }

  public String getEventTime() { return eventTime; }

  public void setName(String name) { this.name = name; }

  public void setAge(int age) { this.age = age; }

  public void setTime(String time) { this.time = time; }

  public void setDiscipline(String discipline) { this.discipline = discipline; }

  public void setPersonalBest(String personalBest) { this.personalBest = personalBest; }

  public void setDate(String date) { this.date = date; }

  public void setEvent(String event) { this.event = event; }

  public void setPlacement(int placement) { this.placement = placement; }

  public void setEventTime(String eventTime) { this.eventTime = eventTime; }

  @Override
  public String toString() {
    return "Name = " + getName() +
        "\nAge = " + getAge() +
        "\nAge Group = " + getAgeGroup() +
        "\nPrice = " + getPrice() +
        "\nDate of creation = " + getTime() +
        "\nDiscipline = " + getDiscipline() +
        "\nPersonalBest = " + getPersonalBest() +
        "\nPB Date = " + getDate() +
        "\nEvent = " + getEvent() +
        "\nPlacement = " + getPlacement() +
        "\nEventTime = " + getEventTime();
  }
}
