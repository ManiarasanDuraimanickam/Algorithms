package algo.tryout.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeterminingDNAHealth {

	public static void main(String[] args) throws IOException {
		int lowestVal = Integer.MAX_VALUE;
		int highestVal = Integer.MIN_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] genesItems = br.readLine().split(" ");

		String[] healthItems = br.readLine().split(" ");

		int s = Integer.parseInt(br.readLine());

		for (int sItr = 0; sItr < s; sItr++) {
			String[] firstLastd = br.readLine().split(" ");

			int first = Integer.parseInt(firstLastd[0]);

			int last = Integer.parseInt(firstLastd[1]);

			String d = firstLastd[2];
			// Set<String> filteredGenes=getFilteredGenes(genes,first,last);
			int res = findHealthiest(genesItems, healthItems, first, last, d);
			if (res > highestVal)
				highestVal = res;
			else if (res < lowestVal)
				lowestVal = res;
			System.out.println(lowestVal + " " + highestVal);
		}

		br.close();
	}

//	6
//	a b c aa d b
//	1 2 3 4 5 6
//	3
//	1 5 caaab
//	0 4 xyz
//	2 4 bcdybc

	/*
	 * private static void findHealthiest(Map<String,Integer>genesHealth,String[]
	 * genes,int first,int last,String d){ Stream<String>
	 * filteredGenesStrm=Arrays.stream(genes, first, last);
	 * filteredGenesStrm.forEach(System.out::println);
	 * filteredGenesStrm.forEach(System.out::println); int
	 * value=Arrays.stream(d.split(""),0,d.length()).filter(c->{ return
	 * filteredGenesStrm.anyMatch(s->{ return s.equals(c); }); }).map(s1->{ return
	 * genesHealth.get(s1); }).reduce(0,(a,b)->{ return DeterminingDNAHealth.add(a,
	 * b); });
	 * 
	 * 
	 * }
	 */
	private static int findHealthiest(String[] genes, String[] health, int first, int last, String d) {
		Map<String, Integer> genesHealth = new HashMap<String, Integer>();
		int maxLen = Integer.MIN_VALUE;
		int minLen = Integer.MAX_VALUE;
		String gene;
		for (int i = first; i <= last; i++) {
			gene = genes[i];
			maxLen = gene.length() > maxLen ? gene.length() : maxLen;
			minLen = gene.length() < minLen ? gene.length() : minLen;
			if (!genesHealth.containsKey(gene))
				genesHealth.put(gene, Integer.parseInt(health[i]));
			else
				genesHealth.put(gene, genesHealth.get(gene) + Integer.parseInt(health[i]));
		}
		String searchStr;
		int totalHealthiesVal = 0;
		boolean breakSearch = false;
		for (int i = 0; i <= d.length(); i++) {
			if (maxLen >= d.length()) {
				maxLen = d.length();
				breakSearch = true;
			}
			searchStr = d.substring(i, maxLen);
			totalHealthiesVal += searchSubWord(genesHealth, minLen, searchStr, breakSearch);
			if (breakSearch) {
				break;
			}
			maxLen++;
		}
		return totalHealthiesVal;

	}

	static int searchSubWord(Map<String, Integer> genesHealth, int minLenofWord, String searchSubStr,
			boolean breakSearch) {
		if (breakSearch)
			return searchForward(genesHealth, minLenofWord, searchSubStr);
		else
			return searchBackward(genesHealth, minLenofWord, searchSubStr);
	}

	static int searchForward(Map<String, Integer> genesHealth, int minLenofWord, String searchSubStr) {
		int geneTotalVal = 0;
		Integer geneVal;
		for (int i = 0; i <= searchSubStr.length(); i++) {
			geneVal = getGeneHealthiesVal(genesHealth, searchSubStr.substring(i, searchSubStr.length()));
			if (geneVal != null) {
				geneTotalVal += geneVal.intValue();
				break;
			}
		}
		return geneTotalVal;
	}

	static int searchBackward(Map<String, Integer> genesHealth, int minLenofWord, String searchSubStr) {
		int geneTotalVal = 0;
		Integer geneVal;
		for (int i = searchSubStr.length(); i >= minLenofWord; i--) {
			geneVal = getGeneHealthiesVal(genesHealth, searchSubStr.substring(0, i));
			if (geneVal != null) {
				geneTotalVal += geneVal.intValue();
				break;
			}
		}
		return geneTotalVal;
	}

	static Integer getGeneHealthiesVal(Map<String, Integer> genesHealth, String gene) {
		return genesHealth.get(gene);
	}

}
