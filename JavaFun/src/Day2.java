import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
	// Entry Point
	public static void main(String[] args) {
		// Arrays
		String[] people = {"Matthew", "Edgar", "David", "Laura"};
		
		// ARRAYS ARE FIXED IN SIZE!
		int[] numbers = new int[10];
		for(int i = 0; i<numbers.length; i++) {
			numbers[i] = i + 1;
		}
		
		// Array Lists
		System.out.println(Arrays.toString(numbers));
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("one"); // 0
		stringList.add("two"); // 1
		stringList.add("three"); // 2
		stringList.add("four"); // 3
		System.out.println(stringList);
		
		for(String number : stringList) {
			System.out.println(number);
		}
		
		System.out.println(stringList.indexOf("cookies"));
		
		// Hash Maps var object = {key => value}
		HashMap<String, String> ourHobbies = new HashMap<String, String>();
		ourHobbies.put("Matt", "Photography");
		ourHobbies.put("Edgar", "Singing");
		ourHobbies.put("MichaelS", "Playing Video Games");
		ourHobbies.put("David", "Reading");
		ourHobbies.put("Curtis", "Football");
		ourHobbies.put("Laura", "Sewing / Quilting");
		ourHobbies.put("Michael", "Playing guitar");
		ourHobbies.put("Libo", "Cooking");
		ourHobbies.put("Kevin", "Play Soccer");
		
		System.out.println(ourHobbies.get("Laura"));
		for(String name : ourHobbies.keySet()) {
			System.out.println(name);
		}
		
		for(String hobby: ourHobbies.values()) {
			System.out.println(hobby);
		}
		
		for(HashMap.Entry<String, String> entry : ourHobbies.entrySet()) {
			System.out.println("key = " + entry.getKey() + " Value "   + entry.getValue());
		}
		
		System.out.println(getMax(numbers));
		sayHello();
	}
	
	public static int getMax(int[] nums) {
		int maxNumber = nums[0];
		for(int i = 0; i <= nums.length; i++) {
			try {
			if(maxNumber < nums[i]) {
				maxNumber = nums[i];
			} } catch (Exception e) {
				System.out.println(e);
			}
		}
		return maxNumber;
	}
	
	public static void sayHello() {
		System.out.println("Hello");
	}
	
}
