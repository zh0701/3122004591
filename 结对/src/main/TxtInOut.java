package main;
import java.io.*;
public class TxtInOut {
    public static String[] readTxt(String absPath){
        int num= 0;
        try {
            num = checkLineNum(absPath);//查询文件行数，即当前文件题目数量
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String array[]=new String[num];
        try
        {   int k=0;
            FileReader fr = new FileReader(absPath);
            BufferedReader br = new BufferedReader(fr);
            String s ;
            while((s = br.readLine())!=null) {//读取文件内容
            array[k]=s;	k++;
            }
            br.close();
            fr.close();
            return array;
        }
        catch(IOException e){
        System.out.println("指定文件不存在");
        }
        return array;
    }
    public static int checkLineNum(String absPath)throws Exception{
        File file = new File(absPath);
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[(int)file.length()];
        fis.read(byteArray);
        String data = new String(byteArray);
        String[] stringArray = data.split("\r\n");
        return stringArray.length;

    }
    public static void checkTxt(String absPathOfYourAns,String absPathOfResult){
        String youranwers[]=readTxt(absPathOfYourAns);
        String result[]=readTxt(absPathOfResult);
        int rightNum[]=new int[youranwers.length+2];
        int wrongNum[]=new int[youranwers.length+2];
        int rightCount=0;
        int wrongCount=0;
        for(int j=0;j<youranwers.length;j++){
            if(youranwers[j].equals(result[j])) {//验证答案，统计正确和错误的个数
                rightNum[j]=j+1;
                rightCount++;
            }
            else {
                wrongNum[j]=j+1;
                wrongCount++;
            }
        }
        FileWriter fg = null;
        try {
            //反馈正确与错误题目的信息
            File f=new File("Grade.txt");
            fg = new FileWriter(f, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pg = new PrintWriter(fg);
        pg.println(" ");
        pg.print("Correct:"+rightCount+"(");
        for (int j = 0; j <= youranwers.length; j++) {
            if (rightNum[j] != 0) {
                pg.print(rightNum[j] + ",");
            }
        }
        pg.println(")");
        pg.print("Wrong:"+wrongCount+"(");
        for (int j = 0; j <= youranwers.length; j++) {
            if (wrongNum[j] != 0) {
                pg.print(wrongNum[j] + ",");
            }
        }
        pg.print(")");
        pg.flush();
        try {
            fg.flush();
            pg.close();
            fg.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static  void writeTxt(String[] str,String absPath){
        File file = new File(absPath);
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(file,false);
            for(int i=0;i<str.length;i++){
                fileWriter.write((i+1)+". ");
                fileWriter.write(str[i]);
                fileWriter.write("\r\n");
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}