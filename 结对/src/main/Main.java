package main;
import java.util.Scanner;
public class Main {
    public static int range;//数字范围
    public static int num;//表达式数量
    public static String[] expression;
    public static String[] result;
    public static void main(String[] args){
        menu(args);
    }
    public static void menu(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请选择功能（1或2）：\r\n");
        System.out.println("1.随机生成题目\r\n");
        System.out.println("2.检查答案\r\n");
        String input=sc.next();
        switch(input)
        {
            case "1":createMenu(args);break;
            case "2":checkMenu(args);break;
            default:System.out.println("输入错误，请重新输入：\r\n"); menu(args); break;
        }
    }
    public static void checkMenu(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入你的答案文档的绝对路径：\r\n");
        String input=sc.next();
        TxtInOut.checkTxt("Manswers.txt","answers.txt");
        System.out.println("已生成校验文档:Grade.txt ");
        System.exit(0);

    }
    public static void createMenu(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入所需题目中的最大数字：");
        range=sc.nextInt();
        System.out.println("请输入需要生成的题目数量：");
        num=sc.nextInt();
        expression=new String[num];
        result=new String[num];
        for(int i=0;i<num;i++){
            String[] str=Expression.expressionCreat(range);
            if(str[0]=="false"){
                i--;
                continue;
            }
            expression[i]=str[0];
            result[i]=str[1];
        }
        TxtInOut.writeTxt(expression,"exercises.txt");
        TxtInOut.writeTxt(result,"answers.txt");
    }
}