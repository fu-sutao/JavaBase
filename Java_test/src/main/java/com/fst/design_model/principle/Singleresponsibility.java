package com.fst.design_model.principle;
//单一职责原则
public class Singleresponsibility {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("飞机");
        //---------------------------------
        RoadVehicle vehicle1 = new RoadVehicle();
        vehicle1.run("qiche");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("feiji");
        //----------------------------------
        Vehicle3 vehicle3 = new Vehicle3();
        vehicle3.run("1");
        vehicle3.run("2");
    }
}
//交通工具类
//方式1
//1·在方式1的run中违反的单一职责原则
//2·解决方案：根据交通方式运行方式不同分解成不同的类。
class Vehicle{
    public void run(String ve){
        System.out.println(ve+"在公路上运行。。。。。");

    }
}
//方案2
//1·遵守单一职责原则
//2·但是这样改动很大及把类分解
//
class RoadVehicle{
    public void run(String ve){
        System.out.println(ve+"在公路上运行。。。。。");
    }
}
class AirVehicle{
    public void run(String ve){
        System.out.println(ve+"在天上上运行。。。。。");
    }
}
//方案3
//1·这种修改方法没有做大的修改
//2·这里虽然没有在类级别上遵守单一职责原则，但是在方法上仍然遵守单一职责原则。
//3·方法较少的时候可以在放大级别违反单一职责原则
class Vehicle3{
    public void run(String ve){
        System.out.println(ve+"在公路上运行。。。。。");
    }
    public void runAir(String ve){
        System.out.println(ve+"在天上运行。。。。。");
    }
}

























