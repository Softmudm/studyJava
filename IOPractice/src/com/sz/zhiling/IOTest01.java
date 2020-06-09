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
        /**
         * 缓冲流
         */
        FileInputStream fis1 = null;
        FileOutputStream fos1 = null;
        BufferedInputStream bis1 = null;
        BufferedOutputStream bos1 = null;
        try {
            fis1 = new FileInputStream("9.txt");
            fos1 = new FileOutputStream("10.txt");
            bis1 = new BufferedInputStream(fis1);
            bos1 = new BufferedOutputStream(fos1);
            int num = bis1.read();
            while(num != -1){
                bos1.write(num);
                num = bis1.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos1.flush();
                bos1.close();
                bis1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Writer w = null;
        Reader r = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            r = new FileReader("11.txt");
            w = new FileWriter("12.txt",true);//这里的true是不覆盖而是在12.txt内追加.
            br = new BufferedReader(r);
            bw = new BufferedWriter(w);
            String str = br.readLine();
            while (str != null){
                bw.write(str);
                str = br.readLine();
            }
            System.out.println("使用缓冲字符流复制文件成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.flush();
                bw.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * 对象流
         */
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream("13.txt");//序列化到这个文件
            inputStream = new FileInputStream("13.txt");//从这个文件反序列化
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(inputStream);
            User user = new User("张三",88);
            objectOutputStream.writeObject(user);
           /* byte[] bt = new byte[1024*8];
            int num = inputStream.read(bt);
            while(num != -1){
                for (byte b : bt) {
                    System.out.println((char)b);
                }
                num = inputStream.read(bt);
            }*/
            Object o = objectInputStream.readObject();
            System.out.println((User)o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.flush();
                objectOutputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
