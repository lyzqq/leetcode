package dataStructure.d4HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;


/**
 * @Author Lyz
 * @Date: 2022/4/23 8:57
 * @Version 1.0
 * 模拟哈希表
 */
public class MyHashMap<K, V> implements MyMap<K,V> {

    // 默认容量
    private final int DEFAULT_CAPACITY = 16;

    // 内部存储结构
    Node<K, V>[] table = new Node[DEFAULT_CAPACITY];
    // 长度
    private int size = 0;

    // keySet
    Set<K> keySet;


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Node<K, V>[] tab;
        V v;
        if ((tab = table) != null && size > 0) {
            for (int i = 0; i < tab.length; ++i) {
                for (Node<K, V> e = tab[i]; e != null; e = e.next) {
                    if ((v = e.value) == value || (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);
        for (Node<K, V> node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        // 通过key求哈希值
        int hashValue = hash(key);
        // 通过hash，找到这个key应该放的位置
        int i = indexFor(hashValue, table.length);
        // i位置已经有数据了，在链表添加元素
        for (Node<K, V> node = table[i]; node != null; node = node.next) {
            K k;
            // 如果数组中有这个key，则覆盖其value
            if (node.hash == hashValue && ((k = node.key) == key || key.equals(k))) {
                V OldValue = node.value;
                node.value = value;
                // 返回OldValue
                return OldValue;
            }
        }
        // 如果i位置没有数据，或i位置有数据，但key是新的key，新增节点
        addEntry(key, value, hashValue, i);
        return null;
    }


    private void addEntry(K key, V value, int hashValue, int i) {
        // 如果超过了原数组大小，则扩大数组
        if (++size == table.length) {
            Node<K, V>[] newTable = new Node[table.length * 2];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        }
        // 得到i位置的数据
        Node<K,V> eNode = table[i];
        // 新增节点，将该节点的next指向前一个节点
        table[i] = new Node<K, V>(hashValue, key, value, eNode);
    }

    // 获取哈希值
    private int hash(Object key) {
        return key.hashCode();
    }


    // 获取插入的位置
    private int indexFor(int hashValue, int length) {
        return hashValue % length;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(table);
    }

    // 静态内部类，Node 节点实现Entry接口
    static class Node<K, V> implements Entry<K, V> {

        final int hash; // 哈希值
        final K key; // key
        V value; // value
        Node<K, V> next; // 指向下一个节点(单例表)

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
