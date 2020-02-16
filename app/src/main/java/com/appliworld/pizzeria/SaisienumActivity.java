package com.appliworld.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.Socket;

import static com.appliworld.pizzeria.R.id.btnValider;
import static com.appliworld.pizzeria.R.id.edTxtNum;

public class SaisienumActivity extends AppCompatActivity{//Facon1 pas beosin d'implementer!! //implements View.OnClickListener{
    private Button btnVal;
    private EditText edTxt;
    private String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisienum);
        System.out.println("onCreate SaisienumActivity");

        //recuperer les bouttons
        btnVal = (Button) findViewById(btnValider);
        edTxt =(EditText)findViewById(edTxtNum);

        //ajouter des ecouteurs aux bouttons
        //Facon1:Class anonyme(Pas besoin de switch pour plusieurs bouttons)
        btnVal.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v)
                                            {
                                                num=String.valueOf(edTxt.getText());
                                                if(num != null)
                                                {
                                                    Intent intent=new Intent(SaisienumActivity.this,PizzeriaMainActivity.class);
                                                    intent.putExtra("num", num);
                                                    startActivity(intent);
                                                }
                                            }
                                        });
        //Facon2:(encore besoin de switch pour plusieurs bouttons)
        //btnVal.setOnClickListener(this);

        //pour le background
        View v = findViewById(R.id.fond);
        v.getBackground().setAlpha(70);
    }

    //Facon2:
    /*public void onClick(View v){
        if(v.getId()==btnValider)
            this.onbtnValClick(v);
    }
    public void onbtnValClick(View v) {
        num=String.valueOf(edTxt.getText());
        if(num != null)
        {
            Intent intent=new Intent(SaisienumActivity.this,PizzeriaMainActivity.class);
            startActivity(intent);
            intent.putExtra("num", num);
        }
    }*/

    protected void onStart()
    {
        super.onStart();
        System.out.println("onStart SaisienumActivity");
    }
    protected void onRestart()
    {
        super.onRestart();
        System.out.println("onRestart SaisienumActivity");
    }
    protected void onResume()
    {
        super.onResume();
        System.out.println("onResume SaisienumActivity");
    }
    protected void onPause()
    {
        super.onPause();
        System.out.println("onPause SaisienumActivity");
    }
    protected void onStop()
    {
        super.onStop();
        System.out.println("onStop SaisienumActivity");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        System.out.println("onDestroy SaisienumActivity");
    }
}
