package com.sz.zhiling;

import java.io.*;

public class IOTest02 {
    public static void copyFile(String f1,String f2){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(f1);
            outputStream = new FileOutputStream(f2);
            byte[] bt = new byte[1024];
            int n = inputStream.read(bt);//bt数组中有值的个数
            while (n != -1){
                outputStream.write(bt,0,n);
                n = inputStream.read(bt);//继续读文件
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void zuoYe(String s1,String s2){//s1源文件,s2目标文件
        File f1 = new File(s1);
        if(f1.isDirectory()){
            File f2 = new File(s2+"/"+f1.getName());
            f2.mkdir();
            String[] strings = f1.list();
            for (String string : strings) {
                zuoYe(s1+"/"+string,s2+"/"+f2.getName());
            }
        }else{
            copyFile(s1,s2+"/"+f1.getName());
        }
    }
    public static void main(String[] args) {
        zuoYe("D:/222","F:");
    }
}
