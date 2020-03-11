/*=============================================================================  
|   Source code:  ComputeE.java
|        Author:  Richard Molina 
|    Student ID:  6140544  
|    Assignment:  Program #1 - Compute e
|  
|            Course:  COP 3337 (Intermediate Programming)  
|           Section:  U08  
|        Instructor:  William Feild  
|        Due Date:  6 September 2018, at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|     Language:  Java 
|  Compile/Run:   
| 		javac ComputeE.java
|		java ComputeE
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  This program uses an algorithm to calculate e (Euler's number) 
|                to a predetermined decimal-place accuracy. This calculated value 
|                is then displayed in the console alongside the Math library 
|                expected value of e, so that the user can easily compare the two. 
|                The program also tracks and displays the number of iterations the 
|                algorithm required to reach the desired level of accuracy.
|                  
|        Input:  N/A  
|  
|       Output:  The program will display the calculated value of e, the expected
|			     value of e, and the number of iterations the algorithm required 
|                to reach the desired level of accuracy.  
|  
|      Process:  The program's steps are as follows:
|			
|				 1. The program executes a loop set to run while the change in 
|				    the computed value for e is greater than the desired decimal-
|					place accuracy
|				 2. Within the loop, a local newComputedE is estimated using the
|					summation formula 1/n!, where n is the current iteration
|					(starting at 0)
|				 3. The function factorial is called, using a for loop to sum the 
|					products of n as n is decremented
|				 4. The delta is calculated by subtracting the computedE from the
|					newComputedE
|				 5. The iteration is incremented
|				 6. The newComputedE is stored in computedE
|				 7. When the while loop terminates, the computedE, expectedE, and
|					the number of iterations is displayed to the user
|  
|   Required Features Not Included: All of the required features are included in 
|                                   the program. 
|  
|   Known Bugs:  None; the program operates correctly.  
|  *===========================================================================*/

public class ComputeE
{
	/*---------------------------- factorial ----------------------------
    |  Method factorial (input)
    |
    |  Purpose:  Calculate the factorial of the input.
    |
    |  @param	input desired factorial 
    |
    |  @return  the value of the factorial of the input
    *-------------------------------------------------------------------*/

	public static double factorial(int input)
	{
		double output = 1.0;
		
		if (input == 0)   //0! == 1, a special case; Also guards against division by 0
		{
			return output;
		}	//close if
		else
		{
			for (int counter = input; counter > 0; counter--)
			{
				output *= counter;
			}	//close for (int counter = input; counter > 0; counter--)
		}	//close else
		
		return output;
	}	//close factorial method
	
	public static void main(String[] args)
	{
		final int DECIMAL_PLACE_ACCURACY = 16;	//The desired # of accurate decimal places
		int iterations = 0;
		double computedE = 0.0;		
		double delta = 1.0;	  //Initialized at 1.0 to ensure the While loop executes
		
		while (delta > Math.pow(10, -DECIMAL_PLACE_ACCURACY))   
		{
			double newComputedE = computedE + (1.0 / (factorial(iterations)) );   
			//The infinite series formula used to estimate e
			
			delta = newComputedE - computedE;   
			//Loop terminates when change in estimation is less than desired accuracy 
			
			iterations++;
			
			computedE = newComputedE;
		}	//close while (delta > Math.pow(10, -DECIMAL_PLACE_ACCURACY))
			
		
		System.out.println("Computed value of e = " + computedE);
		System.out.println("Expected value of e = " + Math.E);
		System.out.println("Required iterations = " + iterations);
	}
}
