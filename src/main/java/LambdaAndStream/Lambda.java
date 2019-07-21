package LambdaAndStream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lambda{
	private final static Logger log =  LoggerFactory.getLogger(Lambda.class);
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String args[]) {
		Lambda lambda = new Lambda();
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		lambda.greet(helloWorldGreeting);
		Greeting myGreeting = () -> System.out.println("My Greetings");
		lambda.greet(myGreeting);
		myGreeting.perform();

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };		
		Perform perform = (int array[]) -> {
			int sum =0;
			for (int i = 0; i < array.length; i++) {
				sum+=array[i];
			}
			return sum;
		};
		
		
		perform.perform(arr);
		Predicate<Integer> predicate = a -> Math.sqrt(a)*Math.sqrt(a) == a;
		//Predicate<Integer> predicate = a -> a%2 == 0;
		
		Print print = (int array[],Predicate<Integer> predicate2)-> {
			for (int i = 0; i < array.length; i++) {
				if(predicate.test(arr[i]))
				log.info(String.valueOf(array[i]));
			}
		};
		print.print(arr,predicate);
		
		Map<String, Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("John", s -> s.length());
		log.debug(value.toString());
		
		long startTime = System.nanoTime();
		log.debug(isPrime2(978789977).toString());
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		
		
	}
	private static Boolean isPrime(int number) {		
		if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}
	private static Boolean isPrime2(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1
				&& IntStream.range(2, number).noneMatch(
						isDivisible);
	}
}
interface Perform{
	public int perform(int arr[]);
}
interface Print{
	public void print(int arr[],Predicate<Integer>predicate);
}
