public class TestMaxHeapImplementation {

    public static void main(String[] args) {
        TestMaxHeapImplementation testMaxHeapImplementation = new TestMaxHeapImplementation();

        MaxHeapImplementation maxHeapImplementation = new MaxHeapImplementation();
        maxHeapImplementation.add(2);
        maxHeapImplementation.add(3);
        maxHeapImplementation.add(4);
        maxHeapImplementation.add(1);
        System.out.print(maxHeapImplementation.peek());
        maxHeapImplementation.delete();
        System.out.print(maxHeapImplementation.peek());
    }
}
