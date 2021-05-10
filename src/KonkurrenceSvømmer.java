import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.LocalDate;

public class KonkurrenceSvømmer implements Medlem{
  //Personal info
  private String name;
  private int age;
  //Spørg om konkurrence kan være passiv
  //private String status;
  //KonkurrenceSvømmer info
  private String discipline;
  private String personalBest;
  private LocalDate date;
  //KonkurrenceSvømmer event info
  private String event;
  private int placement;
  private LocalTime eventTime;

  public String getName() { return name; }

  public int getAge() { return age; }

  public String getDiscipline() { return discipline; }

  public String getPersonalBest() { return personalBest; }

  public LocalDate getDate() { return date; }

  public String getEvent() { return event; }

  public int getPlacement() { return placement; }

  public LocalTime getEventTime() { return eventTime; }

  public void setName(String name) { this.name = name; }

  public void setAge(int age) { this.age = age; }

  public void setDiscipline(String discipline) { this.discipline = discipline; }

  public void setPersonalBest(String personalBest) { this.personalBest = personalBest; }

  public void setDate(LocalDate date) { this.date = date; }

  public void setEvent(String event) { this.event = event; }

  public void setPlacement(int placement) { this.placement = placement; }

  public void setEventTime(LocalTime eventTime) { this.eventTime = eventTime; }

  @Override
  public String toString() {
    return "Name = " + getName() +
        "\nAge = " + getAge() +
        "\nDiscipline = " + getDiscipline() +
        "\nPersonalBest = " + getPersonalBest() +
        "\nPB Date = " + getDate() +
        "\nEvent = " + getEvent() +
        "\nPlacement = " + getPlacement() +
        "\nEventTime = " + getEventTime();
  }
}
