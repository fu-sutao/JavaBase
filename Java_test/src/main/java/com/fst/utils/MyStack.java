package com.fst.utils;

import java.util.Observable;

public class MyStack <T>{
    int count = 0;
    Node node;//当前Node；
    public T pop(){
        T temp = (T)node.t;
        node = node.next;
        count--;
        return temp;
    }
    public void push(T o){
        Node no = new Node<T>();
        if(node!=null){

            no.t = o;
            no.next=node;
            node = no;
        }else {
            no.t = o;
            node = no;
        }
        count++;
    }
    public int size(){
        return count;
    }

    class Node <T>{
        Node next;
        T t;
    }

}
