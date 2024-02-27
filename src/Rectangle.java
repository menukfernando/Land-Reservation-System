/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menuk Fernando
 */
public class Rectangle extends Shape {

    public Rectangle(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    double PerchArea() {
        return (length * width) / 272.25;
    }

    @Override
    double PriceForEachBlock() {
        return (this.PerchArea() * 1100000);
    }

    
}
