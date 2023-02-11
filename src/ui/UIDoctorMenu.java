package ui;

import model.Doctor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() throws ParseException {
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment.");
            System.out.println("2. My Scheduled Appointments.");
            System.out.println("0. Logout.");

            Scanner input = new Scanner(System.in);
            response = Integer.parseInt(input.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;

                case 2:
                    break;

                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void showAddAvailableAppointmentsMenu() throws ParseException {
        int response = 0;

        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select A Month: ");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }

            System.out.println("0. Return");

            Scanner input = new Scanner(System.in);
            response = Integer.parseInt(input.nextLine());

            if (response > 0 && response < 4) {
                int monthSelected = response;
                System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected - 1]);

                System.out.println("Insert The Date Available: [dd/mm/yyyy]");
                String date = input.nextLine();

                System.out.println("Your Date Is: " + date+ "\n1. Correct \n2. Change Date");
                int responseDate = Integer.parseInt(input.nextLine());

                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";

                do {
                    System.out.println("Insert The Time Available For Date: " + date + " [16:00]");
                    time = input.nextLine();

                    System.out.println("Your Time Is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.parseInt(input.nextLine());
                } while (responseTime == 2);

                UIMenu.doctorLogged.setAvailableAppoint(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            } else if (response == 0) {
                showDoctorMenu();
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor) {
        if (doctor.getAvailableAppointment().size() > 0 && !doctorAvailableAppointments.contains(doctor)) {
            doctorAvailableAppointments.add(doctor);
        }
    }

}