package algo.tryout.java.util;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * @author LENOVO
 *
 */
public class AsynchTryout {

//	static Timer timer=null;
//	static Timer getTimer() {
//		if(timer ==null)
//		timer = new Timer();
//		return timer;
//	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		timerTask();
		asych1();

	}

//	private static void timerTask() {
//
//		TimerTask task = getTimeTask();
//		timer.schedule(task, 3000);
//	}

//	private static TimerTask getTimeTask() {
//		TimerTask task = new TimerTask() {
//
//			@Override
//			public void run() {
//				RunTask s = new RunTask();
//				s.run();
//			}
//		};
//		return task;
//	}

//	private static class RunTask {
//		void run() {
//			try {
//				System.out.println("task running...");
//			} finally {
//				reSchedule(5000);
//			}
//		}
//
//		private void reSchedule(int interval) {
//			System.out.println("task running...");
//			timer.schedule(getTimeTask(), interval);
//		}
//	}

	private static void asych2() throws InterruptedException, ExecutionException {
		CompletableFuture s1 = CompletableFuture
				.supplyAsync(() -> Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
				.thenApplyAsync(s -> {
					System.out.println("print first time");
					s.forEach(System.out::println);
//					s.add(16);
					return s;
				}).thenApplyAsync(s -> {
					System.out.println("print second time");
					s.forEach(System.out::println);
//					s.add(17);
					return s;
				});
		// s1.get();
	}

	private static void asych1() {
		long start = System.currentTimeMillis();
		IntStream.range(0, 10000000).boxed().parallel().forEachOrdered(s2 -> {
			// System.out.println("started process with " + s2);
			try {
				CompletableFuture.supplyAsync(() -> s2).thenApplyAsync(s3 -> {
					// System.out.println("print first time " + s2);
					return s3;
				}).thenApplyAsync(s4 -> {
					System.out.println("print second time " + s2);
					return s4;
				}).get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		System.out.println("process completed " + (System.currentTimeMillis() - start) + "ms");

	}

}
