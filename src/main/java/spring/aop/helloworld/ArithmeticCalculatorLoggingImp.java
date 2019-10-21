package spring.aop.helloworld;

public class ArithmeticCalculatorLoggingImp implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {

        System.out.println("The method add begins whit [" + i + "," + j + "]");
        int result = i + j;
        System.out.println("The method add ends whit " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
