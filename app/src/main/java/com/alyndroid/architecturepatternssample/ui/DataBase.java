package com.alyndroid.architecturepatternssample.ui;

import com.alyndroid.architecturepatternssample.models.NumberModel;

public class DataBase {

    NumbersInterface numbersInterface;

    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }

    public DataBase(NumbersInterface numbersInterface) {
        this.numbersInterface = numbersInterface;
    }

    // This method to get div data result
    public void getDivNumResult() {
        numbersInterface.onGetDivNumber(String.valueOf(getNumbers().getFirstNum() / getNumbers().getSecondNum()));
    }
}
