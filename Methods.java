package P1;

import java.util.Random;

public class Methods {
	
	// Number is perfect?
	public static  boolean isPerfect(int number) {
		int sum = 0;
		for (int it = 1; it < number; it++) {
			if (number % it == 0) {
				sum += it;
			}
		}
		 if (sum != number) {
			 return false;
		 }
		
		 return true;
	}
	
	// Number is prime??
	 public static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int it = 2; it <= number -1; it++) {
			if (number % it == 0) {
				return false;
			} 
		}
		return true;
	}
	 
	 // Return digit sum
	public static int digitSum(int number) {
		int digitSum = 0;
		while (number != 0) {
			digitSum += number % 10;
			number /= 10;
		}
		return digitSum;
	}
	
	// random
	public static int generateArtifact(int upperLimit){
	   Random random = new Random();
	   int newRandom = random.nextInt(upperLimit);
	   return newRandom;
	}

}
