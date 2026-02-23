import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static final int DOCTOR_COUNT = 20;
    private static final int NURSE_COUNT = 50;
    private static final int SURGEON_COUNT = 6;
    private static final int SPECIALIST_COUNT = 10;
    private static final int GENERAL_PRACTITIONER_COUNT = 4;
    private static final int SURGEON_FEE = 1500;
    private static final int SPECIALIST_FEE = 1000;
    private static final int GENERAL_PRACTITIONER_FEE = 700;

    private final Doctor[] doctors;
    private final Nurse[] nurses;
    private final List<Patient> patients;
    private final List<Surgery> surgeries;

    public Hospital() {
        doctors = new Doctor[DOCTOR_COUNT];
        nurses = new Nurse[NURSE_COUNT];
        patients = new ArrayList<>();
        surgeries = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < SURGEON_COUNT; i++) {
            doctors[index++] = new Doctor(Doctor.DoctorRole.SURGEON, SURGEON_FEE);
        }
        for (int i = 0; i < SPECIALIST_COUNT; i++) {
            doctors[index++] = new Doctor(Doctor.DoctorRole.SPECIALIST, SPECIALIST_FEE);
        }
        for (int i = 0; i < GENERAL_PRACTITIONER_COUNT; i++) {
            doctors[index++] = new Doctor(Doctor.DoctorRole.GENERAL_PRACTITIONER, GENERAL_PRACTITIONER_FEE);
        }

        for (int i = 0; i < nurses.length; i++) {
            nurses[i] = new Nurse();
        }
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public Nurse[] getNurses() {
        return nurses;
    }

    public void addPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        patients.add(patient);
    }

    public void addSurgeryForPatient(Patient patient, Surgery surgery) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        if (surgery == null) {
            throw new IllegalArgumentException("Surgery cannot be null.");
        }
        patient.addSurgery(surgery);
        surgeries.add(surgery);
    }

    public Patient getPatientWithMostCheckups() {
        return patients.stream()
            .max((a, b) -> Integer.compare(a.getCheckupCount(), b.getCheckupCount()))
            .orElse(null);
    }

    public int getMaxSurgeryCost() {
        return surgeries.stream()
            .mapToInt(surgery -> surgery.getMaterialCost() + surgery.getDoctorFeeTotal())
            .max()
            .orElse(0);
    }
}
