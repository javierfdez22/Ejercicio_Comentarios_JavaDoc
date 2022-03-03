package testtemperatura;

import java.util.Arrays;

/**
 * 
 * Esta clase sirve para generar un array bidimensional en el cual
 * se cargan números, simulando que estos son temperaturas que
 * corresponden a cada día de cada semana 
 * @author Javier Fernández Paniagua
 * @version 1.0
 * 
 */

public class TestTemperatura {

    public static void main(String[] args) {

        double[][] temperaturas = new double[52][7];
        double[] semana = new double[52];

        cargaTablas(temperaturas);
        cargarTablaMinimasSemanales(temperaturas);
//        cargarTablaMaximasSemanales(temperaturas);
//        cargarTablaMediaSemanales(temperaturas);
        System.out.println(escribeTabla(temperaturas));
    }

    public static void cargaTablas(double[][] temperaturas) {
        double valorEntero, valorRedondeado;
        int signo;

        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                if (Math.random() > 0.5) {
                    signo = 1;
                    valorEntero = (double) (Math.random() * 45) * signo;
                    valorRedondeado = Math.round(valorEntero * 10.0) / 10.0;
                } else {
                    signo = -1;
                    valorEntero = (double) (Math.random() * 5) * signo;
                    valorRedondeado = Math.round(valorEntero * 10.0) / 10.0;
                }
                temperaturas[i][j] = valorRedondeado;
            }
        }
    }

    public static void cargarTablaMinimasSemanales(double[][] temperaturas) {
        double apoyo, aux;
        int i = 0;
        apoyo = 0;
        aux = 0;

        while (i < 52) {
            for (int k = 0; k < 6; k++) {
                if (temperaturas[i][k] > temperaturas[i][k + 1]) {
                    aux = temperaturas[i][k + 1];
                    temperaturas[i][k + 1] = temperaturas[i][k];
                    temperaturas[i][k] = aux;
                }
                apoyo = temperaturas[i][0];
            }
            i++;
            System.out.println("Semana " + i + ": " + apoyo + "\n");
        }
    }
    
    public static void cargarTablaMaximasSemanales(double[][] temperaturas) {
        double apoyo, aux;
        int i = 0;
        apoyo = 0;
        aux = 0;

        while (i < 52) {
            for (int j = 0; j <= 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (temperaturas[i][k] < temperaturas[i][k + 1]) {
                        aux = temperaturas[i][k];
                        temperaturas[i][k] = temperaturas[i][k + 1];
                        temperaturas[i][k + 1] = aux;
                    }
                    apoyo = temperaturas[i][0];
                }
            }
            i++;
            System.out.println("Semana " + i + ": " + apoyo + "\n");
        }

    }

    public static void cargarTablaMediaSemanales(double[][] temperaturas) {
        double suma = 0, media = 0, mediaRedondeada = 0;
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 7; j++) {
                suma = temperaturas[i][j];
            }
            media = suma / 7;
            mediaRedondeada = Math.round(media * 10.0) / 10.0;
            System.out.println("Media Semana " + (i + 1) + ": " + mediaRedondeada + "\n");
        }
    }

    public static String escribeTabla(double[][] temperaturas) {
        String salida = "";
        for (int i = 0; i < 52; i++) {
            salida += "Semana " + (i + 1) + ": ";
            for (int j = 0; j < 7; j++) {
                salida += temperaturas[i][j] + ", ";
            }
            salida += "\n";
        }
        return salida;
    }
}
