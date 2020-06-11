package com.sz.zhiling;


import java.util.List;

public class XMLMaster {
    public static void main(String[] args) {
        XMLMethon xmlRead = new XMLMethon();
        List<User> list = xmlRead.readXML("user1.xml");
        for (User user : list) {
            System.out.println(user);
        }
        xmlRead.writeXML(list,"user1.xml");
    }
}
