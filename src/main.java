
import java.time.LocalDate;



void add(InternshipTracker internshipTracker) {
    
    String company = repeatUntilValid("Enter the company name:\n");
    

    String role = repeatUntilValid("Enter the role you are applying for:\n");
    

    String applied = repeatUntilValid("Have you applied to this internship(y/n):\n");
    


    while (!(applied.equals("y") || applied.equals("n"))) {
        applied = IO.readln("Have you applied to this internship enter y or n:\n").toLowerCase();
    }
    boolean appliedTF;

    if (applied.toLowerCase().equals("y")) {
        appliedTF = true;
    } else {
        appliedTF = false;
    }

    String status = repeatUntilValid("if you have applied enter the current status(a for accepted, w for waiting, r for rejection):\n");
    status = status.toLowerCase();
    while (!(status.equals("a") || status.equals("w") || status.equals("r"))) {
        status = IO.readln("if you have applied enter the current status(a for accepted, w for waiting, r for rejection):\n").toLowerCase();
    }
    

    boolean notValid = true;
    LocalDate deadline  = null;

    while (notValid) {
        try {
            deadline = LocalDate.parse(IO.readln("Enter the deadline(yyyy-mm-dd):\n"));
            notValid = false;
        } catch (Exception e) {
            IO.println("Please follow the given format for deadline submission");
        }
    }

    Internship internship = new Internship(company, role, appliedTF, status, deadline);
    
    if (internshipTracker.add(internship)) {
        IO.println("Internship at " + company  + " for " + role + " added successfully.");
    } else {
        IO.println("Failed to add internship, likely a duplicate entry.");
    }
}

void remove(InternshipTracker internshipTracker) {
    String company = repeatUntilValid("Enter the company name:\n");
    String role = repeatUntilValid("Enter the role you are applying for:\n");

    if (internshipTracker.remove(company, role)) {
        IO.println("Internship at " + company + " as a " + role + " removed successfully");
    } else {
        IO.println("Internship does not exist.");
    }

}

void export(InternshipTracker internshipTracker) {
    String filename = repeatUntilValidFilename("Enter the file name:\n");


    if (internshipTracker.export(filename)) {
        IO.println("Successfully stored internship data to " + filename);
    } else {
        IO.println("Unable to store internship data to " + filename);
    }
}

void importInternships(InternshipTracker internshipTracker) {
    
    String filename = repeatUntilValidFilename("Enter the file name:\n");

    if (internshipTracker.importInternships(filename)) {
        IO.println("Successfully extracted internship data from " + filename);
    } else {
        IO.println("Failed to extract internship data from " + filename);
    }
}

String repeatUntilValidFilename(String message) {
    String filename = repeatUntilValid(message);
    while ((filename.startsWith(".") || !(filename.endsWith(".ser") || filename.endsWith(".dat")))) {
        filename = repeatUntilValid("Enter the file name(must be a ser or dat file):\n");
    }
    return filename.toLowerCase();
}

String repeatUntilValid(String message) {
    String result = IO.readln(message);
    if (result == null || result.equals("")) {
        while (result == null || result.equals("")) {
            result = IO.readln(message);
        }
    }
    return result.toLowerCase();
} 



void main() {

    int command = 0;
    InternshipTracker internshipTracker = new InternshipTracker();

    while (command != 4) {
        try {
            command = Integer.parseInt(IO.readln("Enter a Command 1:Add/remove 2:Import/Export 3:Deadlines 4:Quit :\n"));

            if (command == 1) {
                String addOrRemove = IO.readln("So you want to add or remove(a/r):\n");

                if (addOrRemove.equals("a")) {

                    add(internshipTracker);
                    

                } else if (addOrRemove.equals("r")) {
                    remove(internshipTracker);
                } else {
                    IO.println("Invalid command. Try again. Enter a for add r for remove.");
                }
            } else if (command == 2) {
                String importOrExport = IO.readln("So you want to import or export(i/e):\n");

                if (importOrExport.equals("e")) {
                    export(internshipTracker);
                } else if (importOrExport.equals("i")) {
                    importInternships(internshipTracker);
                } else {
                    IO.println("Invalid command. Try again. Enter i for import e for export.");
                }
            } else if (command == 3) {
                //V2 featuure. should loop through internship tracker and find internships that have upcoming
                // deadlines.
            } else if (command == 4) {
                IO.println("Thank you for using Aadhavan's Internship tracker, goodbye for now.");
            } else {
                IO.println("Invalid command. Try again.");
            }
        } catch (Exception e) {
            IO.println("Invalid command. Try again.");
        }
    }
}




