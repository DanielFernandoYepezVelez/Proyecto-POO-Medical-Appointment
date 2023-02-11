package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String speciality;
    private final ArrayList<AvailableAppointment> availableAppointment = new ArrayList<>();

    // Constructor Method
    public Doctor(String name, String email) {
        super(name, email);
    }

    public Doctor(String name, String email, String speciality) {
        super(name, email);
        this.speciality = speciality;
    }

    public void setAvailableAppoint(String date, String time) throws ParseException {
        this.availableAppointment.add(new Doctor.AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment() {
        return this.availableAppointment;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSpeciality: " + speciality +
                "\nAvailable: " + availableAppointment.toString();
    }

    @Override
    public void showDateUser() {
        System.out.println("Empleado Del Hospital: Cruz Roja.");
        System.out.println("Departamento: Geriatría");
    }

    // TODO: Tema De Las Clases Estáticas Anidadas
    public static class AvailableAppointment {
        private int id_availableAppointment;
        private Date date;
        private String time;
        private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) throws ParseException {
            this.date = format.parse(date);
            this.time = time;
        }

        public int getId_availableAppointment() {
            return id_availableAppointment;
        }

        public void setId_availableAppointment(int id_availableAppointment) {
            this.id_availableAppointment = id_availableAppointment;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments =>" +
                    " Date: " + date +
                    " Time: " + time + "\n";
        }
    }
}