public class MyHeap {
  private static void pushDown(int[] data, int size, int index) {
    int newIndex = -1;
    int oldData = data[index];
    if (size >= 0 && size <= data.length - 1 && index >= 0 && index <= size - 1) {
      if (index * 2 + 1 <= size - 1 && data[index * 2 + 1] > data[index]) { // if the node isnt a leaf
        if (index * 2 + 2 <= size - 1 && data[index * 2 + 2] > data[index * 2 + 1] && data[index * 2 + 2] > data[index]) { // if the parent node has 2 children
          newIndex = data[index * 2 + 2];
        }
        newIndex = data[index * 2 + 1];
      }
      if (newIndex != -1) {
        data[index] = data[newIndex];
        data[newIndex] = oldData;
        pushDown(data, size, newIndex);
      }
    }
  }
  private static void pushUp(int[]data,int index) {

  }
  public static void heapify(int[]) {

  }
  public static void heapsort(int[]) {

  }
}
