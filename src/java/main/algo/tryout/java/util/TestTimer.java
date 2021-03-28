package algo.tryout.java.util;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	static Timer timer = new Timer();
	
	Object obj=new Object();

	public static void main(String[] args) {
		timerTask();
		
	
	}

	private static void timerTask() {
		TimerTask task = getTimeTask();
		timer.schedule(task, 3000);
	}

	private static TimerTask getTimeTask() {
		TimerTask task = new TimerTask() {
			//
			@Override
			public void run() {
				RunTask s = new RunTask();
				s.run();
			}
		};
		return task;
	}

	private static class RunTask {
		void run() {
			try {
				System.out.println("task running...");
			} finally {
				reSchedule(5000);
			}
		}

		//
		private void reSchedule(int interval) {
			System.out.println("Scheduling...");
			//timer.schedule(getTimeTask(), interval);
			timer.cancel();
		}
	}

}
