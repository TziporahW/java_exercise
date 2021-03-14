package tw;
import java.util.Scanner; //Needed for scanner class
import java.io.*; // Needed for File I/O classes


public class fileInputOutput
{
	public static void main(String[] args) throws IOException
	{
		String fileName = "Numbers.txt"; // file name
		
		//open the file
		File numberFile = new File(fileName);
		Scanner inputNumber = new Scanner(numberFile);
		
		//initialize all the variables 
		double smallest = Double.POSITIVE_INFINITY, largest = Double.NEGATIVE_INFINITY, sum = 0, counter = 0, number; 
		//set smallest to positive infinity so first number will automatically be smaller and largest to negative so number will for sure be larger 
		
		//create while loop to read lines from file until no more lines left
		while (inputNumber.hasNext()) {
			number = inputNumber.nextInt(); //set number to next number in file
			//if number is less than smallest - set to smallest
			if (number < smallest) {
				smallest = number;
			}
			//if number is greatest than largest - set to largest 
			if (number > largest) {
				largest = number;
			}
			//add number to total running sum 
			sum += number;
			//add 1 to counter to keep track of amount of numbers 
			counter++;
		}
		inputNumber.close();//close the file
		double average = getAverage(sum, counter);
		
		/** display the smallest, largest and average of the numbers in the file
		 * @param smallest is the smallest number 
		 * @param largest is the largest number
		 * @param average is the average of the numbers
		 */
		displayInfo(smallest, largest, average);
		outputInfo(smallest, largest, average);
	}
	
	public static double getAverage(double sum, double counter) throws IOException
	{
		double average = sum / counter; //compute average
		return average;//return average 
	}
	
	public static void displayInfo(double smallest, double largest, double average) throws IOException
	{
		//display all the info
		System.out.println("The smallest number in the file is " + smallest);
		System.out.println("The largest number in the file is " + largest);
		System.out.println("The average of all the numbers in the file is " + average);
	}
	
	public static void outputInfo(double smallest, double largest, double average) throws IOException
	{
		PrintWriter numberOutput = new PrintWriter("numberOutput.txt "); //create file
		numberOutput.println("The smallest number in the file is " + smallest);
		numberOutput.println("The largest number in the file is " + largest);
		numberOutput.println("The average of all the numbers in the file is " + average);
		
		numberOutput.close();//close the file
	}
	
}