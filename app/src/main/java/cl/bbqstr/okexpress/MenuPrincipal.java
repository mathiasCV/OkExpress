package cl.bbqstr.okexpress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends AppCompatActivity implements AdapterView.OnItemClickListener{
    Intent intent = null;
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList sProductos = new ArrayList();
    ArrayAdapter<String> adapter;
    TextView tv;
    Producto selecionado;
    int totalProductos = 0, subTotal=0;
    String pedidoFinal = "";

    public static final String EXTRA_MESSAGE = "cl.bbqstr.okexpress.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        llenarProductos();
        loadData();

        tv = findViewById(R.id.mPCarrito);
        adapter = new ArrayAdapter<>(this, R.layout.item_list_menu_principal, sProductos);
        ListView lv = findViewById(R.id.mPlistView);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setItemChecked(2,true);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }



    private void loadData() {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        String listaProductos = sp.getString("sProductos",generarString());

        for(String producto : listaProductos.split(";")){
            sProductos.add(producto);
        }
    }

    private String generarString(){
        String s = "";
        for(Producto p: productos) s += p.getNombreProducto() + " - Precio: " + p.getPrecio()+";";
        return s;
    }
    private void llenarProductos(){
        productos.add(new Producto("1","Kinder Chocolate",1290,"Chocolate relleno con leche 21g"));
        productos.add(new Producto("2","Milka",2990,"Chocolate Milka variedades 100g"));
        productos.add(new Producto("3","Hobby",890,"Hobby tradicional 40g"));
        productos.add(new Producto("4","Mogul ositos",1490,"Gomitas Mogul Arcor Ositos 90g"));
        productos.add(new Producto("5","Cracker",890,"Galletas Crackers Selz 107g"));
        productos.add(new Producto("6","Miubon",1190,"Chocolate Muibon maní 100g"));
        productos.add(new Producto("7","SAHNE-NUSS",1490,"Chocolate Sahne Nuss tradicional 100g"));
        productos.add(new Producto("8","Toddy",1490,"Galleta Toddy con chispas Clásica o Dulce de leche 142g"));
        productos.add(new Producto("9","Oreo",1190,"Chocolate Oreo barra cremosa 41g"));
        productos.add(new Producto("10","Push Pop",1590,"Caramelo Push Pop 15g"));
        productos.add(new Producto("11","Maní evercrips",1990,"Maní evercrips salado 160g"));
        productos.add(new Producto("12","Pepsi",1890,"Pepsi desechabel 1,5 L"));
    }

    public void realizarPedido(View view) {
        if(subTotal == 0){
            Toast.makeText(getApplicationContext(), "Agrega al menos un producto antes de hacer el pedido", Toast.LENGTH_SHORT).show();
        }else {
            Auxiliar aux = new Auxiliar(pedidoFinal,subTotal);

            intent = new Intent(this, CompraActivity.class);
            intent.putExtra(EXTRA_MESSAGE, aux);
            startActivity(intent);
        }
    }

    public void perfil(View view) {
        intent = new Intent(this, PerfilActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selecionado = productos.get(i);
    }

    public void addProduct(View view) {
        try{
            String s;
            totalProductos++;
            subTotal+=selecionado.getPrecio();
            s = "Productos: "+totalProductos+" | Subtotal:"+subTotal;
            tv.setText(s);
            pedidoFinal+=selecionado.getNombreProducto()+" - Precio: " + selecionado.getPrecio()+";";
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Selecciona un producto para agregar al carrito.", Toast.LENGTH_SHORT).show();
            totalProductos=0;
            subTotal=0;
        }

    }

}
