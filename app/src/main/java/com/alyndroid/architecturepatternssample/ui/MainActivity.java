package com.alyndroid.architecturepatternssample.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alyndroid.architecturepatternssample.R;
import com.alyndroid.architecturepatternssample.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternssample.viewModels.NumbersViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumbersInterface {

    // Plus and div variables
    TextView plus_result_textView, div_result_textView;
    Button plus_button, div_button;

    // Presenter and ViewModel files variables
    DataBase dataBase;
    NumbersViewModel numbersViewModel;

    // Data Binding variable
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Linking views
        plus_result_textView = findViewById(R.id.plus_result_textView);
        plus_button = findViewById(R.id.plus_button);
        div_result_textView = findViewById(R.id.div_result_textView);
        div_button = findViewById(R.id.div_button);

        plus_button.setOnClickListener(this);
        div_button.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);
        dataBase = new DataBase(this);

        // Linking views with activity by Data Binding
        numbersViewModel = ViewModelProviders.of(this).get(NumbersViewModel.class);
        numbersViewModel.mutableNumLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.mulResultTextView.setText(s);
            }
        });
    }

    // This method to get plus data result from NumberModel.java
    public void getPlusNumResult() {
        int firstNum = dataBase.getNumbers().getFirstNum();
        int secondNum = dataBase.getNumbers().getSecondNum();
        int plusNumResult = firstNum + secondNum;
        String sPlusNumResult = String.valueOf(plusNumResult);
        plus_result_textView.setText(sPlusNumResult);
        plus_result_textView.setTextSize(30);
    }

    // When user click on plus_button will get plus number data
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.plus_button) {
            getPlusNumResult();
        }
        else if(view.getId() == R.id.div_button) {
            dataBase.getDivNumResult();
        }
        else if(view.getId() == R.id.mul_button) {
            numbersViewModel.getMulNumResult();
        }
    }

    // Implement onGetDivNumber method from NumberInterface to call div of firstNum and secondNum
    @Override
    public void onGetDivNumber(String result) {
        div_result_textView.setText(result);
    }
}
