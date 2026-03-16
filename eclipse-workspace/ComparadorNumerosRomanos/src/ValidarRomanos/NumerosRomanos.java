package ValidarRomanos;

import java.util.ArrayList;

public class NumerosRomanos {

    public static int convertirADecimal(String romano) {
        ArrayList<Integer> valores = new ArrayList<Integer>();

        for (int i = 0; i < romano.length(); i++) {
            char c = romano.charAt(i);
            int valor = valorLetra(c);
            valores.add(valor);
        }

        int total = 0;
        for (int i = 0; i < valores.size(); i++) {
            int actual = valores.get(i);
            if (i + 1 < valores.size() && actual < valores.get(i + 1)) {
                total -= actual;
            } else {
                total += actual;
            }
        }

        return total;
    }

    public static int valorLetra(char letra) {
        if (letra == 'I') return 1;
        if (letra == 'V') return 5;
        if (letra == 'X') return 10;
        if (letra == 'L') return 50;
        if (letra == 'C') return 100;
        if (letra == 'D') return 500;
        if (letra == 'M') return 1000;
        return 0;
    }

    public static boolean esRomanoValido(String romano) {
        if (romano == null || romano.length() == 0) {
            return false;
        }

        for (int i = 0; i < romano.length(); i++) {
            char c = romano.charAt(i);
            if (c != 'I' && c != 'V' && c != 'X' && c != 'L'
                    && c != 'C' && c != 'D' && c != 'M') {
                return false;
            }
        }

        int contadorV = 0, contadorL = 0, contadorD = 0;
        int seguidos = 1;

        for (int i = 0; i < romano.length(); i++) {
            char actual = romano.charAt(i);

            if (actual == 'V') contadorV++;
            if (actual == 'L') contadorL++;
            if (actual == 'D') contadorD++;

            if (contadorV > 1 || contadorL > 1 || contadorD > 1) {
                return false;
            }

            if (i > 0 && romano.charAt(i) == romano.charAt(i - 1)) {
                seguidos++;
                if (seguidos > 3) {
                    return false;
                }
            } else {
                seguidos = 1;
            }
        }

        for (int i = 0; i < romano.length() - 1; i++) {
            char actual = romano.charAt(i);
            char siguiente = romano.charAt(i + 1);
            int valorActual = valorLetra(actual);
            int valorSiguiente = valorLetra(siguiente);

            if (valorActual < valorSiguiente) {
                boolean esValido = false;
                if (actual == 'I' && (siguiente == 'V' || siguiente == 'X')) esValido = true;
                if (actual == 'X' && (siguiente == 'L' || siguiente == 'C')) esValido = true;
                if (actual == 'C' && (siguiente == 'D' || siguiente == 'M')) esValido = true;

                if (!esValido) {
                    return false;
                }
            }
        }

        return true;
    }
}
