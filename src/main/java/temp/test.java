package temp;

class A{
	private String name;
	private int age;
	public A(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

}
public class test {
	public static  void main(String args[]) {
		A a =new A("ABC",20);
		System.out.println(a.getName()+" "+a.getAge());
		a.setName("ABCD");
		System.out.println(a.getName()+" "+a.getAge());
		a.setAge(21);
		System.out.println(a.getName()+" "+a.getAge());
	}

}
