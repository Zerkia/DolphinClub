/**
 * @Nikolaj
 */
public class KonkurrenceSvømmer implements Medlem{
  //Personal info
  private String name;
  private int age;
  private String ageGroup;
  //Spørg om konkurrence kan være passiv
  private String status;
  private String swimType;
  private int price;
  private String time;
  //KonkurrenceSvømmer info
  private String discipline;
  private String personalBest;
  private String date;
  //KonkurrenceSvømmer event info
  private String event;
  private int placement;
  private String eventDate;

  public KonkurrenceSvømmer(String name, int age, String ageGroup, String status, String swimType, int price, String time,
                            String discipline, String personalBest, String date, String event, Integer placement,
                            String eventDate
                            ) {
    setName(name);
    setAge(age);
    setAgeGroup(ageGroup);
    setStatus(status);
    setSwimType(swimType);
    setPrice(price);
    setTime(time);
    setDiscipline(discipline);
    setPersonalBest(personalBest);
    setDate(date);
    setEvent(event);
    setPlacement(placement);
    setEventDate(eventDate);
  }

  public String getName() { return name; }

  public int getAge() { return age; }

  public String getAgeGroup() { return ageGroup; }

  public String getStatus() { return status; }

  public String getSwimType(){ return swimType; }

  public int getPrice() {return price; }

  public String getTime() { return time; }

  public String getDiscipline() { return discipline; }

  public String getPersonalBest() { return personalBest; }

  public String getDate() { return date; }

  public String getEvent() { return event; }

  public int getPlacement() { return placement; }

  public String getEventDate() { return eventDate; }

  public void setName(String name) { this.name = name; }

  public void setAge(int age) { this.age = age; }

  public void setAgeGroup(String ageGroup) { this.ageGroup = ageGroup; }

  public void setSwimType(String swimType) { this.swimType = swimType; }

  public void setStatus(String status) { this.status = status; }

  public void setPrice(int price) { this.price = price; }

  public void setTime(String time) { this.time = time; }

  public void setDiscipline(String discipline) { this.discipline = discipline; }

  public void setPersonalBest(String personalBest) { this.personalBest = personalBest; }

  public void setDate(String date) { this.date = date; }

  public void setEvent(String event) { this.event = event; }

  public void setPlacement(int placement) { this.placement = placement; }

  public void setEventDate(String eventDate) { this.eventDate = eventDate; }

  @Override
  public String toString() {
    return "Name = " + getName() +
        "\nAge = " + getAge() +
        "\nAge Group = " + getAgeGroup() +
        "\nStatus = " + getStatus() +
        "\nPrice = " + getPrice() +
        "\nDate of creation = " + getTime() +
        "\nDiscipline = " + getDiscipline() +
        "\nPersonalBest = " + getPersonalBest() +
        "\nPB Date = " + getDate() +
        "\nEvent = " + getEvent() +
        "\nPlacement = " + getPlacement() +
        "\nEventTime = " + getEventDate();
  }
}
