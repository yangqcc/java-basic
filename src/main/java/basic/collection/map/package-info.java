package basic.collection.map;

/**
 * LinkedHashMap实现LRU是需要基础LinkedHashMap,然后重写removeEldestEntry
 *
 * void addEntry(int hash, K key, V value, int bucketIndex) {
 * <p>
 * super.addEntry(hash, key, value, bucketIndex);
 * <p>
 * <p>
 * <p>
 * // Remove eldest entry if instructed
 * <p>
 * Entry<K,V> eldest = header.after;
 * <p>
 * if (removeEldestEntry(eldest)) {
 * <p>
 * removeEntryForKey(eldest.key);
 * <p>
 * }
 * <p>
 * }
 * <p>
 * 在增加Entry的时候，通过removeEldestEntry(eldest)判断是否需要删除最老的Entry，如果需要则remove。
 * 注意看这里Entry<K,V> eldest=header.after，记得我们前面提过LinkedHashMap还维护一个双向链表，这里的header.after就是链表尾部最后一个元素(头部元素是head.before)。
 * <p>
 * LinkedHashMap默认的removeEldestEntry方法如下
 * <p>
 * protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
 * <p>
 * return false;
 * <p>
 * }
 * <p>
 * 总是返回false，所以开发者需要实现LRU算法只需要继承LinkedHashMap并重写removeEldestEntry方法，下面以MyBatis的LRU算法的实现举例
 * <p>
 * keyMap = new LinkedHashMap<Object, Object>(size, .75F, true) {
 * <p>
 * private static final long serialVersionUID = 4267176411845948333L;
 * <p>
 * <p>
 * <p>
 * protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
 * <p>
 * boolean tooBig = size() > size;
 * <p>
 * if (tooBig) {
 * <p>
 * eldestKey = eldest.getKey();
 * <p>
 * }
 * <p>
 * return tooBig;
 * <p>
 * }
 * <p>
 * };
 */