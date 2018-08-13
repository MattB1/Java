/**
 	Author: Matthew Bubb
	Date: 8th of August, 2017
*/
/**
	The DriverExam class holds the correct answers to a driver's license exam in an array field.
	The class also has an array field that holds the student's answers. It provides methods
	to determine whether a student has passed or failed an exam, the total amount of correct/incorrect 
	answers, and also which questions were missed. 
*/
public class DriverExam
{
	private char [] correctAnswers = { 'b','d','a','a','c',	// An array of correct answers
					    'a','b','a','c','d',
					    'b','c','d','a','d',
					    'c','c','b','d','a'};
	private char[] studentAnswers;				// An array of the students answers
	private int numberOfQuestions = correctAnswers.length;	// Ensures the number of questions equals the answers  
								 

	/**
	   Constructor
	   @param studentArray accepts an array of answers and copies to the students answers array field
	 */

	public DriverExam(char [] studentArray)
	{
		studentAnswers = studentArray;
	}

	/**
	  passed method 
	  which returns a boolean value depending if the student passed or failed.
	  @return true or false 
	 */
	public boolean passed()
	{	
		int passingScore = 10;

		if (totalCorrect() >= passingScore)
		{
			return true;
		}
		else 
			return false;
	}

	/**
	  totalCorrect method
	  which loops through the students answers array and determines the number
	  of correctly answered questions.
	  @return totalCorrectAnswers The total amount of correct answers
	 */
	
	public int totalCorrect()
	{
		int totalCorrectAnswers = 0;		

		for(int index = 0; index < numberOfQuestions; index++)
		{
			if (correctAnswers[index] == studentAnswers[index])
			{
				totalCorrectAnswers = totalCorrectAnswers + 1;
			}
		}
		return totalCorrectAnswers;			
	}

	/**
	  totalIncorrect method
	  @return incorrectAnswers the total number of incorrectly answered questions
	 */
	public int totalIncorrect()
	{
		int incorrectAnswers = 0;		

		for(int index = 0; index < numberOfQuestions; index++)
		{
			if (!(correctAnswers[index] == studentAnswers[index]))
			{
				incorrectAnswers = incorrectAnswers + 1;
			}
		}
		return incorrectAnswers;			
	}

	/**
	  questionsMissed method
	  loops through the student array to determine the missed questions
	  @return questionsMissedArray an array of the students missed questions
	 */
	public int[] questionsMissed()
	{
		int size = numberOfQuestions - totalCorrect();
		int [] questionsMissedArray = {};
		if (size <1)
			return questionsMissedArray;
		else
			questionsMissedArray = new int [size];
		
		int questionsMissedArrayIndex = 0;

		for(int index = 0; index < numberOfQuestions; index++)
		{
			if (!(correctAnswers[index] == studentAnswers[index]))
			{
				questionsMissedArray[questionsMissedArrayIndex] = index + 1;
				questionsMissedArrayIndex++;	
			}
		}
		return questionsMissedArray;
	}
}
