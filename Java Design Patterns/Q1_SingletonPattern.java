/* Q1) Implement Singleton Design Pattern on a dummy class.*/
package java6_Assgnmnt;

class SingletonDesign {
    static SingletonDesign singletonDesign;
    int id;
    String name;

    public SingletonDesign(){
        try{
            Thread.sleep(200L);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.id = 3027;
        this.name = "Akash";
    }

    static SingletonDesign getinstance(){
        if(singletonDesign == null){
            singletonDesign = new SingletonDesign();
        }
        return singletonDesign;
    }

    @Override
    public String toString(){
        return "Singleton Design : { " +
                "id = "+id+
                " Name = "+name+
                "}";
    }
}


public class Q1_SingletonPattern {
    public static void main(String[] args) {
        System.out.println(SingletonDesign.getinstance());
    }
}
