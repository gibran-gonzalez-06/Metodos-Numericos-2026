/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodolagrange;

import javax.swing.JOptionPane;

/**
 *
 * @author vicen
 */
public class MetodoLagrange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n = Integer.parseInt(JOptionPane.showInputDialog(
        "Ingrese la cantidad de puntos:"
        ));
        
        double[] x = new double[n];
        double[] y = new double[n];
        
        for (int i = 0; i < n; i++){
           x[i] = Double.parseDouble(JOptionPane.showInputDialog(
           "Ingrese el valor de x" + i + ":"
           ));
           
           y[i] = Double.parseDouble(JOptionPane.showInputDialog(
           "Ingrese el valor de y" + i + ":"
           ));        
        }
        
        double valorX = Double.parseDouble(JOptionPane.showInputDialog(
                "Ingrese el valor de x a interpolar: x = "
        ));
        
        double resultado = 0;
        String procedimiento = "Metodo de Interpolación de Lagrange\n\n";
        procedimiento += "Valor a interpolar: x = " + valorX + "\n\n";
        
        for (int i = 0; i < n; i++){
            
            double Li = 1;
            String termino = "L" + i + "(x) = ";
            
            for (int j = 0; j < n; j++){
                if (i != j){
                    Li *= (valorX - x[j]) / (x[i] - x[j]);
                    
                    termino += "((" + valorX + " - " + x[j] + ") / ("
                            + x[i] + " - " + x[j] + ")) ";
                }
            }
            double parte = y[i] * Li;
            resultado += parte;
            
            procedimiento += termino + "\n";
            procedimiento += "L" + i + " = " + Li + "\n";
            procedimiento += "y" + i + "* L" + i + " = "
                    + y[i] + " * " + Li + " = " + parte + "\n\n";
        }
           procedimiento += "Resultado final: \n";
           procedimiento += "P(" + valorX + ") = " + resultado;
           
           JOptionPane.showMessageDialog(null, procedimiento);
    }
    
}
