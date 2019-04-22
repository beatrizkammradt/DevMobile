package com.example.udesc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class rightPage extends AppCompatActivity {
    private int i;
    public Construtor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_page);
        i = getIntent().getIntExtra("id",0);


        configTela(i);
    }

    public void configTela(int i){
        c = createContrutor(i);
        c.setMarcador(getIntent().getIntegerArrayListExtra("marcador"));
        criaTela(i,c);
    }

    private Construtor createContrutor(int i){
        Construtor con = new Construtor(i, 0);
        return con;
    }



    private void criaTela(int i, Construtor c){

        TextView t = findViewById((R.id.titulo));

        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);

        t.setText(c.getPergunta1().getTitulo());

        b1.setText(c.getAlternativa1().getTexto());
        b2.setText(c.getAlternativa2().getTexto());
        b3.setText(c.getAlternativa3().getTexto());
        b4.setText(c.getAlternativa4().getTexto());
    }

    public void onClickAlt(View v){

        try {

            Intent rightPage = new Intent(rightPage.this, MainActivity.class);
            Intent errorPage = new Intent(rightPage.this, errorPage.class);


            if (i == 4) {
                errorPage.putExtra("id", c.getResult());
                startActivity(errorPage);
            } else {

                if (v.getId() == R.id.button1) {
                    c.addMarcador(0);
                    rightPage.putExtra("id", i + 1);

                } else {
                    if (v.getId() == R.id.button2) {
                        c.addMarcador(1);
                        rightPage.putExtra("id", i + 1);

                    } else {
                        if (v.getId() == R.id.button3) {
                            c.addMarcador(2);
                            rightPage.putExtra("id", i + 1);

                        } else {
                            c.addMarcador(3);
                            rightPage.putExtra("id", i + 1);

                        }
                    }
                }

                rightPage.putIntegerArrayListExtra("marcador", c.getMarcador().getTeachers());
                startActivity(rightPage);
            }

        }
        catch(Exception ex){
            String a = ex.getMessage();
            int b = 0;
        }

    }
}