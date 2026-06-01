/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reglatrapecio;

import javax.swing.JOptionPane;

public class ReglaTrapecio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el limite inferior a: ")
        );
        double b = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el limite superior b: ")
        );
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de intervalos: ")
        );
        
        double h = (b - a) /n;
        
        double suma = funcion(a) + funcion(b);
        
        for(int i = 1; i < n; i++){
            double x = a + i * h;
            suma = suma + 2 * funcion(x);
        }
        
        double resultado = (h / 2) * suma;
        
        String salida = "METODO DEL TRAPECIO\n\n";
        salida += "Función: f(x) =  x²\n";
        salida += "Limite inferior a: " + a + "\n";
        salida += "Limite Superior b: " + b + "\n";
        salida += "Número de intervalos:" + n + "\n";
        salida += "Valor de h: " + h + "\n";
        salida += "Resultado aproximado: " + resultado + "\n";
        
        JOptionPane.showMessageDialog(null, salida);
    }
    public static double funcion(double x){
        return Math.pow(x, 2);
    }
}
