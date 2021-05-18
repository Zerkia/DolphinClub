/**
 * @Mads
 */
public interface Medlem {
	String toString();

	String getName();
	int getAge();
	String getTime();
	String getStatus();
	String getSwimType();

	void setName(String name);
	void setAge(int age);
	void setTime(String time);
	void setStatus(String status);
	void setSwimType(String swimType);
}
