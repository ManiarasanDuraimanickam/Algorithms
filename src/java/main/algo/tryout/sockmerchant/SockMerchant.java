package algo.tryout.sockmerchant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class SockMerchant {

	public int sockMerchant(int n, int[] totalSocks) {
		Map<Object, Integer> socksPair = new HashMap<>();
		socksPair.put("totalPair", 0);
		Set<Integer> allItems = new HashSet<>();
		List<Integer> s = IntStream.of(totalSocks).sorted().filter((int m) -> {
			Integer sock = socksPair.get(m);
			socksPair.put(m, sock == null ? 1 : sock + 1);
			return !allItems.add(m);
		}).map((m) -> {
			Integer sock = socksPair.get(m);
			int totalPair = socksPair.get("totalPair");
			socksPair.put("totalPair", (sock / 2) + totalPair);
			socksPair.remove(m);
			allItems.clear();
			return m;
		}).collect(ArrayList::new, List<Integer>::add, List::addAll);
		return socksPair.get("totalPair");
	}

	public Map<Integer, Integer> sockMerchant1(int n, int[] totalSocks) {
		Map<Object, Integer> socksPair = new HashMap<>();
		socksPair.put("totalPair", 0);
		Set<Integer> allItems = new HashSet<>();
		List<Integer> s = IntStream.of(totalSocks).sorted().map((int m) -> {
			Integer sock = socksPair.get(m);
			socksPair.put(m, sock == null ? 1 : sock + 1);
			return m;
		}).filter((int m) -> !allItems.add(m)).map((m) -> {
			Integer sock = socksPair.get(m);
			int totalPair = socksPair.get("totalPair");
			socksPair.put("totalPair", (sock / 2) + totalPair);
			return m;
		}).collect(ArrayList::new, List<Integer>::add, List::addAll);
		return null;
	}
}
/**
 * 
 * (int m)-> { System.out.println(m); Integer sock = socksPair.get(m);
 * System.out.println("scok->" + sock); socksPair.put(m, sock == null ? 0 : sock
 * + 1); //return m;
 */