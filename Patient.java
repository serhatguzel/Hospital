import java.util.ArrayList;
import java.util.List;

public class Patient {
    private static final int MAX_SURGERIES_PER_YEAR = 1;
    private static final int MAX_CHECKUPS_PER_MONTH = 3;

    private final String name;
    private int surgeryCount;
    private final int[] monthlyCheckups;
    private final List<Surgery> surgeries;

    public Patient(String name, int surgeryCount) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        validateSurgeryCount(surgeryCount);

        this.name = name;
        this.surgeryCount = surgeryCount;
        this.monthlyCheckups = new int[12];
        this.surgeries = new ArrayList<>();
    }

    public Patient(int surgeryCount) {
        this("Unknown", surgeryCount);
    }

    public String getName() {
        return name;
    }

    public int getSurgeryCount() {
        return surgeryCount;
    }

    public void setSurgeryCount(int surgeryCount) {
        validateSurgeryCount(surgeryCount);
        this.surgeryCount = surgeryCount;
    }

    public int getCheckupCount() {
        int total = 0;
        for (int count : monthlyCheckups) {
            total += count;
        }
        return total;
    }

    public int getMonthlyCheckupCount(int month) {
        int index = getMonthIndex(month);
        return monthlyCheckups[index];
    }

    public void addCheckup(int month) {
        int index = getMonthIndex(month);
        int current = monthlyCheckups[index];
        if (current >= MAX_CHECKUPS_PER_MONTH) {
            throw new IllegalArgumentException(
                "Checkups per month cannot exceed " + MAX_CHECKUPS_PER_MONTH + "."
            );
        }
        monthlyCheckups[index] = current + 1;
    }

    public void addSurgery(Surgery surgery) {
        if (surgery == null) {
            throw new IllegalArgumentException("Surgery cannot be null.");
        }
        if (surgeryCount >= MAX_SURGERIES_PER_YEAR) {
            throw new IllegalArgumentException("A patient can have at most one surgery per year.");
        }
        surgeries.add(surgery);
        surgeryCount++;
    }

    private void validateSurgeryCount(int surgeryCount) {
        if (surgeryCount < 0 || surgeryCount > MAX_SURGERIES_PER_YEAR) {
            throw new IllegalArgumentException(
                "Surgery count must be between 0 and " + MAX_SURGERIES_PER_YEAR + " per year."
            );
        }
    }

    private int getMonthIndex(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        return month - 1;
    }
}
