package by.it.zlotnikova.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        this.value = stringToVector(strVector);
    }

    private static double[] stringToVector(String str) {
        str = str.replaceAll("[^0-9\\.]+", " ");
        str = str.trim();
        String[] strArray = str.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(this.value, this.value.length);
            double addend = ((Scalar) other).getValue();
            for (int i = 0; i < sum.length; i++) {
                sum[i] += addend;
            }
            return new Vector(sum);
        } else {
            if (other instanceof Vector) {
                double[] sum = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < sum.length; i++) {
                    sum[i] += ((Vector) other).value[i];
                }
                return new Vector(sum);
            } else return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            double subtrahend = ((Scalar) other).getValue();
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= subtrahend;
            }
            return new Vector(sub);
        } else {
            if (other instanceof Vector) {
                double[] sub = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < sub.length; i++) {
                    sub[i] -= ((Vector) other).value[i];
                }
                return new Vector(sub);
            } else return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] mul = Arrays.copyOf(this.value, this.value.length);
            double multiplier = ((Scalar) other).getValue();
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= multiplier;
            }
            return new Vector(mul);
        } else {
            if (other instanceof Vector) {
                double[] mult1 = Arrays.copyOf(this.value, this.value.length);
                double sum = 0;
                for (int i = 0; i < mult1.length; i++) {
                    mult1[i] *= ((Vector) other).value[i];
                    sum += mult1[i];
                }
                return new Scalar(sum);
            } else return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] div = Arrays.copyOf(this.value, this.value.length);
            double divider = ((Scalar) other).getValue();
            for (int i = 0; i < div.length; i++) {
                div[i] /= divider;
            }
            return new Vector(div);
        } else return super.div(other);
    }
}


