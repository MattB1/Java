 //Author: Matthew Bubb
//Date: 21st of September, 2017
/**
 * The TestScores class is a class that provides methods to ensure that an array of test
 * scores will only have scores greater than zero and less than one hundred. The TestScores
 * class will throw an InvalidTestScore exception if it detects an invalid entry in the array.	
 */
public class TestScores
{
	double[] scores;
	double invalid;
	int element;
	/**
	 * Constructor:
	 * Accepts a double array of test scores as its argument and detects any score
	 * less than zero or greater than one hundred. If this is detected it will 
	 * throw an InvalidTestScore exception.
	 * @param scoreArray an array of scores
	 * @throws InvalidTestScore exception to handle the invalid score
	 */
	public TestScores(double[] scoreArray) throws InvalidTestScore
	{
		scores = scoreArray;
		for (int i = 0; i< scores.length; i++)
		{
			if (scores[i] < 0 || scores[i] > 100)
			{	
				invalid = scores[i];
				element = i;
				throw new InvalidTestScore(element, invalid);
			}
		}		
			
	}

	/**
	 * getAverage: 
	 * A method that determines the average of test scores
	 * @return average of test scores
	 */
	public double getAverage()
	{
		double average = 0;
		double sum = 0;
		for(int i = 0; i< scores.length; i++)
			sum = sum + scores[i];
		average = sum / scores.length;
		return average;
			
	}
}
