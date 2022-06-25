package com.company.CollectionFramework;

// 가상클래스 E 사용할게
public class BoxGeneric<E> {
    private E obj;

    public void setObj(E obj){
        this.obj = obj;
    }


    public E getObj(){
        return obj;
    }
}
