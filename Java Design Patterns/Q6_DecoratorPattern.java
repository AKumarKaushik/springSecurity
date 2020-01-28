/*Q6) Implement Decorator pattern to decorate the Pizza with topings.*/
package java6_Assgnmnt;
interface Pizza_Attributes
{
    public String display();
}

class Pizza implements Pizza_Attributes
{
    private String base;


    public Pizza(String base) {
        this.base = base;

    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "base='" + base +
                '}';
    }

    @Override
    public String display() {
        return "Pizza with: " +base;

    }
}
class Toppings implements Pizza_Attributes
{
    private Pizza_Attributes pizza_attributes;
    private String vegetable;

    public Toppings(Pizza_Attributes pizza_attributes, String vegetable) {
        this.pizza_attributes = pizza_attributes;
        this.vegetable = vegetable;
    }

    public Pizza_Attributes getPizza_attributes() {
        return pizza_attributes;
    }

    public void setPizza_attributes(Pizza_Attributes pizza_attributes) {
        this.pizza_attributes = pizza_attributes;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public String display() {
        pizza_attributes.display();
        return "Vegetable: "+vegetable;
    }
}
class Seasonings implements Pizza_Attributes
{
    private Pizza_Attributes pizza_attributes;
    private String seasonings;

    public Seasonings(Pizza_Attributes pizza_attributes, String seasonings) {
        this.pizza_attributes = pizza_attributes;
        this.seasonings = seasonings;
    }

    public Pizza_Attributes getPizza_attributes() {
        return pizza_attributes;
    }

    public void setPizza_attributes(Pizza_Attributes pizza_attributes) {
        this.pizza_attributes = pizza_attributes;
    }

    public String getSeasonings() {
        return seasonings;
    }

    public void setSeasonings(String seasonings) {
        this.seasonings = seasonings;
    }

    @Override
    public String display() {
        pizza_attributes.display();
        return "Seasonings are: "+seasonings;
    }
}

public class Q6_DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza=new Pizza("Thin Crust");
        System.out.println(pizza.display());

        Toppings toppings=new Toppings(new Pizza("Thin Crust"),"Onion and Capsicum");
        System.out.println(toppings.display());

        Seasonings seasonings=new Seasonings(new Pizza("Thin Crust"),"Chili Flakes and Oregano");
        System.out.println(seasonings.display());

    }
}
