import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by xl on 15/7/13.
 */
public class ThreadTest {
    public static void main( String[] args ){
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Current i: " + i);
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThreadFactory implements ThreadFactory{

    private int count;
    private String name;
    private List<String> stas;

    public MyThreadFactory( String name ){
        this.name = name;
        this.count = 0;
        this.stas = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "Thread name : " + name + "; count : " + count);
        count++;
        stas.add(String.format("Thread %d : %s at %s", thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public String getStas(){
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> stringIterator = this.stas.iterator();
        while (stringIterator.hasNext()){
            stringBuffer.append(stringIterator.next());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}


