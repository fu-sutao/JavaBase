package com.fst.design_model.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<College>();
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();
        colleges.add(computerCollege);
        colleges.add(infoCollege);
        OutPutImpl o  = new OutPutImpl(colleges);
        o.printCollege();
    }
}
class Department{
    private  String name;
    private  String desc;

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

class ComputerCollegeIterator implements Iterator{
    //这里我们需要Department 是以怎样的方式存放
    Department [] departments;
    int position = 0;//遍历位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position>=departments.length||departments[position]==null){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Object next() {
        Department department = departments[position];
        position++;
        return null;
    }
//    删除的方法默认空实现
    @Override
    public void remove() {

    }
}
class InfoCollegeIterator implements Iterator{
    List<Department> departments;//信息工程学院是以list存放
    int index = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(index>=departments.size()-1){
            return false;
        }else {
            index++;
            return true;
        }

    }

    @Override
    public Object next() {
        return departments.get(index);

    }

    @Override
    public void remove() {

    }
}
//学院
interface College{
    public String getName();
    //增加系的方法
    public void addDepartment(String name,String desc);
    //返回一个迭代器，遍历
    public Iterator createIterator();
}
//计算机学院
class ComputerCollege implements College{
    Department[] departments;
    int numOfDepartment = 0;//保存当前数组的对象个数

    public ComputerCollege() {
        this.departments = new Department[5];
        addDepartment("java","java");
        addDepartment("java2","java2");
        addDepartment("java3","java4");
        addDepartment("java4","java4");
        addDepartment("java5","java5");

    }

    @Override
    public String getName() {
        return "aaaa";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name,desc);
        departments[numOfDepartment] = department;
        numOfDepartment++;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
//信息技术学院
class InfoCollege implements College{
    List<Department> departments;

    public InfoCollege() {
        this.departments = new ArrayList<Department>();
        addDepartment("信息安全专业","信息安全专业描述");
        addDepartment("网络安全专业","网络安全专业描述");
        addDepartment("系统安全专业","系统安全专业描述");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name,desc);
        departments.add(department);

    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departments);
    }
}

class OutPutImpl{
    //学院集合
    List<College> colleages;
    public OutPutImpl(List<College> colleages){
        this.colleages = colleages;//初始化
    }
    //输出  学院输出 系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department d = (Department) iterator.next();
            System.out.println(d.getName());
        }
    }
    //遍历所有学院，让后调用printDepartment输出各个学院的系
    public void printCollege(){
        //从collelist取出所有学院 java中的list已经实现Iterator
        Iterator<College> iterator = colleages.iterator();
        while (iterator.hasNext()){
            College college = iterator.next();
            System.out.println("===="+college.getName()+"====");
            printDepartment(college.createIterator());//得到对应的迭代器
        }
    }

}



























