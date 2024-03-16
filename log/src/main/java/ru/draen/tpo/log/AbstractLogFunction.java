package ru.draen.tpo.log;

import ru.draen.tpo.core.AbstractAppFunction;

public abstract class AbstractLogFunction extends AbstractAppFunction {
    @Override
    public boolean validateDomain(double x, double eps) {
        return x >= 0.0;
    }

}
