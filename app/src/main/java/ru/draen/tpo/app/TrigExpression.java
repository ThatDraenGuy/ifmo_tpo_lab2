package ru.draen.tpo.app;

import ru.draen.tpo.core.AbstractAppFunction;
import ru.draen.tpo.trig.Cos;
import ru.draen.tpo.trig.Cot;
import ru.draen.tpo.trig.Csc;
import ru.draen.tpo.trig.Sec;
import ru.draen.tpo.trig.Sin;
import ru.draen.tpo.trig.Tan;

import static java.lang.Math.pow;

public class TrigExpression extends AbstractAppFunction {
    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Csc csc;
    private final Sec sec;

    public TrigExpression() {
        this.sin = new Sin();
        this.cos = new Cos();
        this.tan = new Tan();
        this.cot = new Cot();
        this.csc = new Csc();
        this.sec = new Sec();
    }

    public TrigExpression(Sin sin, Cos cos, Tan tan, Cot cot, Csc csc, Sec sec) {
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.csc = csc;
        this.sec = sec;
    }

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);

        double sin = this.sin.calculate(x, eps);
        double cos = this.cos.calculate(x, eps);
        double tan = this.tan.calculate(x, eps);
        double cot = this.cot.calculate(x, eps);
        double csc = this.csc.calculate(x, eps);
        double sec = this.sec.calculate(x, eps);

        return pow(((pow((pow(
                (((((pow((((((sin - csc) + sec) / sec) - tan) / (csc / sec)), 2) + sin) - pow(tan, 3)) / (sec * cot))
                        + csc) + ((cos - pow((cot / cos), 2)) + (csc / ((cos - cos) + cos)))),
                3) + (((tan + pow(tan, 3)) / (csc - (cos * sec))) - (cos - sin))), 2)
                / (((csc * ((csc + cos) / sin)) * sec) + (cos - sin)))
                * (((sin / (sin / cos)) / pow((pow(pow((sin * tan), 3), 3) / cot), 2))
                        / (sin / (pow(tan, 2) - (tan * (pow(csc, 2) + pow((sec / (pow(sec, 2) - tan)), 2))))))),
                2);
    }

    @Override
    public boolean validateDomain(double x, double eps) {
        double tan = this.tan.calculate(x, eps);
        double csc = this.csc.calculate(x, eps);
        double sec = this.sec.calculate(x, eps);
        return Math.abs((pow(tan, 2) - (tan * (pow(csc, 2) + pow((sec / (pow(sec, 2) - tan)), 2))))) > eps
                && this.tan.validateDomain(x, eps) && this.cot.validateDomain(x, eps) && this.sec.validateDomain(x, eps)
                && this.csc.validateDomain(x, eps);
    }

}
