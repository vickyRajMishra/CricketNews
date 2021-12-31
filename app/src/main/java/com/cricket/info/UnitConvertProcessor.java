package com.cricket.info;

import java.util.HashMap;
import java.util.Map;

/*
Base unit for Length is KM
Base unit for Mass is KG
Base unit for Time is Day
 */
public class UnitConvertProcessor {
    public double convert(double value, String from, String to){
        try {
            if (length.containsKey(from) && length.containsKey(to)) {
                Double denominator = length.get(from);
                Double numerator = length.get(to);
                return value * (numerator / denominator);
            }
            else if(mass.containsKey(from) && mass.containsKey(to)){
                Double denominator = mass.get(from);
                Double numerator = mass.get(to);
                return value * (numerator / denominator);
            }
            else if(time.containsKey(from) && time.containsKey(to)){
                Double denominator = time.get(from);
                Double numerator = time.get(to);
                return value * (numerator / denominator);
            }
        }
        catch(Exception ignored){
        }
        return 0;
    }

    private static final Map<String, Double> length;
    static{
        length = new HashMap<>();
        length.put(LengthUnit.Kilometer.name(), 1.0);
        length.put(LengthUnit.Meter.name(), 1000.0);
        length.put(LengthUnit.Decimeter.name(), 10000.0);
        length.put(LengthUnit.Centimeter.name(), 100000.0);
        length.put(LengthUnit.Millimeter.name(), 1000000.0);
        length.put(LengthUnit.Micron.name(), 1000000000.0);
        length.put(LengthUnit.Nanometer.name(), 1000000000000.0);
    }

    private static final Map<String, Double> mass;
    static{
        mass = new HashMap<>();
        mass.put(MassUnit.Kilogram.name(), 1.0);
        mass.put(MassUnit.Gram.name(), 1000.0);
        mass.put(MassUnit.DeciGram.name(), 10000.0);
        mass.put(MassUnit.CentiGram.name(), 100000.0);
        mass.put(MassUnit.MilliGram.name(), 1000000.0);
        mass.put(MassUnit.MicroGram.name(), 1000000000.0);
        mass.put(MassUnit.NanoGram.name(), 1000000000000.0);
    }

    private static final Map<String, Double> time;
    static {
        time = new HashMap<>();
        time.put(TimeUnit.Day.name(), 1.0);
        time.put(TimeUnit.Hour.name(), 24.0);
        time.put(TimeUnit.Minute.name(), 1440.0);
        time.put(TimeUnit.Second.name(), 86440.0);
        time.put(TimeUnit.MilliSecond.name(), 86400000.0);
        time.put(TimeUnit.MicroSecond.name(), 86400000000.0);
        time.put(TimeUnit.NanoSecond.name(), 86400000000000.0);
        time.put(TimeUnit.PicoSecond.name(), 86400000000000000.0);
        time.put(TimeUnit.FemtoSecond.name(), 86400000000000000000.0);
    }
}
