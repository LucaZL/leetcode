package other;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/2
 */
public class ObjectSizeTest {

    public static void main(String[] args) {
        printObject(new Boolean(String.valueOf(1)));
        printObject(new Integer(1));
        printObject(new Integer[3]);
        printObject(new Integer[4]);
    }

    public static void printObject(Object o) {
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("----------------------------------------------------------------------------");
    }
}
