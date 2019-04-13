package udesc.devmobile.beatriz.aula03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AcessoNegado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acesso_negado);
    }

    public void novoLogin(View view){
        this.finish();
    }
}
