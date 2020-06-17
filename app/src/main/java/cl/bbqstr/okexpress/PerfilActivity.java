package cl.bbqstr.okexpress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_activity);
        Button btnFav = findViewById(R.id.pBtnFavoritos);
        btnFav.setEnabled(false);
        Button btnMedio = findViewById(R.id.pBtnHistorial); //ojo cambiar
        btnMedio.setEnabled(false);
    }


    public void verHistorial(View view) {
    }
    public void verFavoritos(View view) {

    }

    public void agregarMedioDePago(View view) {
    }

    public void eliminarMedioDePago(View view){

    }
}
