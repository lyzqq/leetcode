package dataStructure.d4HashMap;

/**
 * @param <K>
 * @param <V> 自己实现的map接口
 */
public interface MyMap<K, V> {
    // 大小
    int size();

    // 是否为空
    boolean isEmpty();

    // 是否包含key
    boolean containsKey(Object key);

    // 是否包含value
    boolean containsValue(Object value);

    // 根据key获取元素
    V get(Object key);

    // 添加元素
    V put(K key, V value);

    interface Entry<k, v> {
        k getKey();
        v getValue();
    }
}
