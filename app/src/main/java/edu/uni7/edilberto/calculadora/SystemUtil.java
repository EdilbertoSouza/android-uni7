package edu.uni7.edilberto.calculadora;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;
import java.util.ArrayList;

public class SystemUtil {

    private static final String prefsName = "CalculadoraHistoricoPrefs";

    public static void salvarHistorico(Context context, ArrayList<String> historico) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor     = sharedPreferences.edit();
        if (historico.size() > 0) {
            Serializable serializable = (Serializable) historico;
            editor.putString("historico", serializable.toString());
        } else {
            editor.putString("historico", "");
        }
        editor.apply();
    }

    public static String recuperarHistorico(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        return sharedPreferences.getString("historico", "");
    }

}
