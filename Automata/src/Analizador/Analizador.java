package Analizador;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class Analizador {

    public String[] Inicio(String[] cadena) throws TokenMgrError, ParseException, ExecutionException {
        boolean aceptada = true;
        String resultados[] = cadena;
        for (int i = 0; i < cadena.length; i++) {

            InputStream is = new ByteArrayInputStream(cadena[i].getBytes());
            jcc obe = new jcc(is);
            try {
                obe.Iniciar();
                aceptada = true;

            } catch (TokenMgrError e) {
                aceptada = false;
            }
            resultados[i] = aceptada ? "Aceptada: \t" + "\"" + resultados[i] + "\"" :
                                       "No Aceptada: \t" + "\"" + resultados[i] + "\"";
        }
        for (String resultado : resultados) {
            System.out.println("" + resultado);
        }
        return resultados;
    }
}
