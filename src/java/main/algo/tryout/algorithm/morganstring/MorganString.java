package algo.tryout.algorithm.morganstring;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MorganString {

	// Complete the morganAndString function below.
	static String morganAndString(String a, String b) {
		int amaxLen = a.length(), aidx = 0, bmaxLen = b.length(), bidx = 0, maxLen = amaxLen + bmaxLen;
		byte[] output = new byte[maxLen];
		int i = 0;
		while (i <= maxLen) {
			if (aidx < amaxLen) {
				if ((byte) a.charAt(aidx) >= 65 && (byte) a.charAt(aidx) <= 90) {
					if (bidx < bmaxLen) {
						if ((byte) b.charAt(bidx) >= 65 && (byte) b.charAt(bidx) <= 90) {
							if (Byte.compare((byte) a.charAt(aidx), (byte) b.charAt(bidx)) <= 0) {
								addByte(output, i, (byte) a.charAt(aidx));
								aidx++;
								if(aidx==amaxLen) {
									aidx--;
								}
							} else {
								addByte(output, i, (byte) b.charAt(bidx));
								bidx++;
							}
						} else {
							bidx++;
						}
					} else {
						addByte(output, i, (byte) a.charAt(aidx));
						aidx++;
					}
				} else {
					aidx++;
				}

			} else if (bidx < bmaxLen && b.charAt(bidx) >= 65 && (byte) b.charAt(bidx) <= 90) {
				addByte(output, i, (byte) b.charAt(bidx));
				bidx++;
			}
			i++;
		}
		// A==65 Z==90
		return new String(output);

	}

	private static void addByte(byte[] bytearr, int idx, byte value) {
		bytearr[idx] = value;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println(morganAndString("DAD", "DAD"));
	}
}
