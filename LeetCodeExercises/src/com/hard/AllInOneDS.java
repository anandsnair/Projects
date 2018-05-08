package com.hard;

import java.util.HashMap;
import java.util.Map;

/*Implement a data structure supporting the following operations:

 Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 Dec(Key) - Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. Key is guaranteed to be a non-empty string.
 GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 Challenge: Perform all these in O(1) time complexity.

 */
public class AllInOneDS {

	private Map<String, Integer> mapOfKeyValue = new HashMap<String, Integer>();
	String maxKey;
	String minKey;

	/** Initialize your data structure here. */
	public AllInOneDS() {

	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {
		if (mapOfKeyValue.containsKey(key)) {
			Integer value = mapOfKeyValue.get(key) + 1;
			mapOfKeyValue.put(key, value);
		} else {
			mapOfKeyValue.put(key, 1);
		}
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {
		if (mapOfKeyValue.containsKey(key)) {
			if (mapOfKeyValue.get(key) == 1)
				mapOfKeyValue.remove(key);
			else
				mapOfKeyValue.put(key, mapOfKeyValue.get(key) - 1);
		} else {
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if (mapOfKeyValue.isEmpty())
			return "";
		return maxKey;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if (mapOfKeyValue.isEmpty())
			return "";
		return minKey;
	}
}
