package basic.collection.testMap;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author yangqc
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {

  private List<K> keys = new ArrayList<>();
  private List<V> values = new ArrayList<>();

  @Override
  public V put(K key, V value) {
    V oldValue = get(key);
    if (!keys.contains(key)) {
      keys.add(key);
      values.add(value);
    } else {
      values.set(keys.indexOf(key), value);
    }
    return oldValue;
  }

  @Override
  public V get(Object key) {
    if (!keys.contains(key)) {
      return null;
    }
    return values.get(keys.indexOf(key));
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    Set<Entry<K, V>> set = new HashSet<>();
    Iterator<K> ki = keys.iterator();
    Iterator<V> vi = values.iterator();
    while (ki.hasNext()) {
      set.add(new MapEntry<>(ki.next(), vi.next()));
    }
    return set;
  }

}
