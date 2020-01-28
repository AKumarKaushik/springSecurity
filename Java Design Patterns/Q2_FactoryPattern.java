/*Q2) Implement Factory Pattern to get the Polygon of differnt type. */
package java6_Assgnmnt;

import javafx.geometry.Side;
import jdk.nashorn.api.tree.SwitchTree;

import javax.print.attribute.standard.Sides;

interface Polygon {
    void getpolygon();
}

class triangle implements Polygon {
    @Override
    public void getpolygon(){
        System.out.println("Triangle having 3 sides");
    }
}

class quadilateral implements Polygon {
    @Override
    public void getpolygon(){
        System.out.println("Quadilateral having 4 sides");
    }
}

class pentagon implements Polygon {

    @Override
    public void getpolygon() {
        System.out.println("Pentagon Having 5 sides");
    }
}

class sides{
    Polygon polygon;

    public Polygon getSides() {
        return polygon;
    }

    public void setSides(Polygon polygon) {
        this.polygon = polygon;
    }
}

class PolygonFactory{
    static sides getPolygonObject(String s){
        sides side = new sides();
        switch(s){
            case "Three Sides": side.setSides(new triangle());
            break;
            case "Four Sides": side.setSides(new quadilateral());
            break;
            case "Five Sides": side.setSides(new pentagon());
            break;
        }
        return side;
    }
}

public class Q2_FactoryPattern {
    public static void main(String[] args) {
            sides threeside = PolygonFactory.getPolygonObject("Three Sides");
            threeside.getSides().getpolygon();
            sides fourside = PolygonFactory.getPolygonObject("Four Sides");
            fourside.getSides().getpolygon();
            sides fiveside = PolygonFactory.getPolygonObject("Five Sides");
            fiveside.getSides().getpolygon();
    }
}
