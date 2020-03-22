package service;

// PersonalityCalculator has two methods findans and findYourBrainType
// int[] findAnswers(String options) and String findYourBrainType(String options) is the method prototype
// findAnswer() accepts String as an argument and returns integer array as an output
// findYourBrainType accepts String as an argument and returns String as an output
// option is a string which contains all the options selected as a string
// Use the split method to segregate the options and store it in a string array.
// Convert the string array into an integer array.
// return the entire integer array to findyourBrainType

public class PersonalityCalculator {
	
	
	int i;
	public int[] findAnswers(String options) {
		
		// use split method to partition the options into a string array.
		String[] ans = options.split(",");
		// use comma as the delimiter in the split method
		// Covert the string array into integer array
		int[] answer = new int[ans.length];
		for(i=0;i<ans.length;i++) {
			answer[i]=Integer.parseInt(ans[i]);
		}
		for(i=0;i<ans.length;i++) {
			System.out.println(answer[i]);
		}
		// return the integer array to findYourBrainType
		// Change the return value of null to the integer array type
		return answer;
	}
	
	/*
A = __ + __ + __ + __ + __ + __ + __ + __ + __ + __ + __ = _____ 
      (Q1) (Q2) (Q3) (Q5) (Q8) (Q10) (Q11) (Q12) (Q14) (Q18) (Q20) 

B = __ + __ + __ + __ + __ + __ + __ + __ + __ = _____ 
     (Q4) (Q6) (Q7) (Q9) (Q13) (Q15) (Q16) (Q17) (Q19) 

* X = 66 - _____ + _______ =
             (A)     (B) 

*/
	
	
	
	public String findYourBrainType(String options) {
		
		// call the findAnswers method to convert the options into an integer array 
		int[] ans = findAnswers(options);
		// Calculate whether your brain is right, left or well balanced based on the formula given above
		int A = ans[0]+ans[1]+ans[2]+ans[4]+ans[7]+ans[9]+ans[10]+ans[11]+ans[13]+ans[17]+ans[19];
		int B = ans[3]+ans[5]+ans[6]+ans[8]+ans[12]+ans[14]+ans[15]+ans[16]+ans[18];
		int braintype=66-A+B;
		
		// you must return an integer rightbrained, leftbrained or noclearpreference
		if(braintype>=20 && braintype<=55)
		{
			return "leftbrained";
		}
		else if(braintype>=56 && braintype<=64)
		{
			return "noclearpreference";
		}
		else
		{
			return "rightbrained";
		}
		// change the return value 
		
	}

}
