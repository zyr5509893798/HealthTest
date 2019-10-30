package com.example.healthtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        final String height = intent.getStringExtra("height_data");
        final String weight = intent.getStringExtra("weight_data");
        final String BMI = intent.getStringExtra("BMI_data");
        String gender = intent.getStringExtra("gender_data");
        final String bone = intent.getStringExtra("bone_data");
        String age = intent.getStringExtra("age_data");

        double age_double = Double.valueOf(age.toString()); //str转double
        double weight_double = Double.valueOf(weight.toString()); //str转double
        double height_double = Double.valueOf(height.toString()); //str转double
        double height_c = height_double * 100;

        TextView tv = findViewById(R.id.BMI_3);
        tv.setText(BMI);
        final int BMI_mark;
        final String BMI_level,BMI_advise;
        double BMI_double = Double.valueOf(BMI.toString());
        if(BMI_double >= 10 && BMI_double <= 18.5){
            BMI_mark = 75;
            BMI_level = " 过轻 ";
            BMI_advise = "建议多吃肉类和蛋类，补充脂肪";
        }else if (BMI_double > 18.5 && BMI_double <= 24){
            BMI_mark = 100;
            BMI_level = " 正常 ";
            BMI_advise = "继续保持！";
        }else if (BMI_double > 24 && BMI_double <= 28){
            BMI_mark = 80;
            BMI_level = " 超重 ";
            BMI_advise = "建议减少肉类的摄入量，加强锻炼";
        }else if (BMI_double > 28 && BMI_double <= 35){
            BMI_mark = 60;
            BMI_level = " 肥胖 ";
            BMI_advise = "建议多吃蔬菜，健康饮食，加强锻炼";
        }else{
            BMI_mark = 0;
            BMI_level = " 无 ";
            BMI_advise = "您输入的数据有误，无法评估！";
        }
        TextView tv2 = findViewById(R.id.BMI_31);
        tv2.setText(BMI_level);
        TextView tv3 = findViewById(R.id.BMI_32);
        tv3.setText(BMI_advise);


        //下面是第三页的骨质的判断和输出
        int bone_mark;
        final String bone_level,bone_advise;
        double bone_double = Double.valueOf(bone.toString());
        if(bone_double < -4){
            bone_mark = 50;
            bone_level = " 风险高 ";
            bone_advise = "强烈建议补钙";
        }else if (bone_double >= -4 && bone_double <= -1){
            bone_mark = 70;
            bone_level = " 中度风险 ";
            bone_advise = "建议补钙";
        }else{
            bone_mark = 100;
            bone_level = " 风险低 ";
            bone_advise = "继续保持！";
        }
        TextView tv4 = findViewById(R.id.bone_level);
        tv4.setText(bone_level);
        TextView tv5 = findViewById(R.id.bone_advise);
        tv5.setText(bone_advise);

        //男女在这里分开写
        String gender_man = "男";
        String gender_woman = "女";

        final String fat_s;
        double fat_double = 0;
        final String fat;
        final int fat_mark;
        final String fat_level;
        String fat_advise;

        final String muscle_n;//xxxx_n均代表百分数
        double muscle_double = 0;
        final String muscle;
        final int muscle_mark;
        final String muscle_level;
        String muscle_advise;

        double water_double = 0;
        final String water_n;
        final String water;
        final int water_mark;
        final String water_level;
        String water_advise;

        double meta_double = 0;
        final String meta_n;
        final int meta_mark;
        final String meta_level;
        String meta_advise;

        final String height_level;
        double weight_right;
        final String weight_level;

        //以下是女的部分
        if (gender.equals(gender_woman)){
            //身高
            if (height_c < 150){
                height_level = "偏低";
            }else{
                height_level = "标准";
            }
            //体重
            weight_right = (height_c - 70) * 0.6;
            if (weight_double > weight_right * 1.2){
                weight_level = "肥胖";
            }else if (weight_double > weight_right * 1.1 && weight_double <= weight_right * 1.2){
                weight_level = "偏重";
            }else if(weight_double > weight_right * 0.9 && weight_double <= weight_right * 1.1){
                weight_level = "正常";
            }else if(weight_double >= weight_right * 0.8 && weight_double <= weight_right * 0.9){
                weight_level = "偏轻";
            }else{
                weight_level = "营养不良";
            }
            //体脂率
            fat_double = (1.2*BMI_double+0.23*age_double-5.4)*0.01;
            fat_double = (double)Math.round(fat_double*1000)/1000;//保留三位小数
            if(fat_double > 0.1 && fat_double <= 0.2){
                fat_mark = 70;
                fat_level = " 过瘦 ";
                fat_advise = "建议多吃肉类，增加体重";
            }else if (fat_double > 0.2 && fat_double <= 0.3){
                fat_mark = 100;
                fat_level = " 正常 ";
                fat_advise = "继续保持！";
            }else if (fat_double > 0.3 && fat_double <= 0.45){
                fat_mark = 70;
                fat_level = " 超重 ";
                fat_advise = "建议加强锻炼";
            }else{
                fat_mark = 0;
                fat_level = " 无 ";
                fat_advise = "您输入的数据有误，无法评估！";
            }

            //肌肉率
            muscle_double = 56/(weight_double*2);
            muscle_double = (double)Math.round(muscle_double*1000)/1000;//
            if(muscle_double <= 0.55){
                muscle_mark = 60;
                muscle_level = " 偏低 ";
                muscle_advise = "建议多锻炼";
            }else if (muscle_double >= 0.55 && muscle_double <= 0.6){
                muscle_mark = 80;
                muscle_level = " 正常 ";
                muscle_advise = "继续保持！";
            }else{
                muscle_mark = 100;
                muscle_level = " 优秀 ";
                muscle_advise = "非常优秀！";
            }
            //水分率
            water_double = muscle_double*1.3;
            water_double = (double)Math.round(water_double*1000)/1000;
            if(water_double <0.70){
                water_mark = 70;
                water_level = " 偏低 ";
                water_advise = "建议多喝水";
            }else if (water_double >= 0.70 && water_double <= 0.80){
                water_mark = 100;
                water_level = " 正常 ";
                water_advise = "继续保持！";
            }else{
                water_mark = 70;
                water_level = " 偏高 ";
                water_advise = "建议减少水分摄入";
            }
            //基础代谢
            meta_double = (9.6 * weight_double) + (1.8 * height_double * 100) - (4.7 * age_double) + 655;
            meta_double = (double)Math.round(meta_double*1000)/1000;
            if(meta_double < 1100){
                meta_mark = 70;
                meta_level = " 偏低 ";
                meta_advise = "建议多运动、规律作息促进新陈代谢";
            }else if (meta_double >= 1100 && meta_double <= 1500){
                meta_mark = 100;
                meta_level = " 正常 ";
                meta_advise = "继续保持！";
            }else{
                meta_mark = 70;
                meta_level = " 偏高 ";
                meta_advise = "建议多吃一些肉类，适当运动";
            }

        }


        //男的部分
        else if (gender.equals(gender_man)) {
            //身高
            if (height_c < 160){
                height_level = "偏低";
            }else{
                height_level = "标准";
            }
            //体重
            weight_right = (height_c - 80) * 0.7;
            if (weight_double > weight_right * 1.2){
                weight_level = "肥胖";
            }else if (weight_double > weight_right * 1.1 && weight_double <= weight_right * 1.2){
                weight_level = "偏重";
            }else if(weight_double > weight_right * 0.9 && weight_double <= weight_right * 1.1){
                weight_level = "正常";
            }else if(weight_double >= weight_right * 0.8 && weight_double <= weight_right * 0.9){
                weight_level = "偏轻";
            }else{
                weight_level = "营养不良";
            }
            //体脂率
            fat_double = (1.2 * BMI_double + 0.23 * age_double - 5.4 - 10.8) * 0.01;
            BigDecimal b2 = new BigDecimal(fat_double);
            fat_double = b2.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (fat_double > 0.08 && fat_double <= 0.15) {
                fat_mark = 70;
                fat_level = " 过瘦 ";
                fat_advise = "建议多吃肉类，增加体重";
            } else if (fat_double > 0.15 && fat_double <= 0.25) {
                fat_mark = 100;
                fat_level = " 正常 ";
                fat_advise = "继续保持！";
            } else if (fat_double > 0.25 && fat_double <= 0.35) {
                fat_mark = 70;
                fat_level = " 超重 ";
                fat_advise = "建议加强锻炼";
            } else {
                fat_mark = 0;
                fat_level = " 无 ";
                fat_advise = "您输入的数据有误，无法评估！";
            }

            //肌肉率
            muscle_double = 78/(weight_double*2);
            muscle_double = (double)Math.round(muscle_double*1000)/1000;//
            if(muscle_double <= 0.60){
                muscle_mark = 60;
                muscle_level = " 偏低 ";
                muscle_advise = "建议多锻炼";
            }else if (muscle_double >= 0.60 && muscle_double <= 0.65){
                muscle_mark = 80;
                muscle_level = " 正常 ";
                muscle_advise = "继续保持！";
            }else{
                muscle_mark = 100;
                muscle_level = " 优秀 ";
                muscle_advise = "非常优秀！";
            }
            //水分率
            water_double = muscle_double*1.2;
            water_double = (double)Math.round(water_double*1000)/1000;
            if(water_double <0.70){
                water_mark = 70;
                water_level = " 偏低 ";
                water_advise = "建议多喝水";
            }else if (water_double >= 0.70 && water_double <= 0.80){
                water_mark = 100;
                water_level = " 正常 ";
                water_advise = "继续保持！";
            }else{
                water_mark = 70;
                water_level = " 偏高 ";
                water_advise = "建议减少水分摄入";
            }
            //基础代谢
            meta_double = (9.6 * weight_double) + (1.8 * height_double * 100) - (4.7 * age_double) + 655;
            meta_double = (double)Math.round(meta_double*1000)/1000;
            if(meta_double < 1300){
                meta_mark = 70;
                meta_level = " 偏低 ";
                meta_advise = "建议多运动、规律作息促进新陈代谢";
            }else if (meta_double >= 1300 && meta_double <= 1900){
                meta_mark = 100;
                meta_level = " 正常 ";
                meta_advise = "继续保持！";
            }else{
                meta_mark = 70;
                meta_level = " 偏高 ";
                meta_advise = "建议多吃一些肉类，适当运动";
            }
        }
        //啥都不是的部分
        else if (!gender.equals(gender_woman)&&!gender.equals(gender_man)){
            fat_mark = 0;
            fat_level = "";
            fat_advise = "请您在性别一栏输入汉字：“男”或“女”，否则将无法检测";
            muscle_mark = 0;
            muscle_level = "";
            muscle_advise = "";
            water_mark = 0;
            water_level = "";
            water_advise = "";
            meta_mark = 0;
            meta_level = "";
            meta_advise = "";
            height_level = "";
            weight_level = "";
        }else{
            fat_mark = 0;
            fat_level = "无";
            fat_advise = "您输入的数据有误，无法评估！";
            muscle_mark = 0;
            muscle_level = "";
            muscle_advise = "";
            water_mark = 0;
            water_level = "";
            water_advise = "";
            meta_mark = 0;
            meta_level = "";
            meta_advise = "";
            height_level = "";
            weight_level = "";
        }


        //下面是第三页的输出代码
        //体脂率
        final String fat_n;
        fat = ""+fat_double;
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        fat_n = numberFormat.format(fat_double);
        TextView tvfat1 = findViewById(R.id.fat_level_1);
        tvfat1.setText(fat_level);
        TextView tvfat2 = findViewById(R.id.fat_advise_1);
        tvfat2.setText(fat_advise);
        //肌肉率
        muscle = ""+muscle_double;
        NumberFormat numberFormat1 = NumberFormat.getPercentInstance();
        muscle_n = numberFormat1.format(muscle_double);
        TextView tvmuscle1 = findViewById(R.id.muscle_level_1);
        tvmuscle1.setText(muscle_level);
        TextView tvmuscle2 = findViewById(R.id.muscle_advise_1);
        tvmuscle2.setText(muscle_advise);
        //水分率
        NumberFormat numberFormat2 = NumberFormat.getPercentInstance();
        water_n = numberFormat2.format(water_double);
        TextView tvwater1 = findViewById(R.id.water_level_1);
        tvwater1.setText(water_level);
        TextView tvwater2 = findViewById(R.id.water_advise_1);
        tvwater2.setText(water_advise);
        //基础代谢
        meta_n = "" + meta_double;
        TextView tvmeta1 = findViewById(R.id.meta_level_1);
        tvmeta1.setText(meta_level);
        TextView tvmeta2 = findViewById(R.id.meta_advise_1);
        tvmeta2.setText(meta_advise);


        //算总分
        final String level;
        double mark_3 =  (BMI_mark * 0.5 + bone_mark * 0.1 + fat_mark * 0.1 + water_mark * 0.1 + meta_mark * 0.1 + muscle_mark * 0.1);
        final String mark = "" + mark_3;
        if (mark_3 > 90){
            level= "优秀";
        }else if (mark_3 > 80 && mark_3 <= 90){
            level = "良好";
        }else if (mark_3 > 60 && mark_3 <= 80){
            level = "一般";
        }else{
            level = "较差";
        }


        Button btn1 = (Button)findViewById(R.id.button_3);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                intent.putExtra("height_data",height);
                intent.putExtra("weight_data",weight);
                intent.putExtra("BMI_mark_data",BMI_mark);
                intent.putExtra("BMI_data",BMI);
                intent.putExtra("BMI_level_data",BMI_level);
                intent.putExtra("bone_data",bone);
                intent.putExtra("bone_level_data",bone_level);
                intent.putExtra("fat_level_data",fat_level);
                intent.putExtra("fat_mark_data",fat_mark);
                intent.putExtra("fat_n_data",fat_n);
                intent.putExtra("muscle_n_data",muscle_n);
                intent.putExtra("muscle_level_data",muscle_level);
                intent.putExtra("water_n_data",water_n);
                intent.putExtra("water_level_data",water_level);
                intent.putExtra("meta_n_data",meta_n);
                intent.putExtra("meta_level_data",meta_level);
                intent.putExtra("height_level_data",height_level);
                intent.putExtra("weight_level_data",weight_level);
                intent.putExtra("level_data",level);
                intent.putExtra("mark_data",mark);



                startActivity(intent);
            }
        });
        Button btn2 = (Button)findViewById(R.id.button_4);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
