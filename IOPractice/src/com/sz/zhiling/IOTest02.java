package com.sz.zhiling;

import java.io.*;

public class IOTest02 {
    public static void copyFile(String f1,String f2){//将f1路径的文件复制到f2路径
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
    public static void copy(String s1,String s2){//s1源文件,s2目标文件。可以复制文件夹
        File f1 = new File(s1);
        String str1 = s2+"/"+f1.getName();
        if(f1.isDirectory()){
            File f2 = new File(str1);
            f2.mkdir();
            String[] strings = f1.list();
            for (String string : strings) {
                copy(s1+"/"+string,str1);
            }
        }else{
            copyFile(s1,str1);
        }
    }
    public static void delete(String s){//删除s路径出的文件或文件夹
        File file1 = new File(s);
        if(file1.isDirectory()){
            String[] str = file1.list();
            if(str != null){
                for (String s1 : str) {
                    delete(file1+"/"+s1);
                }
            }else{
                file1.delete();
            }
            file1.delete();
        }else{
            file1.delete();
        }
    }
    public static void main(String[] args) {
        copy("D:/222","F:");
        delete("F:/222");
    }
}
