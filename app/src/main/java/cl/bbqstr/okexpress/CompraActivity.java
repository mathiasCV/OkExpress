package cl.bbqstr.okexpress;

import android.app.AutomaticZenRule;
import android.content.Intent;
import android.hardware.SensorAdditionalInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CompraActivity extends AppCompatActivity {
    ArrayList carrito = new ArrayList();
    ArrayAdapter<String> adapter;
    int subTotal;
    public static final String EXTRA_MESSAGE = "cl.bbqstr.okexpress.COMPRA";
    Auxiliar aux;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compra_activity);

        Intent intent = getIntent();
        aux = (Auxiliar) intent.getSerializableExtra(MenuPrincipal.EXTRA_MESSAGE);
        String pedido = aux.getCarrito();
        subTotal = aux.getSubTotal();
        for(String i : pedido.split(";")){
            carrito.add(i);
        }

        adapter = new ArrayAdapter<>(this, R.layout.item_list_compra_activity, carrito);

        ListView lv = findViewById(R.id.cListView);
        lv.setAdapter(adapter);

        TextView tv = findViewById(R.id.cTvTotal);
        tv.setText("$"+(subTotal));

        Button medioDePago = findViewById(R.id.cBtnMedioPago);
        medioDePago.setEnabled(false);

    }


    public void pagar(View view) {
        Toast.makeText(getApplicationContext(), "Compra realizada!", Toast.LENGTH_SHORT).show();
        String s = "Compra: "+carrito.get(0)+" Total: "+subTotal;
        Intent intent = new Intent(this, PerfilActivity.class);
        intent.putExtra(EXTRA_MESSAGE,s);
    }

    public void cancelarCompra(View view) {
        finish();
    }

    public void mediosDePago(View view) {

    }

    public void setExtra(View view) {
        TextView extra = findViewById(R.id.cTextExtra);
        extra.setText("Delivery: +500");
        TextView tv = findViewById(R.id.cTvTotal);
        total = subTotal + 500;
        tv.setText("$"+(total));
    }

    public void deleteExtra(View view) {
        TextView extra = findViewById(R.id.cTextExtra);
        extra.setText("");
        int total = subTotal;
        TextView tv = findViewById(R.id.cTvTotal);
        tv.setText("$"+(total));

    }
}
