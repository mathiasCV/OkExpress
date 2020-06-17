package cl.bbqstr.okexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    Intent intent = null;
    HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        usuarios.put("bbq", new Usuario("Test","bbq", "123", "Test2","10/10/1990","11111111-1"));
        user = findViewById(R.id.lUser);
        pass = findViewById(R.id.lPass);
        try{
            Intent intent = getIntent();
            Usuario aux = (Usuario) intent.getSerializableExtra(RegistroActivity.EXTRA_MESSAGE);
            usuarios.put(aux.getUser(), aux);
        }catch (Exception e){

        }
    }

    public void registrarUsuario(View view) {
        intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public boolean verificarUsuario(String user, String pass){
        System.out.println(usuarios.get(user).getUser());
        System.out.println(usuarios.get(user).getPassword());
        try{
            usuarios.get(user);

            if(pass.equals(usuarios.get(user).getPassword())){
                return true;
            }else{
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos.",Toast.LENGTH_SHORT).show();
                return false;
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos.",Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public void entrar(View view) {
        try {
            user = findViewById(R.id.lUser);
            pass = findViewById(R.id.lPass);
            if(verificarUsuario(user.getText().toString(), pass.getText().toString())){
                intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos.",Toast.LENGTH_SHORT).show();
        }

       /* try{
            startActivity(intent);
        }catch (Exception e){

        }*/
    }
}
