package main;
import java.util.Random;
public class Expression {
    private static Random random = new Random();
    private static int numerator;//计算结果的分子参数
    private static int denominator;//计算结果的分母参数
    public static String[] expressionCreat(int range) {
        String arr[] = new String[2];
        int nOfNum1 = (int) (random.nextInt(range));//numeratorOfNum1-第一个数的分子
        int dOfNum1 = (int) (random.nextInt(range));//denominatorOfNum1-第一个数的分母
        int nOfNum2 = (int) (random.nextInt(range));//numeratorOfNum2
        int dOfNum2 = (int) (random.nextInt(range));//denominatorOfNum2
        int symbol = (int) (random.nextInt(4));
        //分母均不为0
        if (dOfNum1 != 0 && dOfNum2 != 0) {
            if (symbol == 0) {
                numerator = nOfNum1 * dOfNum2 + dOfNum1 * nOfNum2;
                denominator = dOfNum1 * dOfNum2;
                arr[0] = improperFractionToTrue(nOfNum1, dOfNum1) + "\t+\t" + improperFractionToTrue(nOfNum2, dOfNum2) + "\t= ";
                System.out.println(arr[0]);
                arr[1] = reductionofFraction(numerator, denominator);
                return arr;

            }
            if (symbol == 1 && nOfNum1 * dOfNum2 - dOfNum1 * nOfNum2 >= 0) {
                numerator = nOfNum1 * dOfNum2 - dOfNum1 * nOfNum2;
                denominator = dOfNum1 * dOfNum2;
                arr[0] = improperFractionToTrue(nOfNum1, dOfNum1) + "\t-\t" + improperFractionToTrue(nOfNum2, dOfNum2) + "\t= ";
                System.out.println(arr[0]);
                arr[1] = reductionofFraction(numerator, denominator);
                return arr;

            }
            if (symbol == 1 && nOfNum1 * dOfNum2 - dOfNum1 * nOfNum2 < 0) {
                numerator = dOfNum1 * nOfNum2 - nOfNum1 * dOfNum2;
                denominator = dOfNum1 * dOfNum2;
                arr[0] = improperFractionToTrue(nOfNum2, dOfNum2) + "\t-\t" + improperFractionToTrue(nOfNum1, dOfNum1) + "\t= ";
                System.out.println(arr[0]);
                arr[1] = reductionofFraction(numerator, denominator);
                return arr;
            }
            if (symbol == 2) {
                numerator = nOfNum1 * nOfNum2;
                denominator = dOfNum1 * dOfNum2;
                arr[0] = improperFractionToTrue(nOfNum1, dOfNum1) + "\t×\t"+ improperFractionToTrue(nOfNum2, dOfNum2) + "\t= ";
                System.out.println(arr[0]);
                arr[1] = reductionofFraction(numerator, denominator);
                return arr;
            }
            if (symbol == 3 && nOfNum2 != 0) {
                numerator = nOfNum1 * dOfNum2;
                denominator = dOfNum1 * nOfNum2;
                arr[0] = improperFractionToTrue(nOfNum1, dOfNum1) + "\t÷\t"+ improperFractionToTrue(nOfNum2, dOfNum2) + "\t= ";
                System.out.println(arr[0]);
                arr[1] = reductionofFraction(numerator, denominator);
                return arr;
            }
            if (symbol == 3 && nOfNum2 == 0) {
                arr[0] = "false";
                return arr;
            }
        }
        //分母有0,忽略分母计算
        else {
            dOfNum1 = 1;
            dOfNum2 = 1;
            if (symbol == 0) {
                arr[0] = nOfNum1 + "\t+\t" + nOfNum2 + "\t= ";
                System.out.println(arr[0]);
                arr[1] = String.valueOf(nOfNum1+nOfNum2);
                return arr;

            }
            if (symbol == 1 && nOfNum1-nOfNum2 >= 0) {
                arr[0] = nOfNum1 + "\t-\t" + nOfNum2 + "\t= ";
                System.out.println(arr[0]);
                arr[1] = String.valueOf(nOfNum1-nOfNum2);
                return arr;

            }
            if (symbol == 1 && nOfNum1-nOfNum2 < 0) {
                arr[0] = nOfNum2 + "\t-\t" + nOfNum1 + "\t= ";
                System.out.println(arr[0]);
                arr[1] = String.valueOf(nOfNum2-nOfNum1);
                return arr;

            }
            if (symbol == 2) {
                arr[0] = nOfNum2 + "\t×\t" + nOfNum1 + "\t= ";
                System.out.println(arr[0]);
                arr[1] = String.valueOf(nOfNum1*nOfNum2);
                return arr;

            }
            if (symbol == 3 && nOfNum2 != 0) {
                arr[0] = nOfNum1 + "\t÷\t" + nOfNum2 + "\t=";
                System.out.println(arr[0]);
                arr[1] = reductionofFraction(nOfNum1,nOfNum2);
                return arr;

            }
            if (symbol == 3 && nOfNum2 == 0) {
                arr[0] = "false";
                return arr;
            }

        }
        arr[0]="false";
        return arr;
    }
    public static String reductionofFraction(int a, int b) {// 分数约分，用于计算结果
        int y = 1;
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                y = i;
                break;
            }
        }
        int z = a / y;// 分子
        int m = b / y;// 分母
        if (z == 0) {
            return "0";
        }
        if(m==1) return z+"";
        else  return improperFractionToTrue(z,m);

    }
    public static String improperFractionToTrue(int a, int b) {
        if(a>=b) return a%b==0?String.valueOf(a/b):a/b+"'"+a%b+"/"+b;
        return a+"/"+b;
    }


}