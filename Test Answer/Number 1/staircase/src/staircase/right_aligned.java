package staircase;

import java.util.Scanner;

public class right_aligned {

	public static void main(String[] args) {				
		boolean flag;
		int finalResult = 0;
        String inputStaircase;
        
        do
        {
        	System.out.println("Enter input staircase: ");
        	Scanner sc = new Scanner(System.in);
        	inputStaircase = sc.next();
        	
	        try
	        {
	        	finalResult = Integer.parseInt(inputStaircase);
	            flag = false;
	            
	            if(finalResult == 0) {
	            	flag = true;
	            	System.out.println("Value can not zero (0)!");
	            }
	            else if(finalResult > 100) {
	            	flag = true;
	            	System.out.println("Value can not more than a hundreed (100)!");
	            }
	            else {
	            	flag = false;
	            }
	        }
	        catch(NumberFormatException e)
	        {
	            System.out.println("Enter only integer value");
	            flag = true;
	        }              
        }
        while(flag);
           
        
        process.staircase(finalResult);
    }
}


