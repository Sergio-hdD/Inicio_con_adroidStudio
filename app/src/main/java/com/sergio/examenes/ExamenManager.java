package com.sergio.examenes;

import android.content.Context;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class ExamenManager {//sería nuestra clase singleton ExamenManager

    private static ExamenManager instance;
    //Objeto Dao que se utilizará para acceder a la clase Examen
    Dao<Examen, Integer> dao;//El primer parámetro es la clase con la que se operará (Examen), y el segundo es la clase que pertenece el Id, en este caso sería Integer


    public ExamenManager() {//Construtor común
    }

    public ExamenManager(Context context) {//Constructor que inicializa la conexión con la base de datos. Para esto usaremos la clase OpenHelperManager indicándole a nuestro objeto “dao” la clase con la que va a trabajar.
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, DBHelper.class);
        try {
            dao = helper.getDao(Examen.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //get/constructor que aplica singleton
    public static ExamenManager getInstance(Context context) {
        if(instance == null){
            instance = new ExamenManager(context); //Uso el constructor creado antes (el que recibe el context)
        }
        return instance;
    }

    //get y set de dao
    public Dao<Examen, Integer> getDao() {
        return dao;
    }

    public void setDao(Dao<Examen, Integer> dao) {
        this.dao = dao;
    }


    ////métodos de consulta

    public List<Examen> getExamenes() throws Exception {
        return dao.queryForAll();
    }

    public void agregarExamen(Examen examen) throws Exception {
        dao.create(examen);
    }

}
