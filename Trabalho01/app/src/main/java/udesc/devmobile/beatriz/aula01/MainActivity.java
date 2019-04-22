package udesc.devmobile.beatriz.aula01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getInterval(View view) {
        int min = getNum(R.id.numMinimo);
        int max = getNum(R.id.numMaximo);

        if(validaNum(min, max)){
            int interval = max - min;
            geradorNumero(min, interval);
        }
        else
            Toast.makeText(this, "Valores inválidos!!",Toast.LENGTH_SHORT).show();
    }

    private void geradorNumero(int min, int intervalo) {
        Random random = new Random();
        int n = random.nextInt( intervalo + 1)+min;
        TextView result = findViewById(R.id.resultado);
        result.setText("Resultado: " + Integer.toString(n));
    }

    private int getNum(int input){
        EditText objeto;

        try{
            objeto = findViewById(input);
            int valor = Integer.parseInt(objeto.getText().toString());
            return valor;
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            return -1;
        }
        finally {
            objeto = null;
        }
    }

    private boolean validaNum(int min, int max){
        if(min == -1 || max == 1){
            return false;
        }
        if(min >= max){
            return false;
        }
        return true;
    }

}