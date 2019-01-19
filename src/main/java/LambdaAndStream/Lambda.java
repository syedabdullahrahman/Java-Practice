package LambdaAndStream;

public class Lambda {
	public void greet(Greeting greeting) {
		greeting.perform();
	}
	public static void main(String args[]) {
		Lambda lambda = new Lambda();
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		lambda.greet(helloWorldGreeting);
		Greeting myGreeting = ()-> System.out.println("My Greetings");
		lambda.greet(myGreeting);
		myGreeting.perform();
	}

}
