package net.friend.list;

import static net.friend.util.StorageUtil.bytesToMegabytes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.friend.common.Student;
import net.friend.util.SystemInfoUtil;

public class TestLinkedList {

  public static void main(String args[]) {
    largeData();
  }

  private static void largeData() {
    List<Student> students = new LinkedList<Student>();

    //init data
    Random rand = new Random();
    for (int i = 0; i < 1000000; i++) {
      int age = rand.nextInt();
      Student student = new Student(i, "Student " + i, age);
      students.add(student);
    }

    //memory
    System.out.println("Memory: " + bytesToMegabytes(SystemInfoUtil.getUsedMem()) + "MB/" +
        bytesToMegabytes(SystemInfoUtil.getTotalMem()) + "MB");

    //read
    long readStartTime = System.currentTimeMillis();
    for (Student student : students) {
      //getName
      String name = student.getName();
    }
    long readEndTime = System.currentTimeMillis();
    System.out.println("Read time: " + (readEndTime - readStartTime) + "ms");

    //manipulate
    long removeStartTime = System.currentTimeMillis();
    Iterator iterator = students.iterator();
    while (iterator.hasNext()) {
      Student student = (Student) iterator.next();
      if (student.getRollno() % 10 == 1) {
        iterator.remove();
      }
    }
    long removeEndTime = System.currentTimeMillis();
    System.out.println("Remove time: " + (removeEndTime - removeStartTime) + " ms");
  }
}
