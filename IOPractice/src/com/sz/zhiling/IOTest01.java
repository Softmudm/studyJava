package com.sz.zhiling;

import java.io.*;

public class IOTest01 {
    public static void main(String[] args) {
        /**
         * 字节流
         */
        /*File file = new File("3.txt");
        System.out.println(file.list());
        StringBuffer str = new StringBuffer("D:");
        File f2 = null;
        for (int i = 0; i < 3 ; i++) {
            str.append("/"+i);
            f2 = new File(str.toString());
            f2.mkdirs();
            for(int j =4;j<7;j++){
                str.append("/"+i+j);
                f2 = new File(str.toString());
                f2.mkdirs();
            }
            try {
                File.createTempFile("我是第"+i,".txt",f2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        /**
         * 字符流
         */
        File f3 = new File("8.txt");
        File f4 = new File("9.txt");
        try {
            FileReader read = new FileReader(f3);
            FileWriter write = new FileWriter(f4);
            char[] a = new char[1024];
            int num = read.read(a);
            while(num != -1){
                write.write(a);
                num = read.read(a);
            }
            write.flush();
            write.close();
            read.read();
            System.out.println("复制成功!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
