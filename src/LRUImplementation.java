//import java.util.*;
//
//public class LRUImplementation {
//
//  //  Queue<Integer> queue = new LinkedList<Integer>();
//
//    Set<Integer> map = new HashSet<>();
//
//
//    public void findPageFaults(int input , int cacheSize){
//
//        if(!map.contains(input)){
//            if (queue.size() == cacheSize) {
//                int last = queue.remove();
//                map.remove(last);
//            }
//        } else {
//            int index = 0, i = 0;
//            Iterator<Integer> itr = queue.iterator();
//            while (itr.hasNext()) {
//                if (itr.next() == input) {
//                    index = i;
//                    break;
//                }
//                i++;
//            }
//            queue.remove(index);
//        }
//            queue.add(input);
//            map.add(input);
//    }
//
//
//    class LRUCacheElement {
//
//        String value;
//        LRUCacheElement next;
//        LRUCacheElement prev;
//
//    }
//
//}
