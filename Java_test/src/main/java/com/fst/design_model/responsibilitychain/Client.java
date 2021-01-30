package com.fst.design_model.responsibilitychain;

public class Client {
    public static void main(String[] args) {
        PurRequest purRequest = new PurRequest(1,3000,1);
        //创建审批人
        Dep dep = new Dep("张主任");
        College college = new College("李院长");
        ViceSchool viceSchool = new ViceSchool("副校长");
        School school = new School("校长");
        //设置审批的下一个人;处理人构成环形
        dep.setApprover(college);
        college.setApprover(viceSchool);
        viceSchool.setApprover(school);
        school.setApprover(dep);

        //发出请求
        dep.processRequest(purRequest);
    }
}
class PurRequest{
    private int type;
    //private int number;
    private float price = 0.0f;
    private int id = 0;

    public PurRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;//请求的金额
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}


abstract class Approver{
    Approver approver;//下一个处理者
    String name;//名字

    public Approver(String name) {
        this.name = name;
    }
    //设置下一个处理者
    public void setApprover(Approver approver) {
        this.approver = approver;
    }
    //处理审批的方法
    public abstract void processRequest(PurRequest purRequest);
}
class Dep extends Approver{

    public Dep(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurRequest purRequest) {
        if(purRequest.getPrice()<5000){
            System.out.println("请求编号id="+purRequest.getId()+"被"+this.name+"处理");
        }else {
            //
            approver.processRequest(purRequest);
        }
    }
}
class College extends Approver{

    public College(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurRequest purRequest) {
        if(5000<=purRequest.getPrice() && purRequest.getPrice()<10000){
            System.out.println("请求编号id="+purRequest.getId()+"被"+this.name+"处理");
        }else {
            //
            approver.processRequest(purRequest);
        }
    }
}
class ViceSchool extends Approver{
    public ViceSchool(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurRequest purRequest) {
        if(10000<=purRequest.getPrice() && purRequest.getPrice()<30000){
            System.out.println("请求编号id="+purRequest.getId()+"被"+this.name+"处理");
        }else {
            //
            approver.processRequest(purRequest);
        }
    }
}
class School extends Approver{

    public School(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurRequest purRequest) {
        if(30000<=purRequest.getPrice()){
            System.out.println("请求编号id="+purRequest.getId()+"被"+this.name+"处理");
        }else {
            //
            approver.processRequest(purRequest);
        }
    }
}
























