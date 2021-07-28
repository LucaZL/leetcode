package other;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/21
 */
public class SortTest {

    public static void main(String[] args) {
        Student[] studentArray = new Student[3];
        Random random = new Random();
        for(int i=0;i<3;i++) {
            Student student = new Student();
            student.age = random.nextInt(100);
            studentArray[i] = student;
        }

        Arrays.stream(studentArray).forEach(System.out::println);
        quickSort(studentArray, 0, studentArray.length - 1);
        Arrays.stream(studentArray).forEach(System.out::println);
    }

    public static int getMiddle(Student[] studentArray, int start, int end) {
        Student student = studentArray[start];
        while(start < end) {
            while(start < end && studentArray[end].age > student.age) {
                end--;
            }
            if(start < end) {
                studentArray[start] = studentArray[end];
            }
            while(start < end && studentArray[start].age < student.age) {
                start++;
            }
            if(start < end) {
                studentArray[end] = studentArray[start];
            }
        }
        System.out.println(start + "," + end);
        studentArray[start] = student;
        return start;
    }

    public static void quickSort(Student[] studentArray, int start, int end) {
        if(start < end) {
            int mid = getMiddle(studentArray, start, end);
            quickSort(studentArray, start, mid - 1);
            quickSort(studentArray, mid + 1, end);
        }
    }
}

class Student {
    public int age;
    public String toString() {
        return String.valueOf(age);
    }
}
