package algo.tryout.java;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLabel {

	public static void main(String[] args) throws InterruptedException {
		// testMapFlatMap();
		List<String> f=new LinkedList<String>();
		((LinkedList)f).add("how");
		((LinkedList)f).addLast("you");
		((LinkedList)f).addFirst("hai");
		((LinkedList)f).add("are");
		//System.out.println(Arrays.toString(f.toArray()));
		
		for(String s:f) {
			System.out.println(s);
		}
		
		System.err.println("itertor");
		for(Iterator< String> itr=f.iterator();itr.hasNext();) {
			System.out.println(itr.next());
		}
		//DataFlavorUtil s;
		
//		DesktopDatatransferService s=new DesktopDatatransferServiceImpl();
//		jdk.internal.perf.PerfCounter
		
		exploreFunctions();
//		testLabeledLoopBreak();
//		testLabeledLoopContinue();
//		threadCreateAndJoin();
//		fibonacci.accept(1000);
	}

	private static void exploreFunctions() {
		Function<String, String> f1 = (s) -> {
			System.out.println("s " + s);
			s.chars().map(c1 -> {
				System.out.println(c1);
				return c1;
			}).toArray();
			System.out.println("Uppercase");
			Stream<Character> d=CharBuffer.wrap(s.toCharArray()).chars().mapToObj( c3 -> {
				System.out.println(c3);
				return (char) (c3 - 32);
			});
			return d.map(String::valueOf).collect(Collectors.joining());
		};
  
		Function<String, String> f2 = s1 -> {
			System.out.println("s1 " + s1);
			return s1;
		};

		/*
		 * Function<String,String> f3=s4->{
		 * 
		 * };
		 */
		Object s = Function.identity().compose(f2).compose(f1).apply("abcdefghijklmnopqrstuvwxyz");
		System.out.println(" Final - " + s);
	}

	private static void testMapFlatMap() {
		List<List<String>> fruties = new ArrayList<List<String>>();
		List<String> apples = new ArrayList<String>();
		apples.add("indian-Apples");
		apples.add("American-Apples");
		fruties.add(apples);

		List<String> orange = new ArrayList<String>();
		apples.add("indian-orange");
		apples.add("American-orange");
		fruties.add(orange);
		List<Stream<String>> g = fruties.stream().map(s -> {
			System.out.println("ttt" + s);
			return s.stream();
		}).collect(Collectors.toList());
		List<String> f = fruties.stream().flatMap(s -> {
			System.out.println("yyyygygy" + s);
			return s.stream();
		}).collect(Collectors.toList());
		System.out.println("map- " + g);
		g.forEach(s -> {
			s.forEach(System.out::println);
		});
		System.out.println("flatmap- " + f);
	}

	private static void testLabeledLoopContinue() {
		outer: for (int i = 0; i <= 10; i++) {
			System.out.println("current value of i=" + i);
			labelX:

			for (int j = 0; j < 10; j++) {
				System.out.println("current value of j=" + j);
				labelY: if (j % 3 != 0) {
					continue labelX;
				}
				printLableY();
				printLabelX();

			}
			if (i % 3 != 0) {
				continue outer;
			}
			System.out.println("J loop executed" + i);
		}
		System.out.println("condition terminated. moving out of the method.");

	}

	private static void testLabeledLoopBreak() {

		outer: {
			for (int i = 0; i < 10; i++) {
				printLabelX: {
					printLabelY: {
						if (i == 6) {
							System.out.println(
									"inside loop new if, nothing will printed and condition terminated.. i=" + i);
							break outer;
						}
						if (i % 2 == 0) {
							System.out
									.println("inside loop mod2.. x and y will not printed and moving to next, i=" + i);
							break printLabelX;
						} else if (i % 3 == 0) {
							System.out.println("inside loop mod3.. y will not printed.. i=" + i);
							break printLabelY;
						} else {
							System.out.println("X and Y will print.. i=" + i);
						}
						printLableY();
					}
					printLabelX();
				}

			}
		}
		System.out.println("outside loop..");

	}

	private static void printLabelX() {
		System.out.println("X printed..");
	}

	private static void printLableY() {
		System.err.println("Y printed..");
	}

	private static void threadCreateAndJoin() throws InterruptedException {
		Thread t1 = new Thread(print);
		Thread t2 = new Thread(print);
		t1.start();
		t1.join();
		t2.start();
		t2.join();

	}

	static Runnable print = () -> {
		System.out.println("thread ");
		try {
			Thread.sleep(5000);
			System.err.println("thread awake.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	static Consumer<Integer> fibonacci = i -> {
		int a = 0, b = 1, sum = 0;
		while (a < i) {
			System.out.print(a + " ");
			sum = a + b;
			a = b;
			b = sum;
		}
	};
}
