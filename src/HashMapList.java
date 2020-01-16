//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class HashMapList<T , E> {
//
//    private Map<T , ArrayList<E>> map = new HashMap<>();
//
//    public void put(T key , E item){
//        if(!map.containsKey(key)){
//            map.put(key , new ArrayList<E>());
//
//        }
//        map.get(key).add(item);
//    }
//
//    public void put(T key, Arr ayList<E> items) {
//        map. put(key, items);
//    }
/// * Get list of items at key . */
//    public ArrayList<E> get(T key) {
//        ret urn map.get(key) ;
//    }
//    /* Check if hashmaplist contains key. */
//    public boolean containsKey(T key) {
//        ret urn map.containsKey(key);
//    }
/// * Check if list at key contains value. */
//    public boolean containsKeyValue(T key, E value) {
//        ArrayList<E> list = get(key);
//        i f (list == nUll) return false;
//        ret urn list.contains (value);
//    }
/// * Get the list of keys. */
//    public Set<T> keySet() {
//        ret urn map.keySet();
//    }
//    @Override
//    public String toString() {
//        ret urn map.toString();
//    }
//}
