package com.example.marcoceron.finanzasfamiliares;

/**
 * Created by marco.ceron on 11/02/2016.
 */
public class tbl_ingresos {
    public static final String TABLE_NAME = "tbl_ingresos";

    public static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY ASC AUTOINCREMENT, idFondos INTEGER REFERENCES tbl_fondos (id) ON DELETE CASCADE ON UPDATE CASCADE, " +
            "idCuenta INTEGER REFERENCES tbl_cuentas (id) ON DELETE CASCADE ON UPDATE CASCADE, fecha DATE NOT NULL, descripcion STRING (50) NOT NULL, monto DECIMAL (6, 2) NOT NULL);";

    public static final String SELECT_ALL = "Select * from " + TABLE_NAME;

    private int id;
    private int idFondos;
    private int idCuenta;
    private String fecha;
    private String descripcion;
    private double monto;


    public tbl_ingresos(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFondos() {
        return idFondos;
    }

    public void setIdFondos(int idFondos) {
        this.idFondos = idFondos;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
