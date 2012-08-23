package ch.wurmlo.daai.week5;

import java.util.List;
import java.util.Map;
import com.google.common.collect.Maps;

public class HashTableBasedLookup {

	private Map<Integer, Integer> integerMap;

	public HashTableBasedLookup(List<Integer> integerList) {
		this.integerMap = Maps.newHashMap();
		for(Integer integer : integerList) {
			this.integerMap.put(integer, integer);
		}
	}

	public boolean contains(Integer key) {
		return integerMap.containsKey(key);
	}

	public boolean summandsInMap(Integer sum) {
		for(Integer key : integerMap.keySet()) {
			if(integerMap.containsKey(sum-key)) {
				return true;
			}
		}
		return false;
	}

}
