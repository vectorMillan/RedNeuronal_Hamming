package patrones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class neurona_victor extends javax.swing.JFrame implements ActionListener {

    private JButton[] matriz_botonesE;    //Matriz de botones para controloar la entrada de P
    private double[] matriz_p;             //Los datos de entrada almacenados en los botones se buelcan en esta matriz para su posterior uso
    public int cont_w1F, cont_w1C, M, N;                      //contador de tipo fila y colmna de W1 (Pesos de prototipos)
    Prototipo prot = new Prototipo();                       //Instancia de la clase prototipo (Contenedora de todos los prototipos alamacenados)
    multiplicarmatriz mm = new multiplicarmatriz();           //Instanacia de la clase Multiplicar usada para multiplicar las matrices y optener el resultado del algoritmo de hamming
    //* Constructor de la clase

    public neurona_victor() {
        this.N = 64;
        this.M = 255;
        this.cont_w1C = 0;
        this.cont_w1F = 0;
        this.matriz_p = new double[N];
        this.matriz_botonesE = new JButton[N];
        initComponents();
        setLocationRelativeTo(null);    //Codigo para ubicar la ventana al centro de la pantalla        
        prot.cargar_ASCII();            //arreglo bidimencional colocando directamente los ceros se cambian por -0.5 y los 1 por 0.5
        //mm.llenar_matriz_Tkl(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tablero_entrada = new javax.swing.JPanel();
        tablero_salida = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        boton_Siguiente = new javax.swing.JButton();
        boton_Atras = new javax.swing.JButton();
        boton_clear = new javax.swing.JButton();
        boton_calcular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Instituto Tecnologico de Zacatepec");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Autor: Victor Manuel Millán Aguilar");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Reconocimiento de caracteres del Codigo ASCII mediante la distancia Red Hamming");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patrones/itz.png"))); // NOI18N

        tablero_entrada.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tablero_entradaLayout = new javax.swing.GroupLayout(tablero_entrada);
        tablero_entrada.setLayout(tablero_entradaLayout);
        tablero_entradaLayout.setHorizontalGroup(
            tablero_entradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        tablero_entradaLayout.setVerticalGroup(
            tablero_entradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        tablero_salida.setBackground(new java.awt.Color(255, 255, 255));
        tablero_salida.setPreferredSize(new java.awt.Dimension(343, 259));

        javax.swing.GroupLayout tablero_salidaLayout = new javax.swing.GroupLayout(tablero_salida);
        tablero_salida.setLayout(tablero_salidaLayout);
        tablero_salidaLayout.setHorizontalGroup(
            tablero_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        tablero_salidaLayout.setVerticalGroup(
            tablero_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("CREAR NUEVO PATRÓN ( CARACTER )");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("TABLA ASCII 255 PATRONES");

        boton_Siguiente.setText("SIGUIENTE");
        boton_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_SiguienteActionPerformed(evt);
            }
        });

        boton_Atras.setText("ATRAS");
        boton_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AtrasActionPerformed(evt);
            }
        });

        boton_clear.setText("BORRAR");
        boton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_clearActionPerformed(evt);
            }
        });

        boton_calcular.setText("NEURONA HAMMING");
        boton_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_calcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(234, 234, 234))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(177, 177, 177))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boton_clear)
                                        .addGap(308, 308, 308))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boton_Atras)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boton_Siguiente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tablero_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton_calcular)
                                        .addGap(18, 18, 18)
                                        .addComponent(tablero_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)))
                                .addGap(95, 95, 95)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(boton_clear)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tablero_entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tablero_salida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boton_calcular)
                        .addGap(199, 199, 199)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_Siguiente)
                    .addComponent(boton_Atras))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        iniciar_tableroSalida();                //Metodo que inicializa el tablero de salida 
        iniciar_tableroEntrada();               //Metodo que inicializa el tablero de entrda
        this.paintAll(this.getGraphics());
    }//GEN-LAST:event_formWindowOpened

    private void boton_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_SiguienteActionPerformed
        // TODO add your handling code here:
        if(cont_w1F < M-1){                                 //Se establece el limite del arreglo para evitar llamar datos invalidos
            cont_w1F++;                                     //Se incrementa el valor del controlador de fila (este controlador indica que prototipo del arreglo de prototipos de mostrara en el tablero de salida)
            tablero_salida.removeAll();                     //Se limpia el tablero de salida 
            iniciar_tableroSalida();                        //Se inicializa el tablero de salida con el nuebo valor en cont_w1F
            tablero_salida.paintAll(tablero_salida.getGraphics());    //se redibuja el tablero con los nuevos componentes
        }
    }//GEN-LAST:event_boton_SiguienteActionPerformed

    private void boton_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AtrasActionPerformed
        // TODO add your handling code here:
        if(cont_w1F > 0){                           //Se establece el limite del arreglo para evitar llamar datos invalidos
            cont_w1F--;                             //Se reduce el valor del controlador de fila (este controlador indica que prototipo del arreglo de prototipos de mostrara en el tablero de salida)
            tablero_salida.removeAll();             //Se limpia el tablero de salida 
            iniciar_tableroSalida();                //Se inicializa el tablero de salida con el nuebo valor en cont_w1F
            tablero_salida.paintAll(tablero_salida.getGraphics());      //se redibuja el tablero con los nuevos componentes
        }
    }//GEN-LAST:event_boton_AtrasActionPerformed

    private void boton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_clearActionPerformed
        tablero_entrada.removeAll();
        iniciar_tableroEntrada();
        
        tablero_salida.removeAll();
        iniciar_tableroSalida();
        this.paintAll(this.getGraphics());
    }//GEN-LAST:event_boton_clearActionPerformed

    private void boton_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_calcularActionPerformed
        // TODO add your handling code here:
        for(int x=0; x<N; x++)
            System.out.print(matriz_p[x]);        
        System.out.println();
        
        double [][]w1=prot.leerMatrizW1();          
        mm.calcular_a0(w1, matriz_p);               //multiplica las dos matrizes (se le pasa la matriz de con -0.5 y 0.5 ----- tambien se le pasa la matriz del patron unico creada con los botones )
        int result = mm.calcularHamming();
        cont_w1F=result;
       
        tablero_salida.removeAll();
        iniciar_tableroSalida();
        this.paintAll(this.getGraphics());
        
        mm.ClearMatriz();
    }//GEN-LAST:event_boton_calcularActionPerformed

    private void iniciar_tableroSalida() {
        this.tablero_salida.setLayout(new java.awt.GridLayout(8, 8));        //Se agrega un gridlayout al panel que contiene el tablero de entrada
        cont_w1C = 0;                                                         //Contador que controla el posicionamiento de la columna en la matriz-bidimencional de prototipos
        //* Ciclo que agrega los componenetes del tablero al panel que lo contiene
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {                                             //Dibuja el tablero en funcion de la matriz del prototipo leido
                if ((prot.MatrizProto[cont_w1F][cont_w1C]) == -1) {              //Si el bit leido es 0 (que en la matriz de pesos w1 seri -0.5)
                    Pixel pix = new Pixel(0);                                   //Se crea un pixe blanco
                    pix.setVisible(true);
                    this.tablero_salida.add(pix);                               //Se agrega el panel el pixel al tablero
                } else {                                                         //Si el bit leido es diferente de 0 ----> (-0.5)
                    Pixel pix = new Pixel(1);                                   //Se crea un pixel negro                        
                    pix.setVisible(true);
                    this.tablero_salida.add(pix);
                }
                cont_w1C++;            //incremento del contador que controla la posicion de la columna en la matriz de pesos w1
            }
        }
    }

    //* Metodo que inicializa el tablero de entrada
    private void iniciar_tableroEntrada() {                                      //Este metodo sigue el mismo patron que de "inicializar_tableroSalida"
        int contC = 0;                                                            //  con la diferencia que este almacena los componentes del tablero (JButton) 
        this.tablero_entrada.setLayout(new java.awt.GridLayout(8, 8));           //  en un arreglo para controlar los datos del entrada al sistema

        System.out.print("contador f=" + cont_w1F + "\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz_p[contC] = -1;                         //Se llena la matriz de entrada P con -1 ---->(seria un 0)
                JButton tem = new JButton();                //  los eventos de boton del tablero modificaran la matriz P
                tem.addActionListener(this);                //Se agrega el escuchador de acciones                    
                tem.setBackground(Color.WHITE);             //Se asigna un fondo blanco a los componentes que representan un (0)
                tem.setForeground(Color.WHITE);
                tem.setVisible(true);
                tem.setText("" + contC);                      //Se pasa como texto el controlador de posicion de la matriz_P para poder saber
                this.tablero_entrada.add(tem);              //  en que posicion de la matriz_P producira el cambio el boton presionado
                matriz_botonesE[contC] = tem;                 //Se agrega el boton a la matriz de botones
                contC++;
            }
        }
    }

    //* Metodo para limpiar las matrizes
    public void limpiar_Matriz() {
        this.matriz_p = new double[N];
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton){                       //Se establece que boton del tablero a sido precionado
            JButton tem = (JButton) e.getSource();                  //  y se ase una instancia de el
            
            if(tem.getBackground().equals(Color.WHITE)){            //Si el fondo del boton presionado es blanco
                tem.setBackground(Color.black);                     //  se cambia el fondo a negro
                int lugar=Integer.parseInt(tem.getText());          //Se optine el indice del control de posicion del arreglo_P que contiene el boton presionado
                matriz_p[lugar]=1;                                  //El nuevo valor de la matriz en es indice sera 1
            }else{                                                  //Si el color de fondo del boton no es blanco
                tem.setBackground(Color.WHITE);                     // se establece el color de fondo blanco
                int lugar=Integer.parseInt(tem.getText());          //Se optine el indice del control de posicion del arreglo_P que contiene el boton presionado
                matriz_p[lugar]=0;                                 //El nuevo valor de la matriz en es indice sera -1 que reprecenta un (0)
            }
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(neurona_victor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(neurona_victor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(neurona_victor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(neurona_victor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new neurona_victor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Atras;
    private javax.swing.JButton boton_Siguiente;
    private javax.swing.JButton boton_calcular;
    private javax.swing.JButton boton_clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel tablero_entrada;
    private javax.swing.JPanel tablero_salida;
    // End of variables declaration//GEN-END:variables

}
