import java.util.*;

public class MyHeap {
  public static void main(String[] args) {
    System.out.println("Size\t\tMax Value\theap/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          MyHeap.heapsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
    // int[] data = new int[]{10, 32, 254, 10, 45, 23, 4};
    // heapsort(data);
    // System.out.println(Arrays.toString(data));
  }
  private static void pushDown(int[] data, int size, int index) {
    int temp = data[index];
    if (index * 2 + 2 < size) { // this checks if data[index] has 2 children
      if (temp < data[index * 2 + 1] && data[index * 2 + 1] > data[index * 2 + 2]) {
        data[index] = data[index * 2 + 1];
        data[index * 2 + 1] = temp;
        temp = data[index * 2 + 1];
        pushDown(data, size, index * 2 + 1);
      } else {
        if (temp < data[index * 2 + 2]) {
          data[index] = data[index * 2 + 2];
          data[index * 2 + 2] = temp;
          temp = data[index * 2 + 2];
          pushDown(data, size, index * 2 + 2);
        }
      }
    } else { // this block runs if data[index] only has one child
      if (index * 2 + 1 < size && temp < data[index * 2 + 1]) {
        data[index] = data[index * 2 + 1];
        data[index * 2 + 1] = temp;
        temp = data[index * 2 + 1];
        pushDown(data, size, index * 2 + 1);
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
  public static void heapsort(int[] data) {
    heapify(data);
    for (int i = 1; i < data.length; i++) {
      int temp = data[0];
      data[0] = data[data.length - i];
      data[data.length - i] = temp;
      pushDown(data, data.length - i, 0);
    }
  }
}
