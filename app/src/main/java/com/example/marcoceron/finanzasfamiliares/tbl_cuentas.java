package com.example.marcoceron.finanzasfamiliares;

/**
 * Created by marco.ceron on 21/01/2016.
 */
public class tbl_cuentas {

    public static final String TABLE_NAME = "tbl_cuentas";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "nombre";
    public static final String FIELD_MONTO = "monto";

    public static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre STRING (50) UNIQUE ON CONFLICT ROLLBACK NOT NULL, monto DECIMAL (6, 2) DEFAULT (0.00));";

    public static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;


    private int id;
    private String nombre;
    private double monto;

    public tbl_cuentas(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    public tbl_cuentas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String toString() {
        return this.nombre;
    }
}
