import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InternshipTracker {


    private ArrayList<Internship> internships;

    public InternshipTracker() {
        this.internships = new ArrayList<>();
    }

    public boolean add(Internship internship) {
        for (Internship i : internships) {
            if (i.equals(internship)) {
                return false;
            } 
        }
        internships.add(internship);
        return true;
    }

    public boolean remove(String company, String role) {
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getCompany().equals(company) && internships.get(i).getRole().equals(role)) {
                internships.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean export(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Internship i : internships) {
                oos.writeObject(i);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean importInternships(String filename) {
        int success = 0;
        int failed = 0;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Internship internship = (Internship) ois.readObject();
            while (true) {
                if (add(internship)) {
                    IO.println(internship.toString() + " added successfully.");
                    success++;
                } else {
                    IO.println(internship.toString() + " failed to add, likely a duplicate.");
                    failed++;
                }
                internship = (Internship) ois.readObject();
            }
        } catch (EOFException e) {
            IO.println(success + " internships successfully added");
            IO.println(failed + " internships failed to add, likely a duplicates");
            return true;
        } catch (Exception e) {
            IO.println("File not found please ensure your file exists");
            return false;
        }
        
    }
}