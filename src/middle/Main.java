package middle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public void countNumbersWithUniqueDitistsTest() {
		Solution solution = new Solution();
//		int count = solution.countNumbersWithUniqueDigits(2);
		int count = solution.countNumbersWithUniqueDigists2(3);
		System.out.println(count);
	}
	
	public void uniqueMorseRepresentationsTest() {
		Solution solution = new Solution();
		String[] words = {"gin", "zen", "gig", "msg"};
		int res = solution.uniqueMorseRepresentations(words);
		System.out.println(res);
	}
	
	public void levelOrder() {
		Solution soluion = new Solution();
		new Node(5,null);new Node(6,null); 
		List<Node> children1 = new ArrayList<Node>();
		children1.add(new Node(5, null));
		children1.add(new Node(6, null));
		List<Node> children2 = new ArrayList<Node>();
		children2.add(new Node(3,children1));
		children2.add(new Node(2, null));
		children2.add(new Node(4, null));
		Node rootNode = new Node(1,children2);
		
		List<List<Integer>> list = soluion.levelOrder(rootNode);
		for(List<Integer> tempList: list) {
			for(Integer val: tempList) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
//		main.uniqueMorseRepresentationsTest();
		main.levelOrder();
	}
}
