package algo.tryout.pickingnumbers;
import java.util.*;

public class PickingNumber {

	/*public Object[] pickmaxmimumMultiset(int[] inputArray) {
		Object[] result = new Object[2];
		Arrays.sort(inputArray);
		List<List<Integer>> possibleMultisets = new ArrayList<>();
		List<Integer> possibleMultiSet = new ArrayList<>();
		int maxminumMultisetsLenght = -1;
		int frst = -1, scnd = -1;
		int multiSetFirstelement = inputArray[0];
		for (int i = 0; i < inputArray.length - 1; i++) {
			frst = inputArray[i];
			scnd = inputArray[i + 1];
			if (isEligible(frst, scnd, multiSetFirstelement)) {
				multiSetFirstelement = frst;
				possibleMultiSet.add(frst);
				continue;
			}
			multiSetFirstelement = scnd;
			possibleMultiSet.add(frst);
			possibleMultisets.add(possibleMultiSet);
			maxminumMultisetsLenght = maxminumMultisetsLenght > possibleMultiSet.size() ? maxminumMultisetsLenght
					: possibleMultiSet.size();
			possibleMultiSet = new ArrayList<>();
		}
		multiSetFirstelement = scnd;
		possibleMultiSet.add(frst);
		possibleMultisets.add(possibleMultiSet);
		maxminumMultisetsLenght = maxminumMultisetsLenght > possibleMultiSet.size() ? maxminumMultisetsLenght
				: possibleMultiSet.size();
		result[0] = maxminumMultisetsLenght;
		result[1] = possibleMultisets;
		return result;
	}*/

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
			maxminumMultisetsLenght = maxminumMultisetsLenght > (currentMaxLenth+1) ? maxminumMultisetsLenght
					: (currentMaxLenth+1);
			currentMaxLenth=0;
		}
		maxminumMultisetsLenght = maxminumMultisetsLenght > (currentMaxLenth+1) ? maxminumMultisetsLenght
				: (currentMaxLenth+1);
		return maxminumMultisetsLenght;

	}

	private boolean isEligible(int element1, int element2, int initialElement) {
		return ((element2 - element1) <= 1) && (element2 - initialElement <= 1);
	}
}
