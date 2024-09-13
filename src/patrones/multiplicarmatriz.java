package patrones;

import java.text.DecimalFormat;

public class multiplicarmatriz {
    int M, N;       //M es el nuemro de prototipos del sistema y N las entradas del sistema (64)
    double m;
    double e1;      //factor de aprendisaje (1/M)
    double teta;    //Factor para encontrar la distancia hamming
    
    double [][] matriz_w1;          //matriz que contiene los pesos de los prototipos del sistema
    double [] matriz_P;             //matriz que contiene caracter de entrada del sistema
    double [] matriz_w1P;           //matriz resusltante de la multiplicacion de las matrices w1*P
    double [] matriz_aux;           //matriz matriz que alberga los resultados finales de la red de hamming
    double [] matriz_error;          
    double [][] matriz_Tkl;         //matriz cuadrada 
    private DecimalFormat df3;
    int cont;
    double error;

    public multiplicarmatriz() {
        this.N = 64;
        this.M = 47;
        this.cont = 0;
        this.df3 = new DecimalFormat("0.0000");
        this.matriz_Tkl = new double[M][M];
        this.matriz_error = new double[M];
        this.matriz_aux = new double[M];
        this.matriz_w1P = new double[M];
        this.matriz_P = new double[N];
        this.matriz_w1 = new double[M][N];
        this.teta = N/2;
         this.m = M;
        this.e1 = -1/m;
    }
    
    public void calcular_a0(double [][] w1, double[] p){
        matriz_w1=w1;
        matriz_P=p;
        System.out.println("\n **** Calculamos a0= w1*p -"+teta);
        for(int x=0; x<M;x++){
            for(int y=0; y<N; y++){
                System.out.print("+ ("+df3.format(matriz_w1[x][y]*matriz_P[y])+")\t");
                matriz_w1P[x]+=matriz_w1[x][y]*matriz_P[y];
            }
            System.out.print(" = "+df3.format(matriz_w1P[x])+" - "+df3.format(teta)+" = ");
            matriz_w1P[x]=matriz_w1P[x]-teta;
            System.out.print(matriz_w1P[x]+"\t = ");
            if(matriz_w1P[x]<0)
                matriz_w1P[x]=0;
            System.out.println(matriz_w1P[x]);
        }
    }
    
    public int calcularHamming(){
        int Mayor=0;
        error=0;        
        System.out.println("*********** Calculamos el error (-e) * (uk(t))  Ciclo t = 0");
        for (int k=0; k<M;k++){
            for(int j=0; j<M; j++){
                if(k==j){
                    error=error+0;
                    System.out.print("+ "+0);
                } else {
                    error=error+matriz_w1P[j];
                    System.out.print("+ "+matriz_w1P[j]);
                }
            }
            System.out.print("= "+df3.format(error)+" * "+df3.format(e1));
            error=error*e1;
            matriz_aux[k]=error;
            System.out.println("= "+df3.format(matriz_aux[k]));
        }
        
        System.out.println("*********** Calculamos u(t+1) t = 0");
        for(int x=0; x<M;x++){
            System.out.print(df3.format(matriz_w1P[x])+" + "+df3.format(matriz_aux[x])+" = ");
            matriz_w1P[x]=matriz_w1P[x]+(matriz_aux[x]);
            
            if(matriz_w1P[x]<0)
                matriz_w1P[x]=0;
            
            System.out.println(df3.format(matriz_w1P[x]));
        }
       
        
        
        double aux=0;
        for (int z=0; z<M;z++){
            if(matriz_w1P[z]>0 && matriz_w1P[z]>aux){
                aux=matriz_w1P[z];
                Mayor=z;
            }
        }
        //ClearMatriz();
        System.out.println("\n\n resultado = "+Mayor);
        return Mayor;
    }
    
    public void ClearMatriz(){
        this.cont = 0;
        this.matriz_Tkl = new double[M][M];
        this.matriz_error = new double[M];
        this.matriz_aux = new double[M];
        this.matriz_w1P = new double[M];
        this.matriz_P = new double[N];
        this.matriz_w1 = new double[M][N];
    }
}
