import java.io.Serializable;
import java.time.LocalDate;

public class Internship implements Serializable {
    private String company;
    private String role;
    private Boolean applied;
    private String status;
    private LocalDate deadline;

    public Internship(String company, String role, Boolean applied, String status, LocalDate deadline) {
        this.company = company.toLowerCase();
        this.role = role.toLowerCase();
        this.applied = applied;
        this.status = status.toLowerCase();
        this.deadline = deadline;

    }

    public String getCompany() {
        return this.company;
    }
    public String getRole() {
        return this.role;
    }
    public Boolean getApplied() {
        return this.applied;
    }
    public String getStatus() {
        return this.status;
    }
    public LocalDate getDeadline() {
        return this.deadline;
    }


    public void setCompany(String company) {
        this.company = company;
    } 
    public void setRole(String role) {
        this.role = role;
    }
    public void setApplied(Boolean applied) {
        this.applied = applied;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Internship at " + company + " for the role " + role + " has applied: " + applied 
            + " current status is " + status + " deadline to apply is " + deadline; 
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Internship i) {
            return i.getCompany().equals(company) && i.getRole().equals(role);
        } 
        return false;
    }

}