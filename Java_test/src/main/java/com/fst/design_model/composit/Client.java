package com.fst.design_model.composit;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        OrganizationComponent un=new University("商丘师范","123");

        OrganizationComponent college = new College("化学化工学院","123");
        OrganizationComponent college2 = new College("国际教育学院","123");
        college.add(new Department("材料科学与工程",""));

    }
}
abstract class OrganizationComponent{
    private String name;
    private String dec;
    protected void add(OrganizationComponent organizationComponent){
        //默认实现
        throw new UnsupportedOperationException();//不支持操作异常
    }
    protected void remove(OrganizationComponent organizationComponent){
        //默认实现
        throw new UnsupportedOperationException();//不支持操作异常
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public OrganizationComponent(String name, String dec) {
        this.name = name;
        this.dec = dec;
    }
    protected abstract void print();
}
class University extends OrganizationComponent{

    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public University(String name, String dec) {
        super(name, dec);
    }

    @Override
    protected void print() {
        System.out.println("-----------"+super.getName());
        for(OrganizationComponent o:organizationComponents){
            o.print();
        }

    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }
}
class College extends OrganizationComponent{
    //list中存放的是depment
    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public College(String name, String dec) {
        super(name, dec);
    }

    @Override
    protected void print() {
        System.out.println("-----------"+super.getName());
        for(OrganizationComponent o:organizationComponents){
            o.print();
        }

    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //实际业务中不一定和上面的add相同
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }
}

class Department extends OrganizationComponent{

    public Department(String name, String dec) {
        super(name, dec);
    }

    @Override
    protected void print() {

    }
    //add 和remove就不用写了
}













