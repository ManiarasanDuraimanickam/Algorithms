package algo.tryout.ds.array.dynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import algo.tryout.ds.array.DynamicArray;

public class TestDynamicArray {

	private DynamicArray dynamicArray = new DynamicArray();

	@Test
	public void testDynamicArray() {
		int n = 2;
		List<List<Integer>> queries = new ArrayList<>();
		List<Integer> queriesRowItems = new ArrayList<>();

		queriesRowItems.add(1);
		queriesRowItems.add(0);
		queriesRowItems.add(5);
		queries.add(queriesRowItems);

		queriesRowItems = new ArrayList<>();
		queriesRowItems.add(1);
		queriesRowItems.add(1);
		queriesRowItems.add(7);
		queries.add(queriesRowItems);

		queriesRowItems = new ArrayList<>();
		queriesRowItems.add(1);
		queriesRowItems.add(0);
		queriesRowItems.add(3);
		queries.add(queriesRowItems);

		queriesRowItems = new ArrayList<>();
		queriesRowItems.add(2);
		queriesRowItems.add(1);
		queriesRowItems.add(0);
		queries.add(queriesRowItems);

		queriesRowItems = new ArrayList<>();
		queriesRowItems.add(2);
		queriesRowItems.add(1);
		queriesRowItems.add(1);
		queries.add(queriesRowItems);

		List<Integer> res = dynamicArray.dynamicArray(n, queries);
		assertEquals(7, res.get(0).intValue());
		assertEquals(3, res.get(1).intValue());
	}
}
