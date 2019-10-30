package com.example.healthtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Double.valueOf;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String height = intent.getStringExtra("height_data");
        String weight = intent.getStringExtra("weight_data");
        String BMI = intent.getStringExtra("BMI_data");;
        String BMI_level = intent.getStringExtra("BMI_level_data");
        String BMI_mark = intent.getStringExtra("BMI_mark_data");
        String bone = intent.getStringExtra("bone_data");
        String bone_level = intent.getStringExtra("bone_level_data");
        String fat_level = intent.getStringExtra("fat_level_data");
        String fat_mark = intent.getStringExtra("fat_mark_data");
        String fat_n = intent.getStringExtra("fat_n_data");
        String muscle_n = intent.getStringExtra("muscle_n_data");
        String muscle_level = intent.getStringExtra("muscle_level_data");
        String water_n = intent.getStringExtra("water_n_data");
        String water_level = intent.getStringExtra("water_level_data");
        String meta_n = intent.getStringExtra("meta_n_data");
        String meta_level = intent.getStringExtra("meta_level_data");
        String height_level = intent.getStringExtra("height_level_data");
        String weight_level = intent.getStringExtra("weight_level_data");
        String level = intent.getStringExtra("level_data");
        String mark = intent.getStringExtra("mark_data");





        TextView tv5 = findViewById(R.id.height_1);
        tv5.setText(height);
        TextView tv6 = findViewById(R.id.weight_1);
        tv6.setText(weight);
        TextView tv7 = findViewById(R.id.BMI_1);
        tv7.setText(BMI);
        TextView tv8 = findViewById(R.id.BMI_level);
        tv8.setText(BMI_level);
        TextView tv9 = findViewById(R.id.bone);
        tv9.setText(bone);
        TextView tv10 = findViewById(R.id.bone_level_1);
        tv10.setText(bone_level);
        TextView tv11 = findViewById(R.id.fat_1);
        tv11.setText(fat_n);
        TextView tv12 = findViewById(R.id.fat_level_a);
        tv12.setText(fat_level);
        TextView tv13 = findViewById(R.id.muscle_1);
        tv13.setText(muscle_n);
        TextView tv14 = findViewById(R.id.muscle_level_a);
        tv14.setText(muscle_level);
        TextView tv15 = findViewById(R.id.water_1);
        tv15.setText(water_n);
        TextView tv16 = findViewById(R.id.water_level_a);
        tv16.setText(water_level);
        TextView tv17 = findViewById(R.id.meta_1);
        tv17.setText(meta_n);
        TextView tv18 = findViewById(R.id.meta_level_a);
        tv18.setText(meta_level);
        TextView tv19 = findViewById(R.id.height_level);
        tv19.setText(height_level);
        TextView tv20 = findViewById(R.id.weight_level);
        tv20.setText(weight_level);
        TextView tv21 = findViewById(R.id.level);
        tv21.setText(level);
        TextView tv22 = findViewById(R.id.mark);
        tv22.setText(mark);




        Button btn = (Button)findViewById(R.id.button_1);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
