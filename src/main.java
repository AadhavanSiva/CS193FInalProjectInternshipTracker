


void main() {

    int command = 0;

    while (command != 4) {
        try {
            command = Integer.parseInt(IO.readln("Enter a Command 1:Add/remove 2:Import/Export 3:Deadlines 4:Quit :\n"));

            if (command == 1) {
                String addOrRemove = IO.readln("So you want to add or remove(a/r):\n");

                if (addOrRemove.equals("a")) {
                    //will ask for details regarding the new intership to be added and create an
                    //internship object and add it to the list.
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