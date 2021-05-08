package staircase;

public class process {
	
	static void staircase(int n) {
		int i = 0;
		int j = 0;
		
		for(i = 0; i < n; i++) //outer loop for number of rows(n)
        { 
			for(j = 2 * (n - i); j >= 0; j--) // inner loop for spaces 
	            {           
	                System.out.print(" "); // printing space
	            } 
            for(j = 0; j <= i; j++) //  inner loop for columns
	            {       
	                System.out.print("* "); // print star
	            }           
            System.out.println(); // ending line after each row
        } 
		
		/*
		   int counter=0;
		   
		   for(int i = 0; i < n; i++)
		   {
		       counter++;
		       for(int k = n; k >= i; k--)
		       {
		           System.out.print(" "); 
		       } 
		       for(int j = 0; j <= counter - 1; j++) 
		       {
		           System.out.print("#");
		       }

		       System.out.print("\n");
		   }
		  */
		
		}  
}
