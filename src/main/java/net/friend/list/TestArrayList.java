package net.friend.list;

import net.friend.common.Student;
import net.friend.util.SystemInfoUtil;
import net.sourceforge.sizeof.SizeOf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static net.friend.util.StorageUtil.bytesToMegabytes;

public class TestArrayList {

    public static void main(String args[]) throws Exception{
//        iterateByIterator();
//        iterateByForEachLoop();
//        userDefinedClassObject();

        largeData();
    }

    private static void iterateByIterator(){
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        //Traversing list through Iterator
        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    private static void iterateByForEachLoop(){
        ArrayList<String> al=new ArrayList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");
        for(String obj:al)
            System.out.println(obj);
    }

    private static void userDefinedClassObject(){
        //Creating user-defined class objects
        Student s1=new Student(101,"Sonoo",23);
        Student s2=new Student(102,"Ravi",21);
        Student s3=new Student(103,"Hanumat",25);
        Student s0=new Student(101,"Sonoo",23);

        //creating arraylist
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(s1);//adding Student class object
        al.add(s2);
        al.add(s3);
        al.add(s0);

        //Getting Iterator
        Iterator itr=al.iterator();

        //traversing elements of ArrayList object
        while(itr.hasNext()){
            Student st=(Student)itr.next();
            System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
        }
    }

    private static void largeData() throws Exception{
        List<Student> students=new ArrayList<Student>();

        Random rand = new Random();
        for(int i=0; i<1000000; i++){
            int age = rand.nextInt();
            Student student = new Student(i, "Student " + i, age);
            students.add(student);
        }

        //configuration steps
//        SizeOf.setMinSizeToLog(10);
//        System.out.println("Size Of: " + SizeOf.humanReadable(SizeOf.deepSizeOf(students)));
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
