package DatabasePractice;

public class Worker {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Worker [employeeid=" + employeeid + ", name=" + name + ", location=" + location + ", department="
				+ department + ", salary=" + salary + "]";
	}

	private int employeeid;
    private String name;
    private String location;
    private String department;
    private int salary;

	public int getEmployeeid() {
		return employeeid;
	}

	public Worker() {
		// TODO Auto-generated constructor stub
	}
	public Worker(int employeeid,String name, String location, String department, int salary) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.location = location;
		this.department = department;
		this.salary = salary;
	}
	
	public Worker(String name, String location, String department, int salary) {
		super();
		this.name = name;
		this.location = location;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + employeeid;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (employeeid != other.employeeid)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
