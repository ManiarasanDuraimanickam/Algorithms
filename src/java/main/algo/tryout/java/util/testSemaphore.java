package algo.tryout.java.util;

import java.math.BigInteger;
import java.util.concurrent.Semaphore;

public class testSemaphore {

	static Semaphore semaphore = new Semaphore(1, true);

	public static void main(String[] args) throws InterruptedException {
		final String s = "0101001101110100011100100110010101110011011100110110010101100100";
		System.out.println(new String(new BigInteger('0'+s, 2).toByteArray()));
		int num=101>>1;
		String binum=Integer.toBinaryString(num);
		System.out.println("num"+new String(new BigInteger('0'+binum, 2).toByteArray()) );
		Runnable r = () -> {
			printMsg(Thread.currentThread().getName(), "try to acquire ");
			if (semaphore.hasQueuedThreads()) {
				semaphore.release();
			}
			try {
				semaphore.acquire();
				printMsg(Thread.currentThread().getName(), "acquired..");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		};
		Thread t = new Thread(r, "t1");
		t.start();
		Thread t2 = new Thread(r, "t2");
		t2.start();
		Thread t3 = new Thread(r, "t3");
		t3.start();
		t.join();
		t2.join();
	}

	static void printMsg(String thread, String msg) {
		System.out.println(thread + " " + msg);
	}
}
