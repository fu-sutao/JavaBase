package com.fst.design_model.buliding;

public class commonhpuse extends House {
    @Override
    public void buildBase() {
        super.buildBase();
        System.out.println("打地基");
    }

    @Override
    public void buildWalls() {
        super.buildWalls();
        System.out.println("砌墙");
    }

    @Override
    public void roofed() {
        super.roofed();
        System.out.println("封顶");
    }
}