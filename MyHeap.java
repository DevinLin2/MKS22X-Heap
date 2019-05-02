import java.util.*;

public class MyHeap {
  public static void main(String[] args) {
    int[] data = new int[]{10, 23, 254, 323, 45, 23, 4};
    System.out.println(Arrays.toString(data));
    heapify(data);
    System.out.println(Arrays.toString(data));
  }
  private static void pushDown(int[] data, int size, int index) {
    int newIndex = -1;
    int oldData = data[index];
    if (size - 1 >= 0 && size - 1 <= data.length - 1 && index >= 0 && index <= size - 1) {
      if (index * 2 + 1 <= size - 1 && data[index * 2 + 1] > data[index]) { // if the node isnt a leaf
        if (index * 2 + 2 <= size - 1 && data[index * 2 + 2] > data[index * 2 + 1] && data[index * 2 + 2] > data[index]) { // if the parent node has 2 children
          newIndex = index * 2 + 2;
        } else {
          newIndex = index * 2 + 1;
        }
      }
      System.out.println(oldData);
      System.out.println(newIndex);
      if (newIndex != -1) {
        data[index] = data[newIndex];
        data[newIndex] = oldData;
        pushDown(data, size, newIndex);
      }
    }
  }
  private static void pushUp(int[] data, int index) {
    int newIndex = -1;
    int oldData = data[index];
    if (index >= 0 && index <= data.length - 1) {
      if ((index - 1) / 2 >= 0 && data[(index - 1) / 2] < data[index]) {
        newIndex = (index - 1) / 2;
        data[index] = data[newIndex];
        data[newIndex] = oldData;
        pushUp(data, newIndex);
      }
    }
  }
  public static void heapify(int[] data) {
    for (int i = data.length - 1; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }
  // public static void heapsort(int[] data) {
  //   heapify(data);
  //
  // }
}
