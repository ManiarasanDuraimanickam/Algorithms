package algo.tryout.java.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedVSLock {

	public static void main(String[] args) throws InterruptedException {
		SynchronizedVSLock synchronizedVSLock = new SynchronizedVSLock();
		DataAccess data = synchronizedVSLock.new DataAccess();
		String[] action1 = { "putwithlock", "getwithlock", "putwithsynchronized", "getwithsynchronized" };
		String[] action2 = { "putwithsynchronized", "getwithsynchronized" };
		Thread t1 = new Thread(synchronizedVSLock.new MyRunnable(action1, data));
		t1.setName("t1");
		t1.start();

		Thread t2 = new Thread(synchronizedVSLock.new MyRunnable(action1, data));
		t2.setName("t2");
		t2.start();
		t1.interrupt();
	}

	class MyRunnable implements Runnable {
		String[] actions;
		DataAccess data;

		public MyRunnable(String[] actions, DataAccess data) {
			this.actions = actions;
			this.data = data;
		}

		@Override
		public void run() {
			int i = 0;
			do {
				jforloop: for (int j = 0; j < actions.length; j++) {
					switch (actions[j]) {
					case "getwithlock": {
						System.out.println("calling getwithlock -" + Thread.currentThread().getName() + "-"
								+ data.getwithLock("name"));
						break;
					}
					case "putwithlock": {
						System.out.println("calling putwithlock -" + Thread.currentThread().getName() + "-"
								+ data.putwithLock("name", "Mani"));
						break;
					}
					case "getwithsynchronized": {
						System.out.println("calling getwithsynchronized -" + Thread.currentThread().getName() + "-"
								+ data.getwithSynchronized("name"));
						break;
					}
					case "putwithsynchronized": {
						System.out.println("calling putwithsynchronized -" + Thread.currentThread().getName() + "-"
								+ data.putwithSynchronized("name", "Mani"));
						break;
					}
					default: {
						break jforloop;
					}
					}
				}
				i++;
			} while (i <= 5);
		}

	}

	class DataAccess {
		private Map<String, String> data = new HashMap();
		ReentrantLock lock = new ReentrantLock(true);
		Object obj1 = new Object();
		Object obj2 = new Object();

		private String getwithSynchronized(String key) {
			try {
				synchronized (obj2) {
					Thread.sleep(3000);
					return data.get(key);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		private String getwithLock(String key) {
			try {
				lock.tryLock(5, TimeUnit.SECONDS);
				Thread.sleep(10000);
  				return data.get(key);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();

			}
			return null;
		}

		private String putwithSynchronized(String key, String value) {
			try {
				synchronized (obj1) {
					Thread.sleep(5000);
					return data.put(key, value);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		private String putwithLock(String key, String value) {
			try {
				lock.lockInterruptibly();
				lock.lock();
				return data.put(key, value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				for (;;) {
					if (lock.isHeldByCurrentThread())
						lock.unlock();
					else
						break;
				}

			}
			return null;
		}
	}

}
