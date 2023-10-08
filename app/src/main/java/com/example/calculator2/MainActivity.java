package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_0=findViewById(R.id.button_0);
        Button button_1=findViewById(R.id.button_1);
        Button button_2=findViewById(R.id.button_2);
        Button button_3=findViewById(R.id.button_3);
        Button button_4=findViewById(R.id.button_4);
        Button button_5=findViewById(R.id.button_5);
        Button button_6=findViewById(R.id.button_6);
        Button button_7=findViewById(R.id.button_7);
        Button button_8=findViewById(R.id.button_8);
        Button button_9=findViewById(R.id.button_9);

        Button button_on=findViewById(R.id.button_on);
        Button button_off=findViewById(R.id.button_off);
        Button button_ac=findViewById(R.id.button_ac);
        Button button_del=findViewById(R.id.button_del);
        Button button_add=findViewById(R.id.button_add);
        Button button_divide=findViewById(R.id.button_divide);
        Button button_multiply=findViewById(R.id.button_multiply);
        Button button_sub=findViewById(R.id.button_sub);
        Button button_equal=findViewById(R.id.button_equal);
        Button button_dot=findViewById(R.id.button_dot);

        TextView result=findViewById(R.id.result);

        button_ac.setOnClickListener(v -> {
            firstNum=0;
            result.setText("0");
        });

        button_off.setOnClickListener(v ->result.setVisibility(View.GONE) );
        button_on.setOnClickListener(v ->{
            result.setVisibility(View.VISIBLE);
            result.setText("0");
        } );
        ArrayList<Button> buttons=new ArrayList<>();
        buttons.add(button_0);
        buttons.add(button_1);
        buttons.add(button_2);
        buttons.add(button_3);
        buttons.add(button_4);
        buttons.add(button_5);
        buttons.add(button_6);
        buttons.add(button_7);
        buttons.add(button_8);
        buttons.add(button_9);
        for(Button b:buttons){
            b.setOnClickListener(v -> {
                if(!result.getText().toString().equals("0")){
                    result.setText(result.getText().toString()+ b.getText().toString());
                }else{
                    result.setText(b.getText().toString());
                }
            });
        }
        ArrayList<Button> opers=new ArrayList<>();
        opers.add(button_divide);
        opers.add(button_multiply);
        opers.add(button_add);
        opers.add(button_sub);
        for(Button b:opers){
            b.setOnClickListener(v -> {
                firstNum=Double.parseDouble(result.getText().toString());
                operation=b.getText().toString();
                result.setText("0");
            });
        }
        button_del.setOnClickListener(v -> {
            String num=result.getText().toString();
            if(num.length()>1){
                result.setText(num.substring(0,num.length()-1));
            }else if(num.length()==1 && !num.equals("0")){
                result.setText("0");
            }
        });

       button_dot.setOnClickListener(v -> {
           if(!result.getText().toString().contains(".")){
               result.setText(result.getText().toString()+".");
           }
       });
       button_equal.setOnClickListener(v -> {
           double secondNum=Double.parseDouble(result.getText().toString());
           double solution;
           switch (operation){
               case "/":
                   solution=firstNum/secondNum;
                   break;
               case "*":
                   solution=firstNum*secondNum;
                   break;
               case "+":
                   solution=firstNum+secondNum;
                   break;
               case "-":
                   solution=firstNum-secondNum;
                   break;
               default:
                   solution=firstNum+secondNum;
           }
           result.setText(String.valueOf(solution));
           firstNum=solution;
       });
    }
}