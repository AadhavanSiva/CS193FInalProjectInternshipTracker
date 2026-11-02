# Internship Tracker

## Project Goal
Many CS students, including myself, have to apply for hundreds, sometimes thousands of jobs/internships each recruiting season.
Keeping track of each deadline across emails and memory often results in error and makes it hard to follow up on applications 
they haven't heard from.  Since internships are important to me and other students a single website or application to see where 
every application stands would keep all of us more organized.  I am going to build a command line tool using Java.  Ideally, a 
user would be able to input the name of the company, any relevant deadlines, date applied, role, and anything else I deem necessary.
I would most likely use a mixture of classes and a while loop.

## MVP Scope
First, create a simple while loop that knows what to do based on the user's input. keeps looping so the user can perform multiple actions at the same time. 
Second, build the Internship class with all the fields.
Third, create an add method to add internships to a list.
Fourth, create an remove method to remove internships.
Fifth, add an option 2 to export or import new/existing data.
Sixth, building off the export data feature, write a method that writes each internship into a file as a object.
seventh, write an import method that takes in a filename and adds each object from the file name into the list.
eight, add an option 4, Quit. writes any new editions into a binary files and saves.
ninth, add an option 3, to go through the list of internships and find any deadlines that are close(V2).

## Future Plans
Users can edit any field for any internship and the program rejects any invalid input without crashing.
Users can add their own custom fields, for example adding a person who could count as a referral.
Ability to export the database into excel.
Ability to remind user of deadlines

## Tech Stack 
First, for imports and libraries I plan to use java.util.ArrayList, java.io.* for file reading and writing, java.time.LocalDate library for deadline tracking,
java.time.format so that users can type dates as text, additional libraries could be implemented while building. User will be give choices, probably numbers, 
1 could be add or remove internship. If selected the user will be asked for info regarding the internship then the internship will be added.  2 could be 
export/import internships and deadlines, pressing this will simply export/import the fields they want. and 3 could remind the user of internships close to 
their deadline(V2 feature).  All of this can be done in java using a while loop and a class named internship as well as class named users.  User would hold a 
unique id to differentiate between users and a list of internships they applied to.  Internship would also be an object and contain fields related to the internship.
I will be using JDK 25.

