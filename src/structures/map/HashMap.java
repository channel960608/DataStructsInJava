package structures.map;

import exception.illegalArgumentException;


public class HashMap<V, K> {

    static final int MAXIMUM_CAPACITY = 500;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    final float loadFactor; //加载因子

    int threshold; //临界值

    transient Entry[] table;

    transient int size;

    transient int modCount; //被修改次数



    public HashMap(int initialCapacity, float loadFactor) {
        if(initialCapacity < 0) {
            throw new illegalArgumentException("illegal initial capacity: " +
                                                initialCapacity);
        }

        if(initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if(loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new illegalArgumentException("illegal load factor: " +
                                                loadFactor);
        }

        int capacity = 1;
        while(capacity < initialCapacity) {
            capacity <<= 1; //位操作，乘以2 确保容量为大于初始化容量的最小二次幂
        }

        this.loadFactor = loadFactor;
        threshold = (int)(capacity * loadFactor);
        table = new Entry[capacity];
       init();


    }

    private void init() {
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
       init();
    }


    public V put(K key, V value) {

        if(key == null) {
            return putForNullKey(value);
        }

        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for(Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if(e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }

        }
        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }

    private void addEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        if(size++ >= threshold) {
            resize(2 * table.length);
        }
    }

    private V putForNullKey(V value) {
        for(Entry<K, V> e = table[0]; e != null; e = e.next) {
            if(e.key == null) {
                V oldValue = e.value;
                e.recordAccess(this);
                return oldValue;

            }
        }

        modCount++;
        addEntry(0, null, value, 0);

        return null;
    }


    public V get(Object key) {
        if(key == null) {
            return getForNullKey();
        }
        int hash = hash(key.hashCode());
        for(Entry<K,V> e = table[indexFor(hash, table.length)]; e != null; e=e.next) {
            Object k = e.key;
            if (e.hash == hash && (k == key) || key.equals(k)) {
                return e.value;
            }
        }
        return null;
    }







// 在进行散列计算时，为了保证元素在哈希表中散列的比较均匀，HashTable使用了hash值对length取模，但取模用到了除法运算，效率会比较低。
// 在HashMap的实现时，改进了HashTable的算法，使用位运算来进行散列值计算，提高了效率，同时能够保证元素在散列表中分布均匀
// 在这里，由于我们保证容量是2的次幂，因此这个位运算就相当于取模运算
    static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    static int hash(int hash) {
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        return  hash ^ (hash >>> 7) ^ (hash >>> 4);
    }


    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapcity = oldTable.length;
        if(oldCapcity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    private void transfer(Entry[] newTable) {
        for(int i = 0; i < table.length; i++) {
            newTable[i] = table[i];
        }
    }

    public V getForNullKey() {
        return null;
    }


}

