package proyectoapp;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombre;
        String email;
        String password;
        int edad;

        System.out.print("Ingrese su nombre: ");
        nombre = sc.nextLine();

        do {
            System.out.print("Ingrese su edad (debe ser mayor o igual a 18): ");
            edad = sc.nextInt();
        } while (edad < 18);

        sc.nextLine();
        System.out.print("Ingrese su email: ");
        email = sc.nextLine();

        do {
            System.out.print("Ingrese una contraseña (más de 6 caracteres): ");
            password = sc.nextLine();
        } while (password.length() <= 6);

        System.out.println("Registro completado:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Email: " + email);

        sc.close();
    }
}
