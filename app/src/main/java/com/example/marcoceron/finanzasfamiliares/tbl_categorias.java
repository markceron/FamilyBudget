package com.example.marcoceron.finanzasfamiliares;

/**
 * Created by marco.ceron on 01/02/2016.
 */
public class tbl_categorias {
    public static final String TABLE_NAME = "tbl_categorias";

    public static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo STRING (25) UNIQUE ON CONFLICT ROLLBACK NOT NULL);";

    public static final String SELECT_ALL = "Select * from " + TABLE_NAME;

    private int id;
    private String titulo;


    public tbl_categorias(String titulo) {
        this.titulo = titulo;
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



    @Override
    public String toString() {
        return "tbl_categorias{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
