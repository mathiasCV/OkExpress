package cl.bbqstr.okexpress;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Auxiliar implements Serializable {
    private String carrito;
    private int subTotal;

    public Auxiliar(String carrito, int subTotal){
        this.carrito = carrito;
        this.subTotal = subTotal;
    }

    public String getCarrito() {
        return carrito;
    }

    public int getSubTotal() {
        return subTotal;
    }
}
