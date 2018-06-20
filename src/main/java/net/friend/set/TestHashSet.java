package net.friend.set;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {

  public static void main(String[] args) {
    simple();
  }

  private static void simple(){
    //Creating HashSet and adding elements
    HashSet<String> set=new HashSet<String>();
    set.add("Ravi");
    set.add("Vijay");
    set.add("Ravi");
    set.add("Ajay");

    //Traversing elements
    Iterator<String> itr=set.iterator();
    while(itr.hasNext()){
      System.out.println(itr.next());
    }
  }
}
