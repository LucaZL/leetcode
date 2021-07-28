package function;

/**
 * @description: functA
 * @author: zhaolu
 * @createDate: 2021/3/3
 */
public class FuncImplA implements FuncInterface {


    @Override
    public String methodA(String str) {
        return "funcA, methodA " + str;
    }

    @Override
    public String methodB(String str) {
        return "funcA, methodB " + str;
    }
}
