package newtonraphson;
import javax.swing.JOptionPane;

public class NewtonRaphson {

    public static double funcion(double x) {
        return Math.pow(x, 2) - 2;
    }
    public static double derivada(double x) {
        return 2 * x;
    }
    public static void main(String[] args) {
        double x0 = Double.parseDouble(
                JOptionPane.showInputDialog("Ingrese el valor inicial x0:")
        );
        double tolerancia = Double.parseDouble(
                JOptionPane.showInputDialog("Ingrese la tolerancia:")
        );
        int maxIteraciones = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese el número maximo de iteraciones:")
        );
        String resultado = "MÉTODO DE NEWTON-RAPHSON\n";
        resultado += "Función: f(x) = x² - 2\n"; 
        resultado += "Derivada: f´(x) = 2x\n\n";
        
        for (int i = 1; i <= maxIteraciones; i++){
            double fx = funcion(x0);
            double dfx = derivada(x0);
            
            if (dfx == 0){
                JOptionPane.showMessageDialog(null, "Error: la derivada es cero, no se puede continuar.");
                return;
            } 
            double x1 = x0 - (fx / dfx);
            double error = Math.abs(x1 - x0);
            
            resultado += "Iteración " + i + "\n";
            resultado += "x anterior =" + x0 + "\n";
            resultado += "f(x) " + fx + "\n";
            resultado += "f´(x) " + dfx + "\n";
            resultado += "x nuevo" + x1 + "\n";
            resultado += "Error" + error + "\n";
            resultado += "--------------------\n";
            
            if (error < tolerancia) {
                resultado += "\n raíz aproximada: " + x1 + "\n";
                resultado += "Iteraciones realizadas: " + i ;
                JOptionPane.showMessageDialog(null, resultado);
                return;
            } 
            x0 = x1;
        }
        resultado += "\nRaíz aproximada: " + x0;
        JOptionPane.showMessageDialog(null, resultado);
    }
    
}
