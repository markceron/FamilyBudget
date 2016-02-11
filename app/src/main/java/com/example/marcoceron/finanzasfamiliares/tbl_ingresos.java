package com.example.marcoceron.finanzasfamiliares;

/**
 * Created by marco.ceron on 11/02/2016.
 */
public class tbl_ingresos {
    public static final String TABLE_NAME = "tbl_ingresos";

    public static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY ASC AUTOINCREMENT, idFondos INTEGER REFERENCES tbl_fondos (id) ON DELETE CASCADE ON UPDATE CASCADE, " +
            "idCuenta INTEGER REFERENCES tbl_cuentas (id) ON DELETE CASCADE ON UPDATE CASCADE, fecha DATE NOT NULL, descripcion STRING (50) NOT NULL, monto DECIMAL (6, 2) NOT NULL);";

    public static final String SELECT_ALL = "Select * from " + TABLE_NAME;
}
