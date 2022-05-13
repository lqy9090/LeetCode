package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedSet {
	Map<Integer, Set<Integer>> recordMap;
	List<Integer> list;
	
	public RandomizedSet() {
		this.recordMap = new HashMap<>();
		this.list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
    	boolean containsKey = recordMap.containsKey(val);
    	
    	list.add(val);
    	Set<Integer> set = recordMap.getOrDefault(val, new HashSet<>());
    	set.add(list.size()-1);
    	recordMap.put(val, set);
    	
    	return !containsKey;
    }
    
    public boolean remove(int val) {
    	if (!recordMap.containsKey(val)) {
			return false;
		}
    	
    	Iterator<Integer> iterator = recordMap.get(val).iterator();
    	Integer i = iterator.next();
    	
    	Integer lastNum = list.get(list.size()-1);
    	
    	list.set(i, lastNum);    	
    	recordMap.get(val).remove(i);
    	recordMap.get(lastNum).remove(list.size()-1);
    	
    	if (i < list.size() - 1) {
            recordMap.get(lastNum).add(i);
        }
        if (recordMap.get(val).size() == 0) {
            recordMap.remove(val);
        }
        list.remove(list.size() - 1);
  
    	return true;
    }
    
    public int getRandom() {
    	System.out.println(Math.random());
    	
    	return list.get((int) (Math.random() * list.size()));
    }
}
