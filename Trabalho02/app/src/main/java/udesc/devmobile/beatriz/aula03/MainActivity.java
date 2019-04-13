package udesc.devmobile.beatriz.aula03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.botao_login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    private void Login() {

        TextView login = findViewById(R.id.Login);
        TextView senha = findViewById(R.id.Senha);
        String loginInput = login.getText().toString();
        String senhaInput = senha.getText().toString();

        if (Valida(loginInput, senhaInput)) {
            Intent a = new Intent(MainActivity.this, AcessoPermitido.class);
            startActivity(a);
        } else {
            Intent b = new Intent(MainActivity.this, AcessoNegado.class);
            startActivity(b);
        }
    }

    private boolean Valida(String loginInput, String senhaInput) {
        return loginInput.equals("oi") && senhaInput.equals("senha");
    }
}