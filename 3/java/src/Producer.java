public class Producer implements Runnable {
    public String name;
    private Storage st;
    private int needProductQuantity;

    public Producer(String name, int needProductQuantity, Storage st){
        this.name = name;
        this.needProductQuantity = needProductQuantity;
        this.st = st;
    }

    @Override
    public void run() {
        for(int i = 0; i < needProductQuantity; i++){
            try {
                st.notFull.acquire();
                st.access.acquire();
                st.products.add("Product");
                System.out.println(name + " додав товар. В сховищі " + st.products.size() + " продуктів.");
                st.notEmpty.release();
                st.access.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
