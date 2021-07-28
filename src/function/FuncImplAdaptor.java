package function;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Resource;

/**
 * @description: funct adaptor
 * @author: zhaolu
 * @createDate: 2021/3/3
 */
public class FuncImplAdaptor implements FuncInterface {

    @Resource
    private FuncImplA funcImplA = new FuncImplA();
    @Resource
    private FuncImplB funcImplB = new FuncImplB();

    public boolean switchFun = true;

    FuncImplAdaptor(boolean switchFun) {
        this.switchFun = switchFun;
    }

    @Override
    public String methodA(String str) {
        this.getClass();
        this.getClass().getTypeParameters();
        if(switchFun) {
            try {
                return funcImplA.methodA(str);
            }catch (Exception e) {

            }
        }
         return funcImplB.methodA(str);
    }

    @Override
    public String methodB(String str) {
        if(switchFun) {
            try {
                return funcImplA.methodB(str);
            }catch (Exception e) {

            }
        }
        return funcImplB.methodB(str);
    }

    private String switchFunction(String methodName, Class[] parameterTypes) {
//        try {
//            Method methodA = funcImplA.getClass().getMethod(methodName, parameterTypes);
//            if(switchFun) {
//                try {
//                    return methodA.invoke(parameterTypes);
//                }catch (Exception e) {
//
//                }
//            }
//            return funcImplB.methodB(str);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
