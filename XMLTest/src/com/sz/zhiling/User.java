package com.sz.zhiling;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class User {
    private String uid;
    private String name;
    private int age;
    private String sex;

    public User() {
    }

    public User(String uid, String name, int age, String sex) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(Map<String,String> map) {
        /*Set<String> set = map.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            switch(key){
                case "uid":
                    this.uid = map.get(key);
                    break;
                case "name":
                    this.name = map.get(key);
                    break;
                case "age":
                    try {
                        this.age = Integer.parseInt(map.get(key));
                    } catch (NumberFormatException e) {
                        System.out.println("年龄必须为数字！");
                        e.printStackTrace();
                    }
                    break;
                case "sex":
                    this.sex = map.get(key);
                    break;
            }
        }*/
        this.uid = map.get("uid");
        this.name = map.get("name");
        try {
            this.age = Integer.parseInt(map.get("age"));
        } catch (NumberFormatException e) {
            System.out.println("年龄只能为数字！");
            e.printStackTrace();
        }
        this.sex = map.get("sex");
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
