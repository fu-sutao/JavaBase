package com.fst.design_model.principle;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则
 */
public class Demeter {
    public static void main(String[] args) {

    }
}
//学校总部员工类
class Employee{
    public void setId(String id, int i) {
    }
}
class CollegeEmployee extends Employee{

}
class CollegeManager{

    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for(int i=0;i<10;i++){
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("123",i);
        }
        return list;
    }
}
//分析SchoolManager类的直接朋友类有哪些
//Employee CollegeManager
//CollegeEmployee不是直接朋友
class SchoolManager{
    public List<Employee> getAllEmployee(){
        List<Employee>  list = new ArrayList<>();
        for(int i=0;i< 5;i++){
            Employee employee = new Employee();
            employee.setId("员工id",i);
            list.add(employee);
        }
        return null;
    }
    //改进方案：把下面的方法放入到CollegeManager中
    public void printAllEmployee(CollegeManager sub){
        //CollegeEmployee不是SchoolManager的直接朋友
        //2·CollegeEmployee是以局部变量方式出现在SchoolManager
        //3·违反了迪米特法则


        //获取学院员工
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        for(CollegeEmployee e:list1){
            System.out.println("员工信息");
        }
    }


}






















