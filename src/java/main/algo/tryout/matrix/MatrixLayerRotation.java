package algo.tryout.matrix;

public class MatrixLayerRotation {

	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3,4},{7,8,9,10},{13,14,15,16},{19,20,21,22},{25,26,27,28}};
		/*int[][] matrix = new int[][] { { 9718805, 60013003, 5103628, 85388216, 21884498, 38021292, 73470430, 31785927 },
				{ 69999937, 71783860, 10329789, 96382322, 71055337, 30247265, 96087879, 93754371 },
				{ 79943507, 75398396, 38446081, 34699742, 1408833, 51189, 17741775, 53195748 },
				{ 79354991, 26629304, 86523163, 67042516, 54688734, 54630910, 6967117, 90198864 },
				{ 84146680, 27762534, 6331115, 5932542, 29446517, 15654690, 92837327, 91644840 },
				{ 58623600, 69622764, 2218936, 58592832, 49558405, 17112485, 38615864, 32720798 },
				{ 49469904, 5270000, 32589026, 56425665, 23544383, 90502426, 63729346, 35319547 },
				{ 20888810, 97945481, 85669747, 88915819, 96642353, 42430633, 47265349, 89653362 },
				{ 55349226, 10844931, 25289229, 90786953, 22590518, 54702481, 71197978, 50410021 },
				{ 9392211, 31297360, 27353496, 56239301, 7071172, 61983443, 86544343, 43779176 } };*/
		int[][] sortedMatrix = matrix.clone();
		int r =5, swap = -1, tswap = -1, len = 4, heg = 5, nLen = -1, nHeg = -1,
				loopCount = Math.min((heg / 2), len / 2);
		for (int l = 1; l <= r; l++) {
			len = 4;
			heg = 5;
			nLen = -1;
			nHeg = -1;
			int icursor = 0, jcursor = 0;
			for (int i = 0; i < (loopCount); i++) {
				// if(i>=loopCount)break;
				icursor = i;
				jcursor = i;
				// move top to bottom
				for (; icursor < heg;) {
					// if(icursor+1>heg)break;
					// swap=sortedMatrix[icursor][jcursor];
					tswap = sortedMatrix[icursor][jcursor];
					sortedMatrix[icursor++][jcursor] = swap;
					swap = tswap;

				}

				// bottom to right
				icursor--;
				jcursor++;
				for (; jcursor < len;) {
					// if(jcursor+1>=len)break;
					tswap = sortedMatrix[icursor][jcursor];
					sortedMatrix[icursor][jcursor++] = swap;
					swap = tswap;
				}

				// bottom to up
				icursor--;
				jcursor--;
				for (; icursor > nHeg;) {
					// if(icursor-1<=nHeg)break;
					tswap = sortedMatrix[icursor][jcursor];
					sortedMatrix[icursor--][jcursor] = swap;
					swap = tswap;
				}

				// top right to left
				icursor++;
				jcursor--;
				for (; jcursor > nLen;) {
					// if(jcursor-1<=nLen)break;
					tswap = sortedMatrix[icursor][jcursor];
					sortedMatrix[icursor][jcursor--] = swap;
					swap = tswap;
				}
				// reduce height
				heg--;
				nHeg++;
				len--;
				nLen++;
			}

		}
		for (int i = 0; i < sortedMatrix.length; i++) {
			for (int d : sortedMatrix[i]) {
				System.out.print(d + " ");
			}
			System.out.println();
		}
	}
}
