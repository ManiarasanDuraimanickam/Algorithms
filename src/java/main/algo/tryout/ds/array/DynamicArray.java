package algo.tryout.ds.array;

import java.util.LinkedList;
import java.util.List;

/**
 * I will try to clarify the question for people which are having a hard time to
 * understand it, like I was: seqList is basically an Anrray of Arrays, each
 * Array in seqList will be dynamic, while seqList itself will be static with
 * the input 'N' determining the number of Arrays that will compose it. The 'Q'
 * input will determine the number of Queries. Each Query will demand an input
 * of 3 integers: 't', 'x' and 'y'. The 't' is for "type". The type 1 Query will
 * append the 'y' variable to some array in seqList, the formula will specify
 * which one. The type 2 Query will take some value, that was alredy assigned to
 * some Array of the seqList, and copy that to lastAnswer. The first formula
 * specifies the array of seqList and the second formula specifies which value
 * of that Array must be taken. I hope the schematic below make it clearer.s
 * 
 * @author maniarasand
 *
 */
public class DynamicArray {

	public List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<Integer> answer = new LinkedList<>();
		Object[] dyArr = new Object[n];
		int pos = 0,lastAns=0;
		for (List<Integer> querie : queries) {
			pos= ((querie.get(1) ^ lastAns) % n);
			int[] insArray = (int[]) dyArr[pos];
			if (querie.get(0) == 2) {
				lastAns = insArray[(querie.get(2)%insArray.length)];
				answer.add(lastAns);
			} else {
				if (null == insArray) {
					insArray = new int[1];
				} else {
					int[] tempinsArray = new int[insArray.length + 1];
					for (int i = 0; i < insArray.length; i++) {
						tempinsArray[i] = insArray[i];
					}
					insArray = null;
					insArray = tempinsArray;
				}
				insArray[insArray.length-1] = querie.get(2);
				dyArr[pos]=insArray;
			}
		}
		return answer;

	}

}
