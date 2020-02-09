package week007;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/*
运用你所掌握的数据结构，设计和实现一个�? LRU (�?近最少使�?) 缓存机制。它应该支持以下操作�? 获取数据 get �? 写入数据 put �?

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的�?�（总是正数），否则返回 -1�?
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值�?�当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从�?�为新的数据值留出空间�??

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * */
public class Leetcode_146_182 {

	class LRUCache {
		private Map<Integer, Integer> map;

		public LRUCache(int capacity) {
			map = new LinkedCappedHashMap<>(capacity);
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			return map.get(key);
		}

		public void put(int key, int value) {
			map.put(key, value);
		}

		private class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
			int maximumCapacity;

			LinkedCappedHashMap(int maximumCapacity) {
				super(16, 0.75f, true);
				this.maximumCapacity = maximumCapacity;
			}

			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > maximumCapacity;
			}
		}
	}

	@Test
	public void test() {
	}
}
