import java.io.PrintWriter;

/**
 * Created by xl on 15/7/12.
 */
public class Swap {
    public static void main( String[] args ){
        People a = new People( 20, "xl" );
        People b = new People( 10, "asd" );
//        a.change( a, b );
        System.out.println(a.name + " : " + a.age);

        a.changeBySt("test");
        System.out.println(a.name + " : " + a.age);

        a.change(a);
        System.out.println(a.name + " : " + a.age);

        Animal pets = a.getPets();
        pets.eat();
        a.getPlant( a.getPets() );
        a.getPets().shit();
    }
}

class People{

    int age;
    String name;

    public People(){}

    public People( int age, String name ){
        this.age = age;
        this.name = name;
    }

    public void change( People a, People b ){
        a.age = b.age;
        a.name = b.name;
    }

    public void swap( People a, People b ){
        People temp = new People();
        temp = a;
        a = b;
        b = temp;
    }

    public void change( People a ){
        a.name = "Change by func change";
    }

    public void changeBySt( String name ){
        this.name = name;
    }

    public void changeByNew( People a ){
        People tmp = new People( 100, "change by New" );
    }

    public Pets getPets(){
        return new Pets( "xl", 20 );
    }

    public void getPlant( Plant plant ){
        plant.eat();
    }
}

//Living abstract
abstract class Living{

    //default func
    public void breath(){
        System.out.println("Abstract default func: Living's breathing");
    }

    public abstract void shit();
}

//Animal interface
interface Animal{
    public static final int age = 0;
    public static final String name = "";

    public void eat();
    public void run();
}

//Plant interface
interface Plant{
    public void eat();
}

class Pets extends Living implements Animal, Plant {

    int age;
    String name;

    public Pets(){}

    public Pets( String names, int ages ){
        this.name = names;
        this.age = ages;
    }

    @Override
    public void eat() {
        System.out.println("Pets eat, age:" + age + " " + name);
    }

    @Override
    public void run() {
        System.out.println("Pets run, age:" + age + " " + name);
    }

    @Override
    public void shit() {
        System.out.println("Pets shiting......");
    }
}