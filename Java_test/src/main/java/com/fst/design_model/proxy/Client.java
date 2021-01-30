package com.fst.design_model.proxy;

/**
 * 代理模式-静态代理
 */
public class Client {

    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        teacherDaoProxy.teach();
    }
}
interface ITeacherDao{
    void teach();
}

class TeacherDao implements ITeacherDao{
    //
    @Override
    public void teach() {
        System.out.println("asas");
    }
}
//代理对象 静态代理
class TeacherDaoProxy implements ITeacherDao{
    private ITeacherDao target;//目标对象，通过接口来聚合

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理。。。。。");
        target.teach();
        System.out.println("代理结束。。。。。");
    }
}































