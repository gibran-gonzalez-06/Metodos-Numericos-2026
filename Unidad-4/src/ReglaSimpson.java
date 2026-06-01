/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reglasimpson;

import javax.swing.JOptionPane;
public class ReglaSimpson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double a = Double.parseDouble(
                JOptionPane.showInputDialog("Ingrese el limite inferior a:")
        );
        double b = Double.parseDouble(
                JOptionPane.showInputDialog("Ingrese el limite superior b")
        );
        int n = Integer.parseInt(
                JOptionPane.showInputDialog( "Ingrese el número de intervalos (par):")
        );
        if (n % 2 != 0){
            JOptionPane.showMessageDialog(null, 
                    "El número de intervalos debe ser par.");
            return;
        }
        double h = (b - a)/ n;
        double suma = funcion(a) + funcion(b);
        for (int i = 1; i < n; i++){
            double x = a + i * h;
            if (i % 2 == 0){
                suma += 2 * funcion(x);
            }else{
                suma += 4 * funcion(x);
            }
        }
        double resultado = (h / 3) * suma;
        String salida = "METODO DE SIMPSON 1/3";
        salida += "Función: f(x) =  x²\n";
        salida += "Intervalo: [" + a + "," + b + "]\n";
        salida += "Número de Intervalos:" + n + "\n";
        salida += "Resultado aproximado:" + resultado + "\n";
        
        JOptionPane.showMessageDialog(null,salida);
                
        
    }
    public static double funcion(double x) { 
        return Math.pow(x, 2);
    }
    
}
