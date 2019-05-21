package algo.tryout.pickingnumbers;

import java.util.*;

/**
 * LOGIC ALERT :-
 * 
 * you just have to find out the multiset which has the maximum number of
 * elements that satisfies the condition given in the question. Now see if you
 * pick up elements like ,say, { 4,4,5,5,6} , so it is not a valid multiset
 * because if you'd find out the difference between 6 and 4 , it will be 2 which
 * is again greater than 1. SO now analyse through number thoery that no three
 * consecutive elements can have the difference equal to one among the one
 * except they are two subsequent numbers . Let's analyse this from the above
 * example . {4,4,5,5} can be a valid multiset ,{5,5,6} can be a valid one
 * because in each multiset there are two subsequent numbers . In first , it is
 * 4 and 5. In second 5 and 6. So you just have to find out the frequency of the
 * TWO consecutive numbers . Take a static array say ar and start find the
 * frequency of every element in the array (original ). Now you have the array
 * ar which contains frequency of every element in the original array . You just
 * have to find out the maximum frequency of the consequent elements .
 */
public class PickingNumber {

	public int pickmaxmimumMultiset(List<Integer> inputArray) {
		Collections.sort(inputArray);
		int maxminumMultisetsLenght = -1, frst = -1, scnd = -1;
		int multiSetFirstelement = inputArray.get(0), currentMaxLenth = 0;
		for (int i = 0; i < inputArray.size() - 1; i++) {
			frst = inputArray.get(i);
			scnd = inputArray.get(i + 1);
			if (isEligible(frst, scnd, multiSetFirstelement)) {
				currentMaxLenth++;
				continue;
			}
			multiSetFirstelement = scnd;
			maxminumMultisetsLenght = maxminumMultisetsLenght > (currentMaxLenth + 1) ? maxminumMultisetsLenght
					: (currentMaxLenth + 1);
			currentMaxLenth = 0;
		}
		maxminumMultisetsLenght = maxminumMultisetsLenght > (currentMaxLenth + 1) ? maxminumMultisetsLenght
				: (currentMaxLenth + 1);
		return maxminumMultisetsLenght;

	}

	private boolean isEligible(int element1, int element2, int initialElement) {
		return ((element2 - element1) <= 1) && (element2 - initialElement <= 1);
	}
}
