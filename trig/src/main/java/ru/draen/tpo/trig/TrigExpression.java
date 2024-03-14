package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;
import static java.lang.Math.pow;

public class TrigExpression implements AppFunction {
    private final Sin sin = new Sin();
    private final Cos cos = new Cos();
    private final Tan tan = new Tan();
    private final Cot cot = new Cot();
    private final Csc csc = new Csc();
    private final Sec sec = new Sec();

    @Override
    public double calculate(double x, double eps) {
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

}
