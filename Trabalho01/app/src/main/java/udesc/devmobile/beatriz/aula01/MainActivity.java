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

    public void getIntervalo(View view) {
        int min = getNumero(R.id.minimo);
        int max = getNumero(R.id.maximo);

        if(validaNumeros(min, max)){
            int intervalo = max - min;
            geradorNumero(min, intervalo);
        }
        else
            Toast.makeText(this, "Valores inválidos!!",Toast.LENGTH_SHORT).show();
    }

    private void geradorNumero(int min, int intervalo) {
        Random random = new Random();
        int n = random.nextInt( intervalo++)+min;
        TextView resultado = findViewById(R.id.resultado);
        resultado.setText("Resultado: " + Integer.toString(n));
    }

    private int getNumero(int input){
        EditText input;

        try{
            input = findViewById(input);
            int valor = Integer.parseInt(input.getText().toString());
            return valor;
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            return -1;
        }
        finally {
            input = null;
        }
    }

    private boolean validaNumeros(int min, int max){
        if(min == -1 || max == 1) return false;
        if(min >= max) return false;
        return true;
    }

}