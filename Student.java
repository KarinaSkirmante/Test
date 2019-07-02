package demo.models;

public class Student {
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	private static int idCounter = 0;
	public void setId() {
		this.id = idCounter++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		setId();
	}
	public Student()
	{
		
	}
	

}
