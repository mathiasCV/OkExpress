package cl.bbqstr.okexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class RegistroActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "cl.bbqstr.okexpress.REGISTRO";
    EditText user, pass, name, apellido, run, fechaNacimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resgistro_activity);
    }



    public void registrar(View view) {

        user = findViewById(R.id.rUser);
        pass = findViewById(R.id.rPass);
        name = findViewById(R.id.rNombre);
        apellido = findViewById(R.id.rApellido);
        run = findViewById(R.id.rRut);
        fechaNacimiento = findViewById(R.id.rFecha);
        Usuario u = new Usuario(name.getText().toString(),user.getText().toString(),pass.getText().toString(),apellido.getText().toString(),fechaNacimiento.getText().toString(),run.getText().toString());

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_MESSAGE, u);
        startActivity(intent);
    }
}
