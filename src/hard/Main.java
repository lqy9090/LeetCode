package hard;

public class Main {

	public void RandomizedCollectionTest() {
		RandomizedSet obj = new RandomizedSet();
		boolean param_1 = obj.insert(1);
		
		boolean param_2 = obj.remove(2);
		boolean param_4 = obj.insert(2);
		boolean param_5 = obj.insert(2);
		int param_3 = obj.getRandom();
		System.out.println("p1: "+param_1+"p2:"+param_2+"p3:"+param_3);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.RandomizedCollectionTest();
	}
}
