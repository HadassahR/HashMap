import java.sql.Array;
import java.util.*;

public class OurHashMap<K,V> implements Map<K,V> {

    private final int SIZE = 16;

    class Entry<K,V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Entry> values[] = new List[SIZE];

    @Override
    public int size() {
        long num = Arrays.stream(values).filter(Objects::nonNull).count();
        return (int) num;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {

        return false;
    }

    @Override
    public V get(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if (list == null) {
            return null;
        }
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        if (list == null) {
            list = new ArrayList<Entry>();
            values[index] = list;
        }

        for (Entry<K,V> entry : (List<Entry<K,V>>) list) {
            if (entry.key.equals(key)) {
                V saved = entry.value;
                entry.value = value;
                return saved;
            }
        }

        Entry entry = new Entry(key,value);
        list.add(entry);

        return null;
    }

    @Override
    public V remove(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> value = values[index];
        for (Entry e : value) {
            if (e.key == key){
                value.remove(e);
                return (V) e.value;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {
        values = new List[SIZE];
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<java.util.Map.Entry<K,V>> entrySet() {
        return null;
    }
}
