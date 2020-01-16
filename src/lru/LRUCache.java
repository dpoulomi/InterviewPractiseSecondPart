package lru;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache {

    private Map<String, LRUCacheElement> lruIndexMap = new HashMap();

    LRUCacheElement rootHead;

    LRUCacheElement tail;

    private static int CACHE_SIZE = 3;

    public Optional<String> read(String key) {
        if(lruIndexMap.containsKey(key)) {
            final LRUCacheElement lruCacheElement = lruIndexMap.get(key);
            removeCacheElement(lruCacheElement);
            putCacheElementInFirstPosition(lruCacheElement);
            return Optional.of(lruCacheElement.value);
        }
        return Optional.empty();
    }

    private void putCacheElementInFirstPosition(LRUCacheElement lruCacheElement) {
        LRUCacheElement head =  rootHead;

//        while(head != null){
//          head = head.prev;
//
//        }
        lruCacheElement.next = head;
        lruCacheElement.prev = null;
        head.prev = lruCacheElement;
        rootHead = lruCacheElement;


    }

    private void removeCacheElement(LRUCacheElement lruCacheElement) {
        LRUCacheElement previous = lruCacheElement.prev;
        LRUCacheElement next = lruCacheElement.next;
        if(previous != null) {
            previous.next = next;
        }
        if(next != null) {
            next.prev = previous;
        }

    }

    public void write(String key, String value) {

        if(!lruIndexMap.containsKey(key)){
            if(lruIndexMap.size() == CACHE_SIZE){
                removeLastCacheElement();
            }
            LRUCacheElement lruCacheElement = createLruCacheNode(key , value);
            putCacheElementInFirstPosition(lruCacheElement);
            lruIndexMap.put(key , lruCacheElement);

        }else{
            LRUCacheElement lruCacheElement = lruIndexMap.get(key);
            removeCacheElement(lruCacheElement);
            putCacheElementInFirstPosition(lruCacheElement);
        }

    }

    private LRUCacheElement createLruCacheNode(String key, String value) {
        LRUCacheElement lruCacheElement = new LRUCacheElement(value);

        return lruCacheElement;

    }

    private void removeLastCacheElement() {
        LRUCacheElement keyToRemove = tail;
        LRUCacheElement prev= keyToRemove.prev;
        prev.next = null;
        tail = prev;
    }



    class LRUCacheElement {

        String value;
        LRUCacheElement next;
        LRUCacheElement prev;

        public LRUCacheElement(String value){
            this.value = value;
        }

    }
}
