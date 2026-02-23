public class Doctor {
    public enum DoctorRole {
        SURGEON,
        SPECIALIST,
        GENERAL_PRACTITIONER
    }

    private final DoctorRole role;
    private final int fee;

    public Doctor(DoctorRole role, int fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("Doctor fee cannot be negative.");
        }
        this.role = role;
        this.fee = fee;
    }

    public DoctorRole getRole() {
        return role;
    }

    public int getFee() {
        return fee;
    }

    public boolean canJoinSurgery() {
        return role == DoctorRole.SURGEON;
    }
}
