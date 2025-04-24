package Program;

import Model.Entities.Hospede;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hotel, enter your details:");
        System.out.println("Name: ");
        String name = scanner.next();

        System.out.println("CPF: ");
        Integer cpf = scanner.nextInt();

        System.out.println("Phone: ");
        Integer phone = scanner.nextInt();

        Hospede hospede = new Hospede(name, cpf, phone);

    }
}