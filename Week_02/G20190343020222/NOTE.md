学习笔记
1. HashMap
In javascript, it's Map.
-add: map.set(key, value)
-delete: map.delete(key)
-iterate:
    for (let [key, value] of map.entries()) {
        ....
    }

-let array = [...map];
    will get [[key1, value1], [key2, value2]...]
-compare with object, Map allows multiple keys as object
2. HashSet
In javascript, it's Set.
-add: set.add(val)
-delete: set.delete(val)
-empty: set.clear()
-size: set.size()
-initialization: new Set([1, 2, 3])
-iterate:
    for (let val of set) {
        ...
    }
-Remove duplicates:
    const array = [1, 2, 2, 3];
    (1) Array.from(new Set(array));
    (2) [...new Set(array)];
    will return [1, 2, 3]
3. Tree traversal
Pre-order
In-order
Post-order