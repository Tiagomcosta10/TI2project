package vagacerta;

import java.util.Scanner; // Importa a classe Scanner para ler entradas do usuário

public class SomaNumeros {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Pede ao usuário para digitar dois números
        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        // Calcula a soma
        int soma = num1 + num2;

        // Exibe o resultado
        System.out.println("A soma de " + num1 + " e " + num2 + " é: " + soma);

        // Fecha o scanner
        scanner.close();
    }
}
