package spring.aop.helloworld;

public class Main {
    public static void main(String[] args) {
//        ArithmeticCalculator arithmeticCalculatorImp = new ArithmeticCalculatorImp();

        ArithmeticCalculator target = new ArithmeticCalculatorImp();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();


//        arithmeticCalculatorImp.add(1,2);
        proxy.add(1,2);


    }
}
