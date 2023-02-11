package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private final ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAddAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void setAddAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);

        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAddAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAddAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    public Patient(String name, String email) {
        super(name, email);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return weight + " Kg.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAge: " + birthday +
                "\nWeight: " + getWeight() +
                "\nHeight: " + getHeight() +
                "\nBlood: " + blood;
    }

    @Override
    public void showDateUser() {
        System.out.println("Paciente");
        System.out.println("Historial Completo Desde El Nacimiento");
    }
}