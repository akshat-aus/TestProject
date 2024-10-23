import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prescription {

    // Attributes
    private String firstName;
    private String lastName;
    private String address;
    private double sphere;
    private double cylinder;
    private int axis;
    private String eyeExamDate;
    private String optometristName;
    private int remarkCount = 0;

    // Constructor
    public Prescription(String firstName, String lastName, String address, double sphere, double cylinder, int axis, String eyeExamDate, String optometristName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.eyeExamDate = eyeExamDate;
        this.optometristName = optometristName;
    }

    // Method to add prescription to a text file
    public boolean addPrescription() {
        if (validatePrescription()) {
            try (FileWriter writer = new FileWriter("presc.txt", true)) {
                writer.write("Prescription:\n");
                writer.write("Name: " + firstName + " " + lastName + "\n");
                writer.write("Address: " + address + "\n");
                writer.write("Sphere: " + sphere + ", Cylinder: " + cylinder + ", Axis: " + axis + "\n");
                writer.write("Eye Exam Date: " + eyeExamDate + "\n");
                writer.write("Optometrist: " + optometristName + "\n\n");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Method to validate the prescription details
    private boolean validatePrescription() {
        if (firstName.length() < 4 || firstName.length() > 15) return false;
        if (lastName.length() < 4 || lastName.length() > 15) return false;
        if (address.length() < 20) return false;
        if (sphere < -20.00 || sphere > 20.00) return false;
        if (cylinder < -4.00 || cylinder > 4.00) return false;
        if (axis < 0 || axis > 180) return false;
        if (!validateDate(eyeExamDate)) return false;
        if (optometristName.length() < 8 || optometristName.length() > 25) return false;
        return true;
    }

    // Method to validate date format (DD/MM/YY)
    private boolean validateDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            sdf.setLenient(false);
            Date parsedDate = sdf.parse(date);
            return parsedDate != null;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to add remark to a text file
    public boolean addRemark(String remark, String category) {
        if (remarkCount >= 2) return false;  // Limit to 2 remarks
        if (!category.equals("client") && !category.equals("optometrist")) return false;

        String[] words = remark.split(" ");
        if (words.length < 6 || words.length > 20) return false;
        if (!Character.isUpperCase(remark.charAt(0))) return false;

        try (FileWriter writer = new FileWriter("review.txt", true)) {
            writer.write("Remark: " + remark + "\nCategory: " + category + "\n\n");
            remarkCount++;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
