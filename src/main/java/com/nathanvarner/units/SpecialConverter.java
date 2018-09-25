package com.nathanvarner.units;

/**
 * This class is designed to convert between different types of units. For example, converting between angular velocity
 * and linear velocity given a known distance.
 */
public class SpecialConverter {
    private Unit mUnit1;
    private Unit mUnit2;

    private double mXUnit1;
    private double mXUnit2;

    /**
     * Create a new special converter.
     * @param unit1 One of the units that can be converted between.
     * @param unit2 The other unit that can be converted between.
     * @param xUnit1 Some number of unit1
     * @param xUnit2 The number of unit2 that is equal to unit1
     */
    public SpecialConverter(Unit unit1, Unit unit2, double xUnit1, double xUnit2) {
        mUnit1 = unit1;
        mUnit2 = unit2;

        mXUnit1 = xUnit1;
        mXUnit2 = xUnit2;
    }

    /**
     * Convert between units of the same type as the original units.
     * @param from The unit to convert from.
     * @param to The unit to convert to.
     * @param value The value in unit from.
     * @return The value in unit to.
     */
    public double convert(Unit from, Unit to, double value) {
        // Important note: you can compare references because the reference should be the same
        if (from.getBaseUnit() == mUnit1.getBaseUnit() && to.getBaseUnit() == mUnit2.getBaseUnit()) {
            return mUnit2.to(from.to(value, mUnit1) * mXUnit2 / mXUnit1, to);
        } else if (from.getBaseUnit() == mUnit2.getBaseUnit() && to.getBaseUnit() == mUnit1.getBaseUnit()) {
            return mUnit1.to(from.to(value, mUnit2) * mXUnit1 / mXUnit2, to);
        } else {
            throw new IllegalArgumentException("Units do not share base units.");
        }
    }
}
