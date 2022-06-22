import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Storage {
    public Semaphore access = new Semaphore(1);
    public Semaphore notEmpty = new Semaphore(0);
    public Semaphore notFull;
    public ArrayList<String> products = new ArrayList<String>();
    public Storage(int size){
        this.notFull = new Semaphore(size);
    }
}
