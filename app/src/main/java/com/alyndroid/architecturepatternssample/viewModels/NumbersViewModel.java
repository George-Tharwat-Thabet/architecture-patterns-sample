package com.alyndroid.architecturepatternssample.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternssample.models.NumberModel;

public class NumbersViewModel extends ViewModel {

    // MutableLiveData is a LiveData subclass that provides real-time observable data updates for a responsive UI in the MVVM architecture.
    public MutableLiveData<String> mutableNumLiveData = new MutableLiveData<>();

    // Returns a new NumberModel instance with values 4 and 2 for providing data to the View layer.
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }

    // This method makes logic for multiplying the first number by the second number and displaying it in MutableLiveData to be updated in real time.
    public void getMulNumResult() {
        int numbersMul = getNumbers().getFirstNum() * getNumbers().getSecondNum();
        String sNumberMul = String.valueOf(numbersMul);
        mutableNumLiveData.setValue(sNumberMul);
    }
}