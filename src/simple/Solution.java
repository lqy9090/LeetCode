package simple;

import java.util.HashMap;
import java.util.Iterator;

public class Solution {

	/**
	 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		String comPre = strs[0];
		for (String str : strs) {
			int cnt = 0;
			for (int i = 0; i < Math.min(comPre.length(), str.length()); i++) {
				if (comPre.charAt(i) == str.charAt(i)) {
					cnt++;
				} else {
					break;
				}
			}

			comPre = comPre.substring(0, cnt);
		}

		return comPre;

	}

	public int[] numberOfLines(int[] widths, String s) {

		int count = 0;
		int totalRow = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int dex = ch - 'a';
			count += widths[dex];
			System.out.println("count: " + count);
			if (count > 100) {
				totalRow++;
				count = widths[dex];
			}
		}
		int lastRow = count;

		int[] resArr = { totalRow + 1, lastRow };
		return resArr;
	}

	public boolean rotateString(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		HashMap<Character, Integer> sMap = new HashMap<>();
		HashMap<Character, Integer> goalMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
			goalMap.put(goal.charAt(i), goalMap.getOrDefault(goal.charAt(i), 0) + 1);
		}

		for (Character key : goalMap.keySet()) {
			if (sMap.get(key) == null || goalMap.get(key) != sMap.get(key)) {
				return false;
			}
		}

		return true;
	}

	/*
	 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。 思路：减法 缺陷： 1.溢出
	 * 2.超出时间限制
	 */
	public int divide(int a, int b) {
		// 边界条件
		if (a == -2147483648) {
			if (b == 1) {
				return a;
			} else if (b == -1) {
				System.out.println("-a: " + -a);
				return 2147483647;
			}
		}

		if (b == -2147483648) {
			if (a == b) {
				return 1;
			} else {
				return 0;
			}
		}

		int aTemp = a;
		int cnt = 0;

		while (Math.abs(a) - Math.abs(b) >= 0) {
			cnt++;
			a = Math.abs(a) - Math.abs(b);
		}

		if (aTemp * b < 0) {
			cnt *= -1;
		}
//	        System.out.println("cnt: "+cnt);
		return cnt;
	}

	// 位运算（快速相减法）
	/*
	 * 作者：chendragon
	 * 
	 */
	public int divideAns(int a, int b) {
		// 特殊情况1, b=1
		if (b == 1) {
			return a;
		}
		// 特殊情况2, b=-1
		if (b == -1) {
			return a == Integer.MIN_VALUE ? Integer.MAX_VALUE : -a;
		}
		// 特殊情况3, a=0
		if (a == 0) {
			return 0;
		}

		// 确定符号
		boolean positive = (a ^ b) >= 0;
		// 为避免溢出, 转换为负数进行计算
		a = a < 0 ? a : -a;
		b = b < 0 ? b : -b;
		// 快速相减
		int quotient = 0;
		while (a <= b) {
			System.out.println("a: " + a + " b: " + b+" quotient: "+quotient);
			int base = 1;
			int divisor = b;
			// 使用减法, 避免溢出
			while (a - divisor <= divisor) {
				System.out.println("divisor: " + divisor + " base: " + base);
				divisor <<= 1;
				base <<= 1;
			}
			quotient += base;
			a -= divisor;
			System.out.println("base: "+base+" quotient: " + quotient);
		}
		return positive ? quotient : -quotient;
	}

	/*
	 * 当字符串长了之后溢出
	 *
	 */
	public String addBinary(String a, String b) {
		int aDec = Integer.parseInt(a, 2);
		int bDec = Integer.parseInt(a, 2);
		int resDec = aDec + bDec;
		System.out.println("aDec: " + aDec + "bDec: " + bDec + "resDec: " + resDec);
		String reString = Integer.toBinaryString(resDec);

		return reString;
	}

	public String addBinaryNew(String a, String b) {
		StringBuffer stringBuffer = new StringBuffer();
		int n = Math.max(a.length(), b.length());
		StringBuffer aBuffer = new StringBuffer(a).reverse();
		StringBuffer bBuffer = new StringBuffer(b).reverse();
		System.out.println("n: " + n);
		int carry = 0;
		for (int i = 0; i < n; i++) {
			int eleA = i > a.length() - 1 ? 0 : aBuffer.charAt(i) - '0';
			int eleB = i > b.length() - 1 ? 0 : bBuffer.charAt(i) - '0';

			int res = eleA ^ eleB ^ carry;
			carry = (eleA + eleB + carry) >= 2 ? (eleA + eleB + carry) / 2 : 0;
			System.out.println("eleA: " + eleA + " eleB: " + eleB + " carry: " + carry + " res: " + res);

			stringBuffer.append(res);
			if (i == n - 1 && carry > 0) {
				stringBuffer.append(carry);
			}
		}



		return stringBuffer.reverse().toString();
	}

	public String addBinaryBitWise(String a, String b) {
		int x = Integer.parseInt(a,2);
		int y = Integer.parseInt(b, 2);
		while (y !=0){

			int answer = x^y;
			int carry = (x & y) << 1;

			x = answer; y = carry;
			System.out.println("x: "+x+" y: "+y);
		}

		return Integer.toBinaryString(x);
	}

	/**
	 * 1672. 最富有客户的资产总量 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第
	 * i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
	 * 
	 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/richest-customer-wealth
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public int maximumWealth(int[][] accounts) {
		int maxValue = Integer.MIN_VALUE;
		int m = accounts.length;
		int n = accounts[0].length;
		for (int i = 0; i < m; i++) {
			int value = 0;
			for (int j = 0; j < n; j++) {
				value += accounts[i][j];
			}
			maxValue = Math.max(maxValue, value);
		}
		return maxValue;
	}

	public int[] countBits(int n) {

		int[] resArr = new int[n + 1];
		/**
		 * for(int i=0; i<=n; i++) { String binaryString = Integer.toBinaryString(i);
		 * int cnt = 0; for(int j=0; j<binaryString.length(); j++) { cnt +=
		 * binaryString.charAt(j)-'0'; } resArr[i] = cnt; } return resArr;
		 */

		/**
		 * 位运算与动态规划
		 */
		for (int num = 0; num <= n; num++) {
			int cnt = 0;
			resArr[num] = resArr[num >> 1] + num & 1;
		}

		return resArr;
	}

	public int[] countBitsNew(int n){
		int[] bits = new int[n+1];
		for (int i=0; i<=n; i++){
			countOnes(i);
		}
		return bits;
	}

	public int countOnes(int x){
		int count = 0;
		while (x>0){
			x &= (x-1);
			count ++;
		}
		return count;
	}
}