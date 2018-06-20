package net.friend.list;

import net.friend.common.Student;
import net.friend.util.SystemInfoUtil;

import java.util.*;

import static net.friend.util.StorageUtil.bytesToKilobytes;
import static net.friend.util.StorageUtil.bytesToMegabytes;

public class TestLinkedList {

    public static void main(String args[]){
        largeData();
    }

    private static void largeData(){
        List<Student> students=new LinkedList<Student>();

        Random rand = new Random();
        for(int i=0; i<1000000; i++){
            int age = rand.nextInt();
            Student student = new Student(i, "Student " + i, age);
            students.add(student);
        }

        System.out.println("Memory: " + bytesToMegabytes(SystemInfoUtil.getUsedMem()) + " / " +
                bytesToMegabytes(SystemInfoUtil.getTotalMem()));

        long readStartTime = System.currentTimeMillis();
        for(Student student: students){
            //getName
            String name = student.getName();
        }
        long readEndTime = System.currentTimeMillis();
        System.out.println("Read time: " + (readEndTime - readStartTime));

        long removeStartTime = System.currentTimeMillis();
        Iterator iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = (Student)iterator.next();
            if(student.getRollno() % 10 == 1){
                iterator.remove();
            }
        }
        long removeEndTime = System.currentTimeMillis();
        System.out.println("Remove time: " + (removeEndTime - removeStartTime));
    }
}
