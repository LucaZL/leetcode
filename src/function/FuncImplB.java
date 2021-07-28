package function;

/**
 * @description: funcB
 * @author: zhaolu
 * @createDate: 2021/3/3
 */
public class FuncImplB implements FuncInterface {

    @Override
    public String methodA(String str) {
        return "funcB, methodA " + str;
    }

    @Override
    public String methodB(String str) {
        return "funcB, methodB " + str;
    }
}
