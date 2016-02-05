package com.example.marcoceron.finanzasfamiliares;

/**
 * Created by marco.ceron on 21/01/2016.
 */
public class tbl_fondos {

    public static final String TABLE_NAME = "tbl_fondos";
    /**
     * public static final String FIELD_ID = "id";
     * public static final String FIELD_NAME = "titulo";
     * public static final String FIELD_MONTO = "monto";
     */
    public static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo STRING (25)" +
            " UNIQUE, monto DECIMAL (6, 2) DEFAULT (0.00));";

    public static final String SELECT_ALL = "Select * from " + TABLE_NAME;

    private int id;
    private String titulo;
    private double monto;

    public tbl_fondos(String titulo, double monto) {
        this.titulo = titulo;
        this.monto = monto;
    }

    public tbl_fondos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "tbl_fondos{" +
                "titulo='" + titulo + '\'' +
                ", monto=" + monto +
                '}';
    }
}
