package by.it.rojas.jd08;

abstract class Var  implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " +this+ " + " +other+ " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " +this+ " - " +other+ " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " +this+ " * " +other+ " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " +this+ " / " +other+ " невозможно");
        return null;
    }
}
