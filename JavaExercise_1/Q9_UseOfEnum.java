/*Q9_UseOfEnum.Write a program to display values of enums using a constructor & getPrice() method (Example display house & their prices)*/

package java1_Assgnmnt;
enum House{
    Apartment(900),Bunglow(200),Farmhouse(500),Cottage(150),Flat(120);
    private int price;

    House(int p){
        price = p;
    }

    int getPrice(){
        return price;
    }
}

public class Q9_UseOfEnum {
    public static void main(String[] args) {
        System.out.println("All Houses Prices ");
        for(House h : House.values()){
            System.out.println(h+" At Cost Of "+h.getPrice());
        }
    }
}
