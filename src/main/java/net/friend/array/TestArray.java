package net.friend.array;

import java.util.Arrays;
import java.util.Random;

public class TestArray {

  public static void main(String args[]) {
//        singleDimensional();
//        singleDimensionalCombine();
//        multidimensional();
    sort();
  }

  private static void singleDimensional() {
    int a[] = new int[5];//declaration and instantiation
    a[0] = 10;//initialization
    a[1] = 20;
    a[2] = 70;
    a[3] = 40;
    a[4] = 50;

    //printing array
    for (int i = 0; i < a.length; i++)//length is the property of array
    {
      System.out.println(a[i]);
    }
  }

  private static void singleDimensionalCombine() {
    int a[] = {33, 3, 4, 5};//declaration, instantiation and initialization

    //printing array
    for (int i = 0; i < a.length; i++)//length is the property of array
    {
      System.out.println(a[i]);
    }
  }

  private static void multidimensional() {
    //declaring and initializing 2D array
    int arr[][] = {{1, 2, 3}, {2, 4, 5}, {4, 4, 5}};

    //printing 2D array
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void sort() {
    int[] array = new int[10];
    Random rand = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = rand.nextInt(100) + 1;
    }
    Arrays.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
