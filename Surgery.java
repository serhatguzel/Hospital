import java.util.List;

public class Surgery {
    private static final int MIN_DOCTORS = 1;
    private static final int MAX_NURSES = 5;

    private final List<Doctor> doctors;
    private final List<Nurse> nurses;
    private final int materialCount;
    private final int materialPrice;

    public Surgery(List<Doctor> doctors, List<Nurse> nurses, int materialCount, int materialPrice) {
        if (doctors == null || doctors.isEmpty()) {
            throw new IllegalArgumentException("At least one doctor is required.");
        }
        if (doctors.size() < MIN_DOCTORS) {
            throw new IllegalArgumentException("Doctor count must be at least " + MIN_DOCTORS + ".");
        }
        if (nurses == null) {
            throw new IllegalArgumentException("Nurses list cannot be null.");
        }
        if (nurses.size() > MAX_NURSES) {
            throw new IllegalArgumentException("Nurse count must be at most " + MAX_NURSES + ".");
        }
        if (materialCount < 0) {
            throw new IllegalArgumentException("Material count cannot be negative.");
        }
        if (materialPrice < 0) {
            throw new IllegalArgumentException("Material price cannot be negative.");
        }
        for (Doctor doctor : doctors) {
            if (doctor == null || !doctor.canJoinSurgery()) {
                throw new IllegalArgumentException("All doctors must be surgeons.");
            }
        }

        this.doctors = doctors;
        this.nurses = nurses;
        this.materialCount = materialCount;
        this.materialPrice = materialPrice;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public int getMaterialCount() {
        return materialCount;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }

    public int getMaterialCost() {
        return materialCount * materialPrice;
    }

    public int getDoctorFeeTotal() {
        int total = 0;
        for (Doctor doctor : doctors) {
            total += doctor.getFee();
        }
        return total;
    }
}
