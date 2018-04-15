package deswebmob.usjt.br.servicedesk.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

import deswebmob.usjt.br.servicedesk.R;

/**
 * Created by Leandro Pinheiro de Holanda on 22/03/2018.
 */

public class Util {

    public static Drawable getDrawableDinamic(Context ctx, String nmImagem) {
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(nmImagem);
            int id = idField.getInt(idField);
            return ctx.getResources().getDrawable(id, null);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e1) {

            e1.printStackTrace();
        }


        return null;
    }
}
