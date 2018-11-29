
package contador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import java.util.List;
import java.util.Map;
import java.util.Scanner;






public class Cuenta extends javax.swing.JFrame {

    Hashtable<Character,Letras> hash = new Hashtable<>();
    
    public Cuenta() {
        initComponents();
        
    }
    
public int contador(){
        String texto = txtTexto.getText();
        Scanner sc = new Scanner(texto);
        int words =0;
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            words+= linea.split(" ").length;
        }
        sc.close();
        return words;
}

public void contarLetras(){
    
    
    String texto = txtTexto.getText();
    texto = texto.toLowerCase();

    String[] linea = texto.split(" ");
     System.out.println("\n Vocales: " + contarVocalPorLinea(linea));

    for(int i = 0; i<linea.length;i++){
        String pal = linea[i];
        for(int j =0; j<pal.length(); j++){
            if(hash.containsKey(pal.charAt(j))){
                Letras a = hash.get(pal.charAt(j));
                a.cont++;
                hash.put(pal.charAt(j), a);
            }
            else{
                hash.put(pal.charAt(j), new Letras(pal.charAt(j)));
            }
        }
        
    }
hayLetras();
}

public void hayLetras(){
    
    String a ="";
    Enumeration num = hash.elements();
    while(num.hasMoreElements()){
        System.out.println(num.nextElement().toString()+ "\n");
    }
}

public int contarVocalPorLinea(String[] text){
        int count=0;
        for(int i=0; i<text.length; i++){
            count+=contarSilabas(text[i]);
        }
        return count;
    }
    
    public static int contarSilabas(String word){
        int count = 0;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '\"' || word.charAt(i) == '\'' || word.charAt(i) == '-' || word.charAt(i) == ',' || word.charAt(i) == ')' || word.charAt(i) == '(') {
                word = word.substring(0,i)+word.substring(i+1, word.length());
            }
        }
        boolean isPrevVowel = false;
        for (int j = 0; j < word.length(); j++) {
            if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
                if (esVocal(word.charAt(j)) && !((word.charAt(j) == 'e') && (j == word.length()-1))) {
                    if (isPrevVowel == false) {
                        count++;
                        isPrevVowel = true;
                    }
                } else {
                    isPrevVowel = false;
                }
            } else {
                count++;
                break;
            }
        }
        return count;
    }
    
    public static boolean esVocal(char c){
        
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }


public void repetidas(){
       
        String texto = txtTexto.getText();
         String[] linea = texto.split(" ");
         
            Map<String, Integer> mp= new HashMap<>();
 
            for(String words:linea){
                
                String clean = words.toLowerCase();
                List<String> ignorar= Arrays.asList("que","en","y","los","las","el","a","la","de");
                clean= clean.replaceAll(", $", " ");
                clean= clean.replaceAll("\\.", "");
                clean=clean.replaceAll("; $","");
                clean=clean.replaceAll("\n"," ");
                if(ignorar.contains(words)){
                    continue;
                }
                if(mp.containsKey(clean)){
                    mp.put(clean,mp.get(clean)+1);
                }
                
                else{
                    mp.put(clean, 1);
                }
            }

            System.out.println(mp);
         
            int masRepetida=0;
            String palabra=null;
            for(String word:mp.keySet()){
                Integer val = mp.get(word);                
                if(val > masRepetida){
                    masRepetida=val;
                    palabra= word;
                    
                }

            }
            System.out.println();
            System.out.printf("la más usada es '%s' , %d veces",palabra, masRepetida);
            
            //mp.values().removeAll(Collections.singleton(2));
            //txt5.setText(mp.toString());
            List<String> norepetidas = null;
            List<String> repetidas = null;

            if(mp.containsValue(1))
            {
        	norepetidas = new ArrayList<>();			
			for (Map.Entry<String, Integer> entry : mp.entrySet()) 
			{
			// Si el value es igual al valor dado
                            if (entry.getValue().equals(1))
                             norepetidas.add(entry.getKey());             
			}
                        txt5.setText(norepetidas.toString());
                        mp.keySet().removeAll(norepetidas);
                        txt4.setText(mp.toString());
            }
            
               
            
		// Devuelve la lista de las palabras usadas una vez
		
                
            }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt4 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt5 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);
        txtTexto.getAccessibleContext().setAccessibleName("");

        jLabel1.setText("Ingresa tu texto");

        jLabel2.setText("Este archivo tiene");

        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Se repiten:");

        jButton1.setText("Leer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt4.setColumns(20);
        txt4.setRows(5);
        jScrollPane2.setViewportView(txt4);

        txt5.setColumns(20);
        txt5.setRows(5);
        jScrollPane3.setViewportView(txt5);

        jLabel6.setText("No se repiten:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(233, 233, 233))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addContainerGap())
        );

        txt1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        txt1.setText(contador()+" palabras");
        repetidas();
        
contarLetras();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        
    }//GEN-LAST:event_txt1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
           

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextArea txt4;
    private javax.swing.JTextArea txt5;
    public static javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
