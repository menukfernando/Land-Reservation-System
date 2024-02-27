/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menuk Fernando
 */
public class Trapezoid extends Shape {

     Trapezoid(String name, double height, double base_a, double base_b){
        this.name = name;
        this.height = height;
        this.base_1 = base_a;
        this.base_2 = base_b;        
    }

    @Override
    double PerchArea() {
        return (0.5 * (base_1 + base_2) * height)/ 272.25;
    }

    @Override
    double BlockPrice() {
        return (this.PerchArea() * 1100000);
    }
    
}
