package inpackage; // package name fixed

interface Pet {
    void getName();
    void setName(String name);
    void play();
}

class Animal {
    protected int legs;

    public void walks() {
        System.out.println("It walks");
    }

    public void eat() {
        System.out.println("It eats");
    }
}

class Cat extends Animal implements Pet {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
        System.out.println("This is a Cat");
    }

    public void getName() {
        System.out.println("The name of the cat is " + name);
    }

    public void setName(String newname) {
        name = newname;
    }

    public void play() {
        System.out.println("Cat plays");
    }
}

class Fish extends Animal implements Pet {
    String name;

    public Fish(String name) {
        this.name = name;
    }

    public Fish() {
        System.out.println("This is a Fish");
    }

    public void getName() {
        System.out.println("The name of the Fish is " + name);
    }

    public void setName(String newname) {
        name = newname;
    }

    public void play() {
        System.out.println("Fish plays");
    }

    @Override
    public void walks() {
        System.out.println("It doesn't walk");
    }
}

class Spider extends Animal {
    String name;

    public Spider(String name) {
        this.name = name;
    }

    public Spider() {
        System.out.println("This is a Spider");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.setName("Molly");
        c.getName();
        c.play();
        c.eat();
        c.walks();

        Fish f = new Fish();
        f.setName("Pookie");
        f.getName();
        f.play();
        f.walks();
        f.eat();

        Spider s = new Spider();
        s.eat();
        s.walks();
    }
}
