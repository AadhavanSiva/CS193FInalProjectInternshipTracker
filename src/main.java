
import java.time.LocalDate;
 



void main() {

    int command = 0;
    InternshipTracker internshipTracker = new InternshipTracker();

    while (command != 4) {
        try {
            command = Integer.parseInt(IO.readln("Enter a Command 1:Add/remove 2:Import/Export 3:Deadlines 4:Quit :\n"));

            if (command == 1) {
                String addOrRemove = IO.readln("So you want to add or remove(a/r):\n");

                if (addOrRemove.equals("a")) {


                    String company = IO.readln("Enter the company name:\n");

                    if (company == null || company.equals("")) {
                        while (company == null || company.equals("")) {
                            company = IO.readln("Enter the company name(can't be null):\n");
                        }
                    }

                    String role = IO.readln("Enter the role you are applying for:\n");
                    if (role == null || role.equals("")) {
                        while (role == null || role.equals("")) {
                            role = IO.readln("Enter the role you are applying for(can't be null):\n");
                        }
                    }

                    String applied = IO.readln("Have you applied to this internship(y/n):\n");
                    if (applied == null || applied.equals("")) {
                        while (applied == null|| applied.equals("")) {
                            applied = IO.readln("Have you applied to this internship(can't be null):\n");
                        }
                    }


                    if (!(applied.equals("y") || applied.equals("n"))) {
                        while (!(applied.equals("y") || applied.equals("n"))) {
                            applied = IO.readln("Have you applied to this internship enter y or n:\n");
                        }
                    }

                    boolean appliedTF;

                    if (applied.toLowerCase().equals("y")) {
                        appliedTF = true;
                    } else {
                        appliedTF = false;
                    }

                    String status = IO.readln("if you have applied enter the current status(a for accepted, w for waiting, r for rejection):\n");
                    if (status == null || status.equals("")) {
                        while (status == null|| status.equals("")) {
                            status = IO.readln("if you have applied enter the current status(a for accepted, w for waiting, r for rejection)(can't be null):\n");
                        }
                    }

                    status = status.toLowerCase();
                    if (!(status.equals("a") || status.equals("w") || status.equals("r")) ) {
                        while (!(status.equals("y") || status.equals("n"))) {
                            status = IO.readln("if you have applied enter the current status(a for accepted, w for waiting, r for rejection)(can't be null):\n");
                        }
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

                } else if (addOrRemove.equals("r")) {
                    //will ask for details regarding the intership to be removed and will remove it from the list.
                } else {
                    IO.println("Invalid command. Try again. Enter a for add r for remove.");
                }
            } else if (command == 2) {
                String importOrExport = IO.readln("So you want to import or export(i/e):\n");

                if (importOrExport.equals("i")) {
                    //will ask for file to import data to, then runs a method that loops through the given file
                    // by reading each one as an object and adding it to internship tracker.
                } else if (importOrExport.equals("e")) {
                    // will ask for file, create the filename then write each internship from internship tracker
                    // as an object.
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