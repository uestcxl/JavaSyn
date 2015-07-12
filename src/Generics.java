import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by xl on 15/7/8.
 */
public class Generics< T > {

    T obj;

    public T getObj(){
        return obj;
    }

    public void setObj( T obj ){
        this.obj = obj;
    }

    public static < T > void array2Collection( T[] t, Collection< T > col ){
        for ( T i : t ){
            col.add( i );
        }
    }

    public static void main( String[] args){
        Generics< String > genTest1 = new Generics<>();
        genTest1.setObj("asd");
//        System.out.print(genTest1);

        Student[] stu = new Student[100];
        Object[] obj = new Object[10];
        Collection< Object > col = new ArrayList<>();
        genTest1.< Object >array2Collection( obj, col );
        System.out.println( col.size() );
    }
}
