package patrones;

import java.io.*;

public class Prototipo {

    int M;
    int N;
    int lon_binary;
    double[][] MatrizProto;
    String binary;

    public Prototipo() {
        this.N = 64;
        this.M = 47;
        this.MatrizProto = new double[M][N];
        this.lon_binary = 0;
    }

    public double[][] leerMatrizW1() {
        return MatrizProto;
    }

    public void agregar_ascii(String dato, int cont) {
        binary = "";                                              //Se inicializa binary en blanco para cada nueva entrada
        long hex = 0;

        String caracter1 = "" + dato.charAt(0);                     //Si el primer caracter de la cadena dato es 8, 9, A, B, C, D, E, 
        dato = dato.substring(1);                             //Se elimina el primer caracter de la cadena principal
        hex = Long.parseLong(dato, 16);                     //Se convierte la cadena hexadecimal de dato a un long (hex)
        binary = Long.toBinaryString(hex);                 //Se convierte el valor de long de hex a una cadena binaria de 0 y 1
        lon_binary = binary.length();                      //  tambien se usa el metodo completeDigits para completar la cadena binaria de ser necesario
        binary = completeDigits(binary, lon_binary, 60);       //manda a llamar el metodo de completeDigits con comtrol ---> (60) para completar los bits faltantes (Ceros a la izquierda)
        long aux = Long.parseLong(caracter1, 16);            //Se convierte la cadena hexadecimal del primer caracter a un long
        caracter1 = Long.toBinaryString(aux);                //Se covierte el long a una cadena binaria
        binary = completeDigits(caracter1, caracter1.length(), 4) + binary;    //Se juntan las dos cadena caracter1 de (4 bits) y binary (de 60 bits) para formar la de (64 bits)            

        System.out.println("ASCII (" + cont + ") = \t" + dato + " = \t" + binary);
        //ciclo que optiene cada bit de la cadena binary y lo guarda en su correspondiente lugar en la matriz de prototipos
        for (int c = 0; c < N; c++) {
            String caracter = "" + binary.charAt(c);
            if (caracter.equals("0")) {                           //Si el caracter leido es un 1 el valor guardado en la matriz es 0.5 y si el caracter 
                MatrizProto[cont][c] = -1;                      //  leido es un 0 el valor guardado es un -0.5 con esto se optiene la matriz de los pesos
            } //  de prototipos
            else {
                MatrizProto[cont][c] = 1;
            }
        }
    }

    public String completeDigits(String binNum, int a, int control) {   //este metodo completa los bits faltantes en la convercion de long
        for (int i = a; i < control; i++) //a una cadena de tipo binaria con la ayuda de la variable a y control
        {
            binNum = "0" + binNum;
        }
        return binNum;
    }

    //*** Metodo que carga todos los prototipos ASCII al sistema
    public void cargar_ASCII() {
        String archivo = "src/patrones/prueba.txt";
        BufferedReader entrada = null;
        String lectura = "";
        int contador = 0;

        try {
            entrada = new BufferedReader(new FileReader(archivo));
            while ((lectura = entrada.readLine()) != null) {
                System.out.println(lectura + " " + contador);
                agregar_ascii(lectura, contador);
                contador++;

                // Asegúrate de que no se exceda el tamaño de la matriz
                if (contador >= M) {
                    System.out.println("Se ha alcanzado el límite de la matriz: " + M);
                    break;
                }
            }

            if (contador < M) {
                System.out.println("Se han leído menos de " + M + " prototipos.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();  // Asegúrate de cerrar el archivo después de leer
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

