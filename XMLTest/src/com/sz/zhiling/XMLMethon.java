package com.sz.zhiling;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class XMLMethon {

    /**
     * 从xml文件读数据，返回User的list对象
     * @param url
     * @return List<User>
     */
    public List<User> readXML(String url){
        System.out.println("开始从"+url+"读取文件...");
        //实例化解析对象
        SAXReader saxReader = new SAXReader();
        List<User> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        try {
            //把url处的xml文件解析为Document对象
            Document document = saxReader.read(url);
            //从文档对象中获取根元素
            Element root = document.getRootElement();
            //获取迭代器
            Iterator<Element> eleIt1 = root.elementIterator();
            while (eleIt1.hasNext()){
                map.clear();
                Element element = eleIt1.next();
                //获取元素属性迭代器
                Iterator<Attribute> attIt = element.attributeIterator();
                while(attIt.hasNext()){
                    Attribute attribute = attIt.next();
                    map.put(attribute.getName(),attribute.getValue());
                }
                //获取元素子元素迭代器
                Iterator<Element> eleIt2 = element.elementIterator();
                while(eleIt2.hasNext()){
                    Element elementSon = eleIt2.next();
                    String text = elementSon.getText();
                    map.put(elementSon.getName(),text);
                }
                User user = new User(map);
                list.add(user);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println("读取成功!");
        return list;
    }

    /**
     * 将User的list对象写入url指向的文件
     * @param list
     * @param url
     */
    public void writeXML(List<User> list,String url){
        System.out.println("开始向"+url+"写入...");
        //定义输出的格式，注意不是用的new
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        //定义文档对象，这里也不是用的new
        Document document = DocumentHelper.createDocument();
        //创建根元素element1
        Element element1 = document.addElement("Users");
        //循环添加User对象
        for (User user : list) {
            //创建element1的子元素element2
            Element element2 = element1.addElement("User");
            //给元素element2添加uid和name属性
            element2.addAttribute("uid",user.getUid());
            element2.addAttribute("name",user.getName());
            //添加element2的子元素
            Element element3 = element2.addElement("age");
            element3.addText(user.getAge()+"");
            Element element4 = element2.addElement("sex");
            element4.addText(user.getSex());
        }
        //创建输出流对象
        XMLWriter xmlWriter = null;
        File file = new File(url);
        try {
            xmlWriter = new XMLWriter(new FileWriter(url),outputFormat);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
            System.out.println("写入文件"+file.getAbsolutePath()+"成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
