package com.example.udesc.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int i = 1;
    public Construtor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = getIntent().getIntExtra("id",1);

        configTela(i);


    }

    public void configTela(int i){
        c = createContrutor(i);
        c.setMarcador(getIntent().getIntegerArrayListExtra("marcador"));
        criaTela(i,c);
    }

    private Construtor createContrutor(int i){
        Construtor con = new Construtor(i, 1);
        return con;
    }



    private void criaTela(int i, Construtor c){
            TextView t = findViewById((R.id.question1));
            ImageButton b1 = findViewById(R.id.answ1);
            ImageButton b2 = findViewById(R.id.answ2);
            ImageButton b3 = findViewById(R.id.answ3);
            ImageButton b4 = findViewById(R.id.answ4);


            t.setText(c.getPergunta1().getTitulo());
            b1.setImageDrawable(getBitMap(i == 1 ? 1 : (5 + ((i - 2) * 4))));
            b2.setImageDrawable(getBitMap(i == 1 ? 2 : (5 + ((i - 2) * 4)) + 1));
            b3.setImageDrawable(getBitMap(i == 1 ? 3 : (5 + ((i - 2) * 4)) + 2));
            b4.setImageDrawable(getBitMap(i == 1 ? 4 : (5 + ((i - 2) * 4)) + 3));

    }

    public Drawable getBitMap(int i) {

        String ref = defineImg(i);
        String pkg = getPackageName();

        int id = getResources().getIdentifier(ref,"drawable",pkg);

        //Toast.makeText(this,"ID: " + Integer.toString(id) + " --- ref " + ref + " ---- pkg " + pkg,Toast.LENGTH_SHORT).show();
        return getDrawable(id);
        //return null;

    }

    private String defineImg(int i){
        // caminho das imagens, tem que definir qual botão será de qual professor e deve ser igual ao dos textos
        String caminho;
        switch(i){
            case 1:
                caminho = "drawable/doggo";
                break;
            case 2:
                caminho = "drawable/pinguim";
                break;
            case 3:
                caminho = "drawable/coguja";
                break;
            case 4:
                caminho = "drawable/panda";
                break;
            case 5:
                caminho = "drawable/suco";
                break;
            case 6:
                caminho = "drawable/drink";
                break;
            case 7:
                caminho = "drawable/vinho";
                break;
            case 8:
                caminho = "drawable/cafe";
                break;
            case 9:
               caminho = "drawable/blusa";
               break;
            case 10:
                caminho = "drawable/stackoverflow";
                break;
            case 11:
                caminho = "drawable/sueter";
                break;
            case 12:
                caminho = "drawable/starwars";
                break;

            default:
                caminho = "";
        }
        return caminho;

    }

    public void onClickAlt(View v) {

        try {
            Intent rightPage = new Intent(MainActivity.this, rightPage.class);
            Intent errorPage = new Intent(MainActivity.this, errorPage.class);


            if (i == 3) {
                errorPage.putExtra("id", c.getResult());
                startActivity(errorPage);
            } else {

                if (v.getId() == R.id.answ1) {
                    c.addMarcador(0);
                    rightPage.putExtra("id", i);

                } else {
                    if (v.getId() == R.id.answ2) {
                        c.addMarcador(1);
                        rightPage.putExtra("id", i);

                    } else {
                        if (v.getId() == R.id.answ3) {
                            c.addMarcador(2);
                            rightPage.putExtra("id", i);

                        } else {
                            c.addMarcador(3);
                            rightPage.putExtra("id", i);

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