package by.it.boytsov.jd01_08;

public abstract class Var implements Operation
{
    @Override
    public String toString()
    {
        return "Класс Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Operation " + this + " + " + other + "unavailable\n");
        return null;
    }
    @Override
    public Var sub(Var other) {
        System.out.println("Operation " + this + " - " + other + "unavailable\n");
        return null;
    }
    @Override
    public Var mul(Var other) {
        System.out.println("Operation " + this + " * " + other + "unavailable\n");
        return null;
    }
    @Override
    public Var div(Var other) {
        System.out.println("Operation " + this + " / " + other + "unavailable\n");
        return null;
    }
}
