package algo.tryout.matrix;

public class MatrixLayerRotation {

	public static void main(String[] args) {
		// int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11,
		// 12 }, { 13, 14, 15, 16 },
		// { 17, 18, 19, 20 } };

		int[][] sortedMatrix = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 9, 10, 11, 12, 13, 14, 15, 16 },
				{ 17, 18, 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30, 31, 32 },
				{ 33, 34, 35, 36, 37, 38, 39, 40 }, { 41, 42, 43, 44, 45, 46, 47, 48 },
				{ 49, 50, 51, 52, 53, 54, 55, 56 }, { 57, 58, 59, 60, 61, 62, 63, 64 },
				{ 65, 66, 67, 68, 69, 70, 71, 72 }, { 73, 74, 75, 76, 77, 78, 79, 80 } };

		// int[][] sortedMatrix = matrix.clone();
		int r = 40, len = 8, heg = 10;

		// approach1(sortedMatrix, r, heg, len);
		// approach2(sortedMatrix, r, heg, len);
		approach3(sortedMatrix, r, heg, len);
		for (int i = 0; i < sortedMatrix.length; i++) {
			for (int d : sortedMatrix[i]) {
				System.out.print(d + " ");
			}
			System.out.println();
		}
	}

	private static void approach3(int[][] sortedMatrix, int r, int aheg, int alen) {
		int[][] newSortedMatrix = new int[aheg][alen];
		int len = 0, heg = 0, loopCount = Math.min((aheg / 2), alen / 2);
		len = alen - 1;
		heg = aheg - 1;
		int lIcursor = 0, lJcursor = 0, rIcursor = 0, rJcursor = 0, bIcursor = 0, bJcursor = 0, tIcursor = 0,
				tJcursor = 0, roundTrip;
		int lNewPosition, ljNewPosition, rNewPosition, rjNewPosition, bNewPosition, biNewPosition, tNewPosition,
				tiNewPosition;
		for (int i = 0; i < (loopCount); i++) {
			roundTrip = ((((heg - (i)) * 2)) + (((len - (i)) * 2)));
			lIcursor = i;
			lJcursor = i;
			ljNewPosition = i;
			rIcursor = heg;
			rJcursor = len;
			rjNewPosition = len;
			bIcursor = i;
			bJcursor = len;
			biNewPosition = i;
			tIcursor = i;
			tJcursor = i;
			int newPosition = (r % roundTrip);
			while (lIcursor < heg) {
				lNewPosition = newPosition + lIcursor;
				if (lNewPosition > heg) {
					ljNewPosition = lNewPosition - heg;
					lNewPosition = heg;
				}
				if (ljNewPosition > len) {
					lNewPosition = lNewPosition - ((ljNewPosition + i) - len);
					ljNewPosition = len;
				}
				newSortedMatrix[lNewPosition][ljNewPosition] = sortedMatrix[lIcursor][lJcursor];

				rNewPosition = rIcursor - newPosition;
				
				if(rNewPosition>rIcursor) {
					rIcursor=i;
				}
				if (rNewPosition < i) {
					rjNewPosition=rNewPosition+len;
					rNewPosition = i;
				}
				if(rjNewPosition>len) {
					rNewPosition=rNewPosition + ((rNewPosition - i) - heg);
				}
				newSortedMatrix[rNewPosition][rjNewPosition] = sortedMatrix[rIcursor][rJcursor];
				lIcursor++;
				rIcursor--;
			}
			bIcursor = lIcursor;
			biNewPosition = bIcursor;
			bJcursor = lJcursor;
			tIcursor = rIcursor;
			tiNewPosition = tIcursor;
			tJcursor = rJcursor;
			while (bJcursor < len) {
				bNewPosition = newPosition + bJcursor;
				if (bNewPosition > len) {
					biNewPosition--;
					bNewPosition = len;
				}
				newSortedMatrix[biNewPosition][bNewPosition] = sortedMatrix[bIcursor][bJcursor];
				tNewPosition = tJcursor - newPosition;
				if (tNewPosition < i) {
					tiNewPosition++;
					tNewPosition = i;
				}
				newSortedMatrix[tiNewPosition][tNewPosition] = sortedMatrix[tIcursor][tJcursor];
				bJcursor++;
				tJcursor--;
			}

			// reduce height
			heg--;
			len--;
		}
		for (int i = 0; i < newSortedMatrix.length; i++) {
			for (int d : newSortedMatrix[i]) {
				System.out.print(d + " ");
			}
			System.out.println();
		}

	}

	private static void approach2(int[][] sortedMatrix, int r, int aheg, int alen) {
		int swap = -1, lswap = -1, rswap = -1, bswap = -1, tswap = -1, len = 0, heg = 0,
				loopCount = Math.min((aheg / 2), alen / 2);
		for (int l = 1; l <= r; l++) {
			len = alen - 1;
			heg = aheg - 1;
			// nLen = -1;
			// nHeg = -1;
			int lIcursor = 0, lJcursor = 0, rIcursor = 0, rJcursor = 0, bIcursor = 0, bJcursor = 0, tIcursor = 0,
					tJcursor = 0;
			for (int i = 0; i < (loopCount); i++) {
				lIcursor = i;
				lJcursor = i;
				rIcursor = heg;
				rJcursor = len;
				bIcursor = i;
				bJcursor = len;
				tIcursor = i;
				tJcursor = i;
				// move top to bottom & bottom to up;
				while (lIcursor <= heg) {
					// if(icursor+1>heg)break;
					// swap=sortedMatrix[icursor][jcursor];
					swap = sortedMatrix[lIcursor][lJcursor];
					sortedMatrix[lIcursor++][lJcursor] = lswap;
					lswap = swap;

					swap = sortedMatrix[rIcursor][rJcursor];
					sortedMatrix[rIcursor--][rJcursor] = rswap;
					rswap = swap;

				}
				bswap = lswap;
				tswap = rswap;
				bIcursor = lIcursor - 1;
				bJcursor = lJcursor + 1;
				tIcursor = rIcursor + 1;
				tJcursor = rJcursor - 1;
				while (bJcursor <= len) {
					// if(jcursor+1>=len)break;
					swap = sortedMatrix[bIcursor][bJcursor];
					sortedMatrix[bIcursor][bJcursor++] = bswap;
					bswap = swap;

					swap = sortedMatrix[tIcursor][tJcursor];
					sortedMatrix[tIcursor][tJcursor--] = tswap;
					tswap = swap;
				}

				// reduce height
				heg--;
				len--;
			}
		}
	}

	private static void approach1(int[][] sortedMatrix, int r, int aheg, int alen) {
		int swap = -1, tswap = -1, len = 0, heg = 0, loopCount = Math.min((aheg / 2), alen / 2), nLen = 0, nHeg = 0;
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
	}
}
