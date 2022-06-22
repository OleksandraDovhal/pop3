public class Consumer implements Runnable{
    public String name;
    private Storage st;
    private int needProductQuantity;

    public Consumer(String name, int needProductQuantity, Storage st){
        this.name = name;
        this.needProductQuantity = needProductQuantity;
        this.st = st;
    }

    @Override
    public void run() {
        for(int i = 0; i < needProductQuantity; i++) {
            try {
                st.notEmpty.acquire();
                st.access.acquire();
                st.products.remove(0);
                System.out.println(this.name + " забрав товар. В сховищі " + st.products.size() + " продуктів.");
                st.notFull.release();
                st.access.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
