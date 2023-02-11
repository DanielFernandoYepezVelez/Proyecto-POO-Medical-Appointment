package ui;

import model.Doctor;
import model.Patient;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static final String[] MONTHS = {
            "January", "February", "March",
            "April", "May", "June", "July",
            "August", "September", "October",
            "November", "December"
        };

    public static void showMenu() throws ParseException {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1 -> {
                    response = 0;
                    authUser(1);
                    System.out.println("Doctor");
                }
                case 2 -> {
                    response = 0;
                    authUser(2);
                    //showPatientMenu();
                }
                case 0 -> System.out.println("Thank you for you visit");
                default -> System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    private static void authUser(int userType) throws ParseException {
        boolean isEmailCorrect = false;
        Scanner input = new Scanner(System.in);
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Patient> patients = new ArrayList<>();

        doctors.add(new Doctor("Daniel", "danipez.02@gmail.com", "Pediatra"));
        doctors.add(new Doctor("Karen", "karen.02@gmail.com", "Pediatra"));
        doctors.add(new Doctor("Rosa", "rosa.02@gmail.com", "Pediatra"));

        patients.add(new Patient("Lucas", "lucas@gmail.com"));
        patients.add(new Patient("Tomas", "tomas@gmail.com"));
        patients.add(new Patient("Feid", "feid@gmail.com"));

        do {
            System.out.println("Insert Your Email: ");
            String email = input.nextLine();

            if(userType == 1) {
                for (Doctor doctor: doctors) {
                    if (doctor.getEmail().equals(email)) {
                        isEmailCorrect = true;
                        doctorLogged = doctor;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }

            if(userType == 2) {
                for (Patient patient: patients) {
                    if (patient.getEmail().equals(email)) {
                        isEmailCorrect = true;
                        patientLogged = patient;
                        UIMenu.showPatientMenu();
                    }
                }
            }
        } while (!isEmailCorrect);
    }

    static void showPatientMenu() throws ParseException {
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1 -> {
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println((i+1) + ". " + MONTHS[i]);
                    }
                }
                case 2 -> System.out.println("::My appointments");
                case 0 -> showMenu();
            }
        } while (response != 0);
    }
}