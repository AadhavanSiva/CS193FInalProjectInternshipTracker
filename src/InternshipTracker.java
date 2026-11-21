import java.util.ArrayList;

public class InternshipTracker {


    private ArrayList<Internship> internships;

    public InternshipTracker() {
        this.internships = new ArrayList<>();
    }

    public Boolean add(Internship internship) {
        for (Internship i : internships) {
            if (i.equals(internship)) {
                return false;
            } 
        }
        internships.add(internship);
        return true;
    }
}