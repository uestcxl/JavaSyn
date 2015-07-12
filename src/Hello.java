import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by xl on 15/4/10.
 * java并发编程之java并发容器和框架
 */
public class Hello {
    public static void main(String[] args){
        //HashSet简单的equals和hashcode区别
/*        final HashMap< String, String > map = new HashMap< String, String >(2);
        HashSet< String > hashSetString = new HashSet< String >();
        String string1 = new String("test1");
//        String string2 = new String("test2");
        String string2 = new String( "test1" );
        System.out.println( string1.equals(string2) );
        System.out.println( string1.hashCode() );
        System.out.println(string2.hashCode());

        hashSetString.add(string1);
        hashSetString.add(string2);
        Iterator< String > it = hashSetString.iterator();
        while ( it.hasNext() ){
            System.out.println( it.next() );
        }*/

        //对象的hashcode与equals
        HashSet< Student > hashSetStu = new HashSet< Student >();
        Student stu1 = new Student( "xl", 19 );
        Student stu2 = new Student( "xl", 19 );
        Student stu3 = new Student( "Xl", 18 );

        hashSetStu.add( stu1 );
        hashSetStu.add( stu2 );
        hashSetStu.add( stu3 );

        Iterator< Student > it = hashSetStu.iterator();
        while ( it.hasNext() ){
            System.out.println( it.next() );
        }

        System.out.println( stu1.equals(stu2) );
        System.out.println( stu1.hashcode() );
        System.out.println( stu2.hashcode() );
    }
}

class Student{

    String name;
    int age;

    public Student(){
        this.name = "小明";
        this.age = 18;
    }

    public Student( String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Hello " + this.name + ", " + this.age;
    }

    //重写hashcode 和 equals方法
    public int hashcode(){
        return this.age * this.name.hashCode();
    }

    public boolean equals( Object o ){
        Student s = ( Student )o;
        return s.age == this.age && this.name.equals( s.name );
    }
}