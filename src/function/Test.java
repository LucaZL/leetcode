package function;

/**
 * @description: sd
 * @author: zhaolu
 * @createDate: 2021/3/3
 */
public class Test {

    public static void main(String[] args) {
        FuncInterface func = new FuncImplAdaptor(true);
        String str = func.methodA("zl");
        System.out.println(str);

        func = new FuncImplAdaptor(false);
        str = func.methodA("zl");
        System.out.println(str);


    }
}
