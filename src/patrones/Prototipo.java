package patrones;

/**
 *
 * @author VECTOR
 */
public class Prototipo {
    int M;
    int N;
    int lon_binary;
    double [][] MatrizProto;
    String binary;

    public Prototipo(){
        this.N = 64;
        this.M = 16;
        this.MatrizProto = new double[M][N];
        this.lon_binary = 0;
    }
    
    public double[][]leerMatrizW1(){
        return MatrizProto;
    }
    
    public void agregar_ascii(String dato, int cont){
         binary="";                                              //Se inicializa binary en blanco para cada nueva entrada
        long hex=0;
        
        String caracter1=""+dato.charAt(0);                     //Si el primer caracter de la cadena dato es 8, 9, A, B, C, D, E, 
        dato=dato.substring(1);                             //Se elimina el primer caracter de la cadena principal
        hex= Long.parseLong(dato, 16);                     //Se convierte la cadena hexadecimal de dato a un long (hex)
        binary = Long.toBinaryString(hex);                 //Se convierte el valor de long de hex a una cadena binaria de 0 y 1
        lon_binary = binary.length();                      //  tambien se usa el metodo completeDigits para completar la cadena binaria de ser necesario
        binary=completeDigits(binary,lon_binary, 60);       //manda a llamar el metodo de completeDigits con comtrol ---> (60) para completar los bits faltantes (Ceros a la izquierda)
        long aux=Long.parseLong(caracter1, 16);            //Se convierte la cadena hexadecimal del primer caracter a un long
        caracter1=Long.toBinaryString(aux);                //Se covierte el long a una cadena binaria
        binary=completeDigits(caracter1, caracter1.length() , 4)+binary;    //Se juntan las dos cadena caracter1 de (4 bits) y binary (de 60 bits) para formar la de (64 bits)            
        
        System.out.println("ASCII ("+cont+") = \t"+dato+" = \t"+binary);
        //ciclo que optiene cada bit de la cadena binary y lo guarda en su correspondiente lugar en la matriz de prototipos
        for(int c=0;c<N;c++){
            String caracter=""+binary.charAt(c);                
            if(caracter.equals("0")){                           //Si el caracter leido es un 1 el valor guardado en la matriz es 0.5 y si el caracter 
                MatrizProto[cont][c]=-1;                      //  leido es un 0 el valor guardado es un -0.5 con esto se optiene la matriz de los pesos
            }                                                   //  de prototipos
            else {
                MatrizProto[cont][c]=1;
            }    
        }
    }
    
     public String completeDigits(String binNum, int a, int control) {   //este metodo completa los bits faltantes en la convercion de long
        for (int i = a; i < control; i++)                               //a una cadena de tipo binaria con la ayuda de la variable a y control
            binNum = "0" + binNum;
        return binNum;
    }
    //*** Metodo que carga todos los prototipos ASCII al sistema
    public void cargar_ASCII(){                     //Si se requiere aumentar el numero de prototipos solo se agrega una nueva
        agregar_ascii("0000000000000000",0);        //llamda al metodo agregar_ascii() y se le pasan como parametros el Hexadecimal
        agregar_ascii("7E81A581BD99817E",1);        //del prototipoa introducir y el la fila de array en la que se introducira
        agregar_ascii("7EFFDBFFC3E7FF7E",2);        //se deve cuidar el numero de la fila este dentro del rango de filas de array
        agregar_ascii("6CFEFEFE7C381000",3);        //Si se requier incrementar el nuemro de filas solo se modifica el valor de (M)
        agregar_ascii("10387CFE7C381000",4);        //al inicio de la clase
        agregar_ascii("387C38FEFE7C387C",5);
        agregar_ascii("1010387CFE7C387C",6);
        agregar_ascii("0000183C3C180000",7);
        agregar_ascii("FFFFE7C3C3E7FFFF",8);
        agregar_ascii("003C664242663C00",9);
        agregar_ascii("FFC399BDBD99C3FF",10);
        agregar_ascii("0F070F7DCCCCCC78",11);
        agregar_ascii("3C6666663C187E18",12);
        agregar_ascii("3F333F303070F0E0",13);
        agregar_ascii("7F637F636367E6C0",14);
        agregar_ascii("995A3CE7E73C5A99",15);
        //agregar_ascii("6CFEFEFE7C381000",16);   
    }
}
