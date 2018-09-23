package com.nathanvarner.units;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {
    @Test
    public void toBaseUnit() {
        Unit meter = new Unit(null, 1, 1, "m");
        Unit millimeter = new Unit(meter, 1, 1000, "mm");

        assertEquals(0, millimeter.toBaseUnit(0), 0.001);
        assertEquals(-0.005, millimeter.toBaseUnit(-5), 0.001);
        assertEquals(0.0002, millimeter.toBaseUnit(0.2), 0.001);

        assertEquals(6, meter.toBaseUnit(6), 0.001);
    }

    @Test
    public void fromBaseUnit() {
        Unit meter = new Unit(null, 1, 1, "m");
        Unit millimeter = new Unit(meter, 1, 1000, "mm");

        assertEquals(0, millimeter.fromBaseUnit(0), 0.001);
        assertEquals(-5000, millimeter.fromBaseUnit(-5), 0.001);
        assertEquals(200, millimeter.fromBaseUnit(0.2), 0.001);

        assertEquals(6, meter.fromBaseUnit(6), 0.001);
    }

    @Test
    public void to() {
        Unit meter = new Unit(null, 1, 1, "m");
        Unit kilometer = new Unit(meter, 1000, 1, "km");
        Unit millimeter = new Unit(meter, 1, 1000, "mm");

        assertEquals(0, millimeter.to(0, kilometer), 0.001);
        assertEquals(-0.005, millimeter.to(-5, meter), 0.001);
        assertEquals(200000, kilometer.to(0.2, millimeter), 0.001);
        assertEquals(0.0002, meter.to(0.2, kilometer), 0.001);

        assertEquals(6, meter.to(6, meter), 0.001);
    }

    @Test
    public void numberAsString() {
        Unit meter = new Unit(null, 1, 1, "m");

        assertEquals("0 m", meter.numberAsString(0));
        assertEquals("54 m", meter.numberAsString(54));
        assertEquals("2.6 m", meter.numberAsString(2.6));
        assertEquals("-765 m", meter.numberAsString(-765));
    }
}
