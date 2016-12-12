package jehronimo;

import java.util.Random;


class MainComponent implements InterfaceComponent {

    // Заклинание "Кислотная стрела"
    @Override
    public void spellNaming() {
        System.out.print("acid arrow");
    }

    @Override
    public void doDamage(int n) {
        final Random random = new Random();
        currentDamage += random.nextInt(n);
    }
    int currentDamage = 10;
}

abstract class Modificator implements InterfaceComponent {
    protected InterfaceComponent component;

    public Modificator(InterfaceComponent c) {
        component = c;
    }

    @Override
    public void spellNaming() {
        component.spellNaming();
    }

    public void newOperation() {
        System.out.println("Do Nothing");
    }
}

class PreModificator extends Modificator {

    public PreModificator(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void spellNaming() {
        System.out.print("devastating ");
        super.spellNaming();
    }

    @Override
    public void doDamage(int n) {
        component.doDamage(n + 10);
    }

    @Override
    public void newOperation() {
        System.out.println("New pre-operation");
    }
}

class PostModificator extends Modificator {

    public PostModificator(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void spellNaming() {
        super.spellNaming();
        System.out.println(" of extended burn!");
    }

    @Override
    public void doDamage(int n) {
        component.doDamage(n*3);
    }

    @Override
    public void newOperation() {
        System.out.println("New post-operation");
    }
}

class NameModificator extends Modificator {

    public NameModificator(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void spellNaming() {
        System.out.print("Bigby's ");
        super.spellNaming();
    }

    @Override
    public void doDamage(int n) {
        component.doDamage(n);
    }

    @Override
    public void newOperation() {
        System.out.println("New name operation");
    }
}

class Main {

    public static void main (String... s) {
        MainComponent arrow = new MainComponent();
        Modificator c = new NameModificator(new PreModificator(new PostModificator(arrow)));
        c.spellNaming();
        c.doDamage(9);
        System.out.println("The damage is " + arrow.currentDamage + " points!");
    }
}
