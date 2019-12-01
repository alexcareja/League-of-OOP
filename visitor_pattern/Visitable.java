package visitor_pattern;

import map.LandType;

public interface Visitable {
    /**
     * @param v - eroul care provoaca daune
     * @param land - taramul pe care se desfasoara lupta
     */
    void takeDmg(Visitor v, LandType land);
}
