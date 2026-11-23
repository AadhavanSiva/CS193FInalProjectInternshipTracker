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

    public boolean remove(String company, String role) {
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getCompany().equals(company) && internships.get(i).getRole().equals(role)) {
                internships.remove(i);
                return true;
            }
        }
        return false;
    }
}