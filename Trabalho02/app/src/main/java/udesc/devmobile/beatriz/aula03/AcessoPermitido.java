package udesc.devmobile.beatriz.aula03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AcessoPermitido extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String login = getIntent().getStringExtra("oi");
        TextView t = findViewById(R.id.user);
        t.setText(t.getText() + " " + login + "!");
    }

    public void Sair(View view){
        this.finish();
    }
}