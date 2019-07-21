package DatabasePractice;

public class WorkerBuiledPattern {
	private int employeeid;
    private String name;
    private String location;
    private String department;
    private int salary;
   
	public int getEmployeeid() {
		return employeeid;
	}
	public WorkerBuiledPattern setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
		return this;
	}
	public String getName() {
		return name;
	}
	public WorkerBuiledPattern setName(String name) {
		this.name = name;
		return this;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
    
}
