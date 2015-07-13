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
