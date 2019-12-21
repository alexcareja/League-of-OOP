package visitor;

import map.LandType;

public interface Visitable {
    /**
     * @param v - eroul care provoaca daune
     * @param land - taramul pe care se desfasoara lupta
     */
    void accept(Visitor v, LandType land);
}
