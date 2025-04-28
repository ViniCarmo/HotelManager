package Program;

import Model.Dao.DaoFactory;
import Model.Dao.HospedeDao;
import Model.Entities.Hospede;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HospedeDao hospedeDao = DaoFactory.createHospedeDao();

//INSERT
        System.out.println("Welcome to Hotel, enter your details:");
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Phone: ");
        String phone = scanner.nextLine();

        Hospede hospede = new Hospede(null, name, cpf, phone);

        hospedeDao.insert(hospede);
        System.out.println();


        //UPDATE
        System.out.println("Welcome, " + name);
        System.out.println("Do you want to change any information? (yes/no)");
        String change = scanner.nextLine();
        if (change.equalsIgnoreCase("yes")) {
            System.out.println("Your details:");
            System.out.println("Name: " + name);
            System.out.println("CPF: " + cpf);
            System.out.println("Phone: " + phone);
            System.out.println("Which one do you want to change? (Name, CPF, Phone)");
            String fieldToChange = scanner.nextLine().toLowerCase();

            switch (fieldToChange) {
                case "name":
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    hospede.setName(name);
                    break;
                case "cpf":
                    System.out.print("Enter new CPF: ");
                    cpf = scanner.nextLine();
                    hospede.setCPF(cpf);
                    break;
                case "phone":
                    System.out.print("Enter new phone: ");
                    phone = scanner.nextLine();
                    hospede.setPhone(phone);
                    break;
                default:
                    System.out.println("Invalid option. No changes made.");
                    break;
            }

            hospedeDao.update(hospede);

            System.out.println("Updated details:");
            System.out.println("Name: " + hospede.getName());
            System.out.println("CPF: " + hospede.getCPF());
            System.out.println("Phone: " + hospede.getPhone());
            System.out.println();
        }

        System.out.println("Okay " + name + " O que deseja fazer agora?");

    }
}