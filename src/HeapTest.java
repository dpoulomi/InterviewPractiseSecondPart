import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

public class HeapTest {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        int[] arr = {5, 3, 4, 1, 2, 10, 12,13};

        for(int i = 0; i < arr.length; ++i) {
            heap.add(arr[i]);
        }

        heap.getMinHeap().stream().forEach(elem -> System.out.print(elem + ", "));
        System.out.println();
        System.out.println("after delete");
        heap.delete();
        heap.getMinHeap().stream().forEach(elem -> System.out.print(elem + ", "));
    }
}
