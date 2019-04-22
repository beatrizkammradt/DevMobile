package com.example.udesc.myapplication;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class errorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_page);
        int i = getIntent().getIntExtra("id",0);


        criarTela(i);

    }

    private void criarTela(int i){

        TextView t = findViewById((R.id.txtResultado));
        ImageView img = findViewById(R.id.imgProfessor);
        configTela(i, t, img);
    }

    private void configTela(int r, TextView t, ImageView img){
        String texto;
        switch(r){
            case 0:
                t.setText("\tVocê é o Rui!\n\n Você é lindo e todos te amam.");
                img.setImageDrawable(getBitMap(r));
                break;
            case 1:
                t.setText("\tVocê é o Charles!\n\nVocê é legal, mas seus alunos não gostam muito de você...");
                img.setImageDrawable(getBitMap(r));
                break;
            case 2:
                t.setText("\tVocê é o Selner!\n\nVocê é um pé no saco, mas seus alunos gostam de você...");
                img.setImageDrawable(getBitMap(r));
                break;
            case 3:
                t.setText("\tVocê é o Kira!\n\nVocê é perfeito, não vá embora por favor..... <3");
                img.setImageDrawable(getBitMap(r));
                break;
            default:
                t.setText("Você é ninguem!");
                img.setImageDrawable(getBitMap(r));
                break;
        }

    }

    private Drawable getBitMap(int i) {

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
            case 0:
                caminho = "drawable/rui";
                break;
            case 1:
                caminho = "drawable/charles";
                break;
            case 2:
                caminho = "drawable/selner";
                break;
            case 3:
                caminho = "drawable/kira";
                break;
            default:
                caminho = "";
        }
        return caminho;

    }
}
