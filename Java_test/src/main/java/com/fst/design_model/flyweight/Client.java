package com.fst.design_model.flyweight;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite webSite = webSiteFactory.getWebSiteCategory("新闻");
        User user = new User();
        user.setName("fst");
        webSite.user(user);
    }


}
abstract class WebSite{
    public abstract void user(User user);
}
class ConcreteWebSite extends WebSite{
    //共享部分
    private String type= "";//网站发布形式

    public ConcreteWebSite(String type){
        this.type = type;
    }

    public void user(User user) {
        System.out.println("网站发布形式为"+type+user.getName());
    }
}
//网站工厂类，根据需求返回一个网站
class WebSiteFactory{
    //集合充当池的作用
    private HashMap<String ,ConcreteWebSite> pool = new HashMap<>();

    public WebSite getWebSiteCategory(String type){
        if(!pool.containsKey(type)){
            //就创建一个网站，并放入到池中
            pool.put(type,new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }
    //获取网站分类总数
    public int getWebSiteCount(){
        return pool.size();
    }
}
//外部状态
class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
















