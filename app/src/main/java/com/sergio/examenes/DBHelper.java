package com.sergio.examenes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

public class DBHelper extends OrmLiteSqliteOpenHelper {

    public DBHelper(Context context) {
        super(context, Constants.STR_NOMBRE_DB, null, Constants.INT_VERSION_DB);
    }

    @Override //El método onCreate() se ejecutará sólo una vez para crear la base de datos, y aquí es donde debemos generar las tablas.
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Examen.class); //Creo la tabla Examen, para más de una repetir esto
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override //onUpgrade se invoca cuando la aplicación es actualizada y tiene un número de versión, permite el ajuste de todos los datos
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

}