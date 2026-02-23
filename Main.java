import java.util.ArrayList;
import java.util.List;

/**
 * Bir hastanede 20 doktor, 50 hemşire vardır.
 * Doktorlardan sadece operatör olanlar ameliyata girebilirken
 * bütün hemşireler ameliyata girebilmektedir.
 * Bir ameliyata en az bir doktor, hemşire ise en fazla 5 tane girebilir.
 * Hastalar yılda bir kez ameliyat olabilir ve
 * ayda en fazla 3 kere muayene olabilirler.
 *
 * Bu bilgilere göre aşağıdaki soruların cevaplarını bulun:
 * Bir yılda en çok muayene olan hasta kimdir?
 * Bir ameliyatta oluşan en yüksek maliyet nedir?
 * Ameliyat maliyeti = (amaliyat malzeme adeti x fiyatı) + doktor ücreti
 */


public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Patient ayse = new Patient("Ayse", 0);
        Patient mehmet = new Patient("Mehmet", 0);
        Patient elif = new Patient("Elif", 0);
        Patient can = new Patient("Can", 0);
        hospital.addPatient(ayse);
        hospital.addPatient(mehmet);
        hospital.addPatient(elif);
        hospital.addPatient(can);

        ayse.addCheckup(1);
        ayse.addCheckup(1);
        mehmet.addCheckup(2);
        mehmet.addCheckup(2);
        mehmet.addCheckup(2);
        elif.addCheckup(3);
        can.addCheckup(4);
        can.addCheckup(4);
        can.addCheckup(4);

        List<Doctor> surgeons = getSurgeons(hospital.getDoctors());
        Nurse[] nurses = hospital.getNurses();

        hospital.addSurgeryForPatient(ayse, new Surgery(pickDoctors(surgeons, 1), pickNurses(nurses, 3), 5, 200));
        hospital.addSurgeryForPatient(can, new Surgery(pickDoctors(surgeons, 2), pickNurses(nurses, 5), 8, 150));
        hospital.addSurgeryForPatient(mehmet, new Surgery(pickDoctors(surgeons, 1), pickNurses(nurses, 2), 3, 400));

        Patient topPatient = hospital.getPatientWithMostCheckups();
        if (topPatient != null) {
            System.out.println("Most checkups in a year: " + topPatient.getName());
        }
        System.out.println("Max surgery cost: " + hospital.getMaxSurgeryCost());
        System.out.println("Hospital project started.");
    }

    private static List<Doctor> getSurgeons(Doctor[] doctors) {
        List<Doctor> surgeons = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.canJoinSurgery()) {
                surgeons.add(doctor);
            }
        }
        return surgeons;
    }

    private static List<Doctor> pickDoctors(List<Doctor> doctors, int count) {
        if (doctors.size() < count) {
            throw new IllegalArgumentException("Not enough surgeons to select.");
        }
        return new ArrayList<>(doctors.subList(0, count));
    }

    private static List<Nurse> pickNurses(Nurse[] nurses, int count) {
        if (nurses.length < count) {
            throw new IllegalArgumentException("Not enough nurses to select.");
        }
        List<Nurse> selected = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            selected.add(nurses[i]);
        }
        return selected;
    }
}
