package sy;

class Shared {
    int number = 0;

    synchronized public void increment() {
        System.out.println("Increment Thread");
        for (int i = 0; i < 10; i++) {
            number++;
            System.out.println("Incremented: " + number);
        }
    }

    synchronized public void decrement() {
        System.out.println("Decrement Thread");
        for (int i = 0; i < 10; i++) {
            number--;
            System.out.println("Decremented: " + number);
        }
    }
}

class Thread1 extends Thread {
    Shared obj;

    Thread1(Shared object) {
        this.obj = object;
    }

    public void run() {
        obj.increment();
    }
}

class Thread2 extends Thread {
    Shared obj;

    Thread2(Shared object) {
        this.obj = object;
    }

    public void run() {
        obj.decrement();
    }
}

public class Main {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Thread1 t1 = new Thread1(shared);
        Thread2 t2 = new Thread2(shared);

        t1.start();
        t2.start();
    }
}
