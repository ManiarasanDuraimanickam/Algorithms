package algo.tryout;

public class TestLabel {

	public static void main(String[] args) {
		testLabeledLoopBreak();
		testLabeledLoopContinue();
	}

	private static void testLabeledLoopContinue() {
		outer: for (int i = 0; i <= 10; i++) {
			System.out.println("current value of i=" + i);
			labelX:

			for (int j = 0; j < 10; j++) {
				System.out.println("current value of j=" + j);
				labelY: if (j % 3!=0) {
					continue labelX;
				}
				printLableY();
				printLabelX();

			}
			if (i % 3!=0) {
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

	private static XValue printLabelX() {
		System.out.println("X printed..");
		return new XValue("name");
	}

	private static void printLableY() {
		System.err.println("Y printed..");
	}

	public record XValue(String name) {

	}

}
