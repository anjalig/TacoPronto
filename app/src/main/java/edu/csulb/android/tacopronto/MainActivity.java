package edu.csulb.android.tacopronto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.telephony.SmsManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
Button send;
    RadioGroup rg, rgg;
    RadioButton rb, rbb;
    ArrayList<String> ar=new ArrayList<String>();
    String r1,r2;
    static int value=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=(Button)findViewById(R.id.button);
        rg=(RadioGroup) findViewById(R.id.rgs);
        rgg=(RadioGroup) findViewById(R.id.rgt);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsSend();
            }
        });
    }
    public void rbclick(View v)
    {
    int radiobuttonid=rg.getCheckedRadioButtonId();
    rb=(RadioButton)findViewById(radiobuttonid);
    r1=rb.getText().toString();
        if(radiobuttonid==R.id.radioButton2)
        {
            value=value+3;
        }
        else
        {
            value=value+1;
        }
    }
    public void rbclick1(View v)
    {
        int rb1=rgg.getCheckedRadioButtonId();
        rbb=(RadioButton)findViewById(rb1);
        r2=rbb.getText().toString();
        if(rb1==R.id.radioButton10){
            value=value+5;
        }
        else
            value=value+3;

    }
    public void selectItem(View view)
    {

        boolean checked=((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkBox3:
                if (checked)
                { ar.add("Beef");
                value=value+2;}
                else {
                    ar.remove("Beef");
                }break;
            case R.id.checkBox2:
                if (checked){
                    ar.add("Chicken");
                value=value+1;}
                else
                    ar.remove("Chicken");
                break;
            case R.id.checkBox:
                if (checked){
                    ar.add("White Fish");
                value=value+3;}
                else
                    ar.remove("White Fish");
                break;
            case R.id.checkBox15:
                if (checked){
                    ar.add("Cheese");
                value=value+4;}
                else
                    ar.remove("Cheese");
                break;
            case R.id.checkBox5:
                if (checked){
                    ar.add("Rice");
                    value=value+2;}

                else
                    ar.remove("Rice");
                break;
            case R.id.checkBox4:
                if (checked){
                    ar.add("Sea Food");
                    value=value+3;}
                else
                    ar.remove("Sea Food");
                break;
            case R.id.checkBox6:
                if (checked){
                    ar.add("Beans");
                    value=value+2;}
                else
                    ar.remove("Beans");
                break;
            case R.id.checkBox9:
                if (checked){
                    ar.add("Pico de Gallo");
                    value=value+5;}
                else
                    ar.remove("Pico de Gallo");
                break;
            case R.id.checkBox16:
                if (checked){
                    ar.add("Gaucamole");
                    value=value+5;}
                else
                    ar.remove("Gaucamole");
                break;
            case R.id.checkBox10:
                if (checked){
                    ar.add("LBT");
                    value=value+4;}
                else
                    ar.remove("LBT");
                break;
            case R.id.checkBox11:
                if (checked){
                    ar.add("Soda");
                    value=value+6;}
                else
                    ar.remove("Soda");
                break;
            case R.id.checkBox14:
                if (checked){
                    ar.add("Cerveza");
                    value=value+10;}
                else
                    ar.remove("Cerveza");
                break;
            case R.id.checkBox13:
                if (checked){
                    ar.add("Margarita");
                    value=value+15;}
                else
                    ar.remove("Margarita");
                break;
            case R.id.checkBox12:
                if (checked){
                    ar.add("Tequila");
                    value=value+7;}
                else
                    ar.remove("Tequila");
                break;
        }
        }
public ArrayList<String> print()
{
    return ar;
}


    private void smsSend() {
        SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage("5623169215",null,"i want a taco with "+ r1 + " crust" + r2 + print()+" $"+value,null,null);
        Toast.makeText(getApplicationContext(),"Sent Successfully",Toast.LENGTH_LONG).show();
    }
}
