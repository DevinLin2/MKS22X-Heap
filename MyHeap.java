public class MyHeap {
  private static void pushDown(int[]data, int size, int index) {
    int max = -1;
    int newIndex = 0;
    if (size >= 0 && size <= data.length - 1 && index >= 0 && index <= size - 1) {
      if (index * 2 + 1 <= size - 1) {
        max = data[index * 2 + 1];
        newIndex = index * 2 + 1;
      }
      if (index * 2 + 2 <= size - 1 && data[index * 2 + 1] > max) {
        newIndex = index * 2 + 2;
      }
    }
    // recursive call here
  }
  private static void pushUp(int[]data,int index) {

  }
  public static void heapify(int[]) {

  }
  public static void heapsort(int[]) {

  }
}
