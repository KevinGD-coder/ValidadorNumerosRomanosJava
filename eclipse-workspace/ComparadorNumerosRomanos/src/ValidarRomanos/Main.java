package ValidarRomanos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Comparador de Numeros Romanos ===");
        System.out.print("Introduce el primer numero romano: ");
        String numero1 = scanner.nextLine().toUpperCase();
        System.out.print("Introduce el segundo numero romano: ");
        String numero2 = scanner.nextLine().toUpperCase();

        if (!NumerosRomanos.esRomanoValido(numero1)) {
            System.out.println("Error: El primer numero romano no es valido.");
            return;
        }
        
        if (!NumerosRomanos.esRomanoValido(numero2)) {
            System.out.println("Error: El segundo numero romano no es valido.");
            return;
        }

        int valor1 = NumerosRomanos.convertirADecimal(numero1);
        int valor2 = NumerosRomanos.convertirADecimal(numero2);

        System.out.println("\n" + numero1 + " = " + valor1);
        System.out.println(numero2 + " = " + valor2);
        System.out.println();

        if (valor1 > valor2) {
            System.out.println("Resultado: " + numero1 + " es mayor que " + numero2);
        } else if (valor1 < valor2) {
            System.out.println("Resultado: " + numero2 + " es mayor que " + numero1);
        } else {
            System.out.println("Resultado: Los dos numeros son iguales");
        }

        scanner.close();
    }
}
