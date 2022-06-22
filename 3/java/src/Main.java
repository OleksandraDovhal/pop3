import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Scanner sc = new Scanner(System.in);
        System.out.println("Місткість сховища: ");
        int storageSize = sc.nextInt();
        System.out.println("Кількість елементів для кожного виробника та споживача, які потрібно обробити: ");
        int needProductQuantity = sc.nextInt();

        Storage st = new Storage(storageSize);

        for(int i = 0; i < random.nextInt(3, 10); i++){
            new Thread(new Producer("Producer " + i, needProductQuantity, st)).start();
            new Thread(new Consumer("Consumer " + i, needProductQuantity, st)).start();
        }
    }
}
