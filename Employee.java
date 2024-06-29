package learnstream;

import learnstream.Department;

public class Employee {
	
	int id;
	String name;
	Integer salary;
	String gender;
	Department department;
	
	
	
	public Employee(int id, String name, Integer salary, String gender, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary=salary;
		this.gender=gender;
		this.department=department;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	
	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}
	
	

}
