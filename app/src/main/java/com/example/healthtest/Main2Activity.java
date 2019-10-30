package com.example.healthtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class Main2Activity extends AppCompatActivity {

    int a;
    double age_2,tall_2,weight_2;
    double BMI,bone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = (Button)findViewById(R.id.button_2);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                EditText tall_1 = findViewById(R.id.tall);
                String height = tall_1.getText().toString();
                tall_2 = Double.parseDouble(height);
                intent.putExtra("height_data",height);
                EditText weight_1 = findViewById(R.id.weight);
                String weight = weight_1.getText().toString();
                weight_2 = Double.parseDouble(weight);
                intent.putExtra("weight_data",weight);
                EditText age_1 = findViewById(R.id.age);
                String age = age_1.getText().toString();
                intent.putExtra("age_data",age);
                age_2 = Double.parseDouble(age);
                EditText gender_1 = findViewById(R.id.gender);
                String gender = gender_1.getText().toString();
                intent.putExtra("gender_data",gender);
                BMI = weight_2/(tall_2*tall_2);
                BigDecimal b = new BigDecimal(BMI);
                BMI = b.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
                String str = ""+BMI;
                intent.putExtra("BMI_data",str);
                bone = (weight_2-age_2)*0.2;
                BigDecimal b1 = new BigDecimal(bone);
                bone = b1.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
                String bone_1 = ""+bone;
                intent.putExtra("bone_data",bone_1);

                startActivity(intent);
            }
        });
    }
}
