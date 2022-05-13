package simple;

import java.util.Iterator;

public class Main {
	public void longestCommonPrefix() {
//		String[] strs = {"flower","flow","flight"};

		String[] strs = { "dog", "racecar", "car" };
		Solution solution = new Solution();
		String reString = solution.longestCommonPrefix(strs);
		System.out.println(reString);
	}

	public void numberOfLinesTest() {
		int[] widths = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10 };
		String s = "abcdefghijklmnopqrstuvwxyz";

//		int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
//		String s = "bbbcccdddaaa";

		Solution solution = new Solution();
		int[] res = solution.numberOfLines(widths, s);
		for (int num : res) {
			System.out.println(num);
		}
	}

	public void rotateStringTest() {
		Solution solution = new Solution();
		String s = "abcde";
		String goal = "abced";
		boolean b = solution.rotateString(s, goal);
		System.out.println(b);
	}

	public void divideTest() {
		Solution solution = new Solution();
		int divide = solution.divideAns(17, 2);
		System.out.println(divide);
	}

	public void addBinary() {
		Solution solution = new Solution();
//		String addBinaryNew = solution.addBinaryNew("11", "1");
		String res = solution.addBinaryBitWise("11","10");
		System.out.println(res);

	}

	public void maximumWealth() {
		Solution solution = new Solution();
		int[][] account = { { 1, 2, 3 }, { 3, 2, 1 } };
		int maximumWealth = solution.maximumWealth(account);
		System.out.println(maximumWealth);

	}

	public void countBits() {
		Solution solution = new Solution();
		int[] arry = solution.countBits(5);
		for (int count : arry)
			System.out.println(count);
	}

	public static void main(String[] args) {
		Main main = new Main();
//		main.longestCommonPrefix();
//		main.numberOfLinesTest();
//		main.rotateStringTest();
//		main.divideTest();

		main.addBinary();

//		main.maximumWealth();

//		main.countBits();
		
//		System.out.println(6>>3);

	}
}
