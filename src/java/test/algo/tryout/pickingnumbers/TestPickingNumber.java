package algo.tryout.pickingnumbers;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPickingNumber {

	private MySolutionForthatQuestion mySolutionForthatQuestion;

	@Before
	public void loadMySolutionForthatQuestion() {
		this.mySolutionForthatQuestion = new MySolutionForthatQuestion();
	}
	
	@Test
	public void testPickmaxmimumMultiset() {
		List<Integer>inputArray=Arrays.asList(1,1,2,2,4,4,5,5,5);
		int res=this.mySolutionForthatQuestion.pickmaxmimumMultiset(inputArray);
		System.out.println("maximumLength="+res);
	}
	
	@Test
	public void testPickmaxmimumMultiset1() {
		
		List<Integer>inputArray=Arrays.asList(4,6,5,3,3,1);
		int result=this.mySolutionForthatQuestion.pickmaxmimumMultiset(inputArray);
		System.out.println("maximumLength="+result);
	}

	@After
	public void unLoadMySolutionForthatQuestion() {
		this.mySolutionForthatQuestion = null;
	}
}
