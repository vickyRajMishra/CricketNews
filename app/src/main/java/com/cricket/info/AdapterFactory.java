package com.cricket.info;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AdapterFactory {

    public ArrayAdapter<LengthUnit> getArrayAdapterForLength(Context context){
        return new ArrayAdapter<LengthUnit>(context, android.R.layout.simple_spinner_item, LengthUnit.values());
    }
    public ArrayAdapter<MassUnit> getArrayAdapterForMass(Context context){
        return new ArrayAdapter<MassUnit>(context, android.R.layout.simple_spinner_item, MassUnit.values());
    }
    public ArrayAdapter<TimeUnit> getArrayAdapterForTime(Context context){
        return new ArrayAdapter<TimeUnit>(context, android.R.layout.simple_spinner_item, TimeUnit.values());
    }
}
