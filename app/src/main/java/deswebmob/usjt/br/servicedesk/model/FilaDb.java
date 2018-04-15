package deswebmob.usjt.br.servicedesk.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Leandro Pinheiro de Holanda 816113762
 */

public class FilaDb {

    private FilaDBHelper dbHelper;
    public FilaDb(Context context) {
        dbHelper = new FilaDBHelper(context);
    }

    public void inserirFila(ArrayList<Fila> filas){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        for(Fila fila:filas){
            values.put(FilaDbContract.FilaDb.ID_FILA , fila.getId());
            values.put(FilaDbContract.FilaDb.NM_FILA , fila.getNome());
            values.put(FilaDbContract.FilaDb.NM_FIGURA , fila.getFigura());

            db.insert(FilaDbContract.FilaDb.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Fila> listarFilas() {
        ArrayList<Fila> filas = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = {FilaDbContract.FilaDb.ID_FILA, FilaDbContract.FilaDb.NM_FILA,
            FilaDbContract.FilaDb.NM_FIGURA};

        String orderBy = FilaDbContract.FilaDb.ID_FILA;

        Cursor c;

        c = db.query(FilaDbContract.FilaDb.TABLE_NAME, colunas, null,
                null, null, null, orderBy);

        while(c.moveToNext()){
            Fila fila = new Fila();
            fila.setId(c.getInt(c.getColumnIndex(FilaDbContract.FilaDb.ID_FILA)));
            fila.setNome(c.getString(c.getColumnIndex(FilaDbContract.FilaDb.NM_FILA)));
            fila.setFigura(c.getString(c.getColumnIndex(FilaDbContract.FilaDb.NM_FIGURA)));

            filas.add(fila);
        }
        c.close();
        db.close();

        return filas;
    }
}
