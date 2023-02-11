package ui;

import model.Doctor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu() throws ParseException {
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book An Appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout.");

            Scanner input = new Scanner(System.in);
            response = Integer.parseInt(input.nextLine());

            switch (response) {
                case 1 -> showBookAppointmentMenu();
                case 2 -> showPatientMyAppointments();
                case 0 -> UIMenu.showMenu();
            }
        } while (response != 0);
    }

    private static void showBookAppointmentMenu() throws ParseException {
        int k = 0;
        int response = 0;

        do {
            System.out.println("::Book An Appointment");
            System.out.println(":: Select Date: ");

            /* Numeración De La Lista De Fechas
            * Indice Fecha Seleccionada
            * [Doctors]
            * 1. - Doctor1
            *   // - 1 Fecha1
            *   // - 2 Fecha2
            * 2. - Doctor2
            *   // - 1 Fecha1
            *   // - 2 Fecha2
            * 3. - Doctor3
            *   // - 1 Fecha1
            *   // - 2 Fecha2
            * */
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();

            for (int i = 0; i < UIDoctorMenu.doctorAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments =
                        UIDoctorMenu.doctorAvailableAppointments.get(i).getAvailableAppointment();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(j, UIDoctorMenu.doctorAvailableAppointments.get(i));
                    doctors.put(k, doctorAppointments);
                }
            }

            Scanner input = new Scanner(System.in);
            int responseDateSelected = Integer.parseInt(input.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);

            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc: doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(
                    doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointment().get(indexDate).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointment().get(indexDate).getTime()
            );

            System.out.println("Confirm Your Appointment: \n1. Yes. \n2. Change Data");
            response = Integer.parseInt(input.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.setAddAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointment().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointment().get(indexDate).getTime());

                showPatientMenu();
            }
        } while (response != 0);
    }

    private static void showPatientMyAppointments() {
        int response = 0;

        do {
            System.out.println("::My Appointments");

            if (UIMenu.patientLogged.getAddAppointmentDoctors().size() == 0) {
                System.out.println("Don't Have Appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAddAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(
                        j + ". "
                        + "Date: " + UIMenu.patientLogged.getAddAppointmentDoctors().get(i).getDate()
                        + "Time: " + UIMenu.patientLogged.getAddAppointmentDoctors().get(i).getTime()
                        + "\n Doctor: " + UIMenu.patientLogged.getAddAppointmentDoctors().get(i).getDoctor().getName()
                );
            }

            System.out.println("0. Return.");
        } while (response != 0);
    }
}
