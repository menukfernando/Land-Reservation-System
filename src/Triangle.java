/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menuk Fernando
 */
public class Triangle extends Shape {
    
    Triangle(String name, double base, double height){    
        this.name = name;
        this.base = base;
        this.height = height;
    }

    @Override
    double PerchArea() {
        return (0.5 * base * height) / 272.25;
    }

    @Override
    double BlockPrice() {
        return (this.PerchArea() * 1000000);
    }
}
