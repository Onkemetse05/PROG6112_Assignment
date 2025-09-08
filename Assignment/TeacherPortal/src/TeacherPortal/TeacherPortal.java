
package TeacherPortal;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Student name: Oregolele Mangwegape
 * Student number: ST10471814
 * Question 2
 */
public class TeacherPortal {

    static Scanner input = new Scanner(System.in);
    static Scanner num = new Scanner(System.in);
    public static ArrayList<Student_Information> studentInformation = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("****** - STUDENT - ******"); 
       System.out.println("*********************************");
       System.out.println();
       
       //launches the student portal
       System.out.println("Enter (1) to open the student portal. ");
       String open = input.nextLine();
       while(open.equals("1")){
           portal();  
       }  
    } 
    private static void portal(){
        System.out.println("*****************************************");
        System.out.println("*** - WELCOME TO THE TEACHER PORTAL - ***");
        System.out.println("*****************************************");
        System.out.println();
        System.out.print("(1) Capture a learners marks." + 
                           "\n(2) Search for a learner" +
                           "\n(3) Search learners using student number" +
                           "\n(4) Update learners marks " + 
                           "\n(5)Print top achievers " +
                           "\n(6) Exit portal\n"                    
         );
        System.out.println("Where would you like to go? ");
        String option = input.nextLine();
        
        switch(option){
        case "1":
            CaptureMarks();
            break;
        case "2":
            SearchLearner();
            break;
        case "3":
            SearchStudentNumber();
            break;
        case "4":
            UpdateMarks();
            break;
        case "5":
            PrintTopAchievers();
            break;
        case "6":
            ExitPortal();
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
     }  
     
    }
    public static void CaptureMarks(){
        System.out.println();
        System.out.println("***********************");
        System.out.println("*CAPTURE LEARERS MARKS*");
        System.out.println("***********************");
        System.out.println();
        
        String regex = "^[A-Za-z]+([ -][A-Za-z]+)*$"; 
        
        //enter learners name
        System.out.print("Enter the student name: ");
        String name = input.nextLine().trim();
        while(!Pattern.matches(regex, name)){
        System.out.print("Please enter valid name: ");
        name = input.nextLine().trim();
        }
        
        //enter learners surname
        System.out.print("Enter the student surname: ");
        String surname = input.nextLine().trim();
        while(!Pattern.matches(regex, surname)){
            System.out.print("Enter a valid surname: ");
            surname = input.nextLine().trim();
        }
        
        //generate 6 digit student number student ID
        Random number = new Random();
        int std_no = 100000 + number.nextInt(900000); 
        System.out.println("Generated student number: " + std_no);
        
    // Enter valid marks for all subjects
    int afr = getValidMark("Afrikaans");
    int bs = getValidMark("Business Studies");
    int cs = getValidMark("Consumer Studies");
    int eng = getValidMark("English");
    int lo = getValidMark("Life Orientation");
    int ls = getValidMark("Life Science");
    int maths = getValidMark("Mathematics");

    // Save information
    Student_Information si = new Student_Information();
    si.setStudentName(name);
    si.setStudentSurname(surname);
    si.setStudentNumber(std_no);
    si.setAFR(afr);
    si.setBS(bs);
    si.setCS(cs);
    si.setENG(eng);
    si.setLO(lo);
    si.setLS(ls);
    si.setMATHS(maths);
    si.setAVG();

    studentInformation.add(si);

    System.out.println("Student information successfully captured!!!");
    }
    
    public static void SearchLearner(){
     System.out.println("*************************");
     System.out.println("***STUDENT INFORMATION***");
     System.out.println("*************************");   
     System.out.println();
     System.out.print("Enter the full name of the student you're looking for: ");
     String fullname = input.nextLine().trim();
     boolean found = false;
     
     for(Student_Information si : studentInformation){
         String studentName = si.getStudentName() + " " + si.getStudentSurname();
         if(studentName.equals(fullname)){
             System.out.println();
             System.out.println("******************************************");
             System.out.println("STUDENT NUMBER: " + si.getStudentNumber());
             System.out.println("STUDENT NAME: " + si.getStudentName());
             System.out.println("STUDENT SURNAME: " + si.getStudentSurname());
             System.out.println("AFRIKAANS: " + si.getAFR());
             System.out.println("BUSINESS STUDIES: " + si.getBS());
             System.out.println("CONSUMER STUDIES: " + si.getCS());
             System.out.println("ENGLISH: " + si.getENG());
             System.out.println("LIFE ORIENTATION: " + si.getLO());
             System.out.println("LIFE SCIENCE: " + si.getLS());
             System.out.println("MATHEMATICS: " + si.getMATHS());
             System.out.println("******************************************");
      
             found = true;
         }
     }
     if(!found){
         System.out.println("No student with the name " + fullname + ".");
     }
     System.out.println();
    }
    
    public static void SearchStudentNumber(){
      System.out.println("*************************");
      System.out.println("***STUDENT INFORMATION***");
      System.out.println("*************************");
      System.out.println();
      System.out.print("Enter the student number you're looking for: ");
      int studentID = num.nextInt();
      boolean foundIt = false;

        for (Student_Information si : studentInformation) {
          if (si.getStudentNumber() == studentID) {
            System.out.println();
            System.out.println("*******************");
            System.out.println("STUDENT NUMBER: " + si.getStudentNumber());
            System.out.println("STUDENT NAME: " + si.getStudentName());
            System.out.println("STUDENT SURNAME: " + si.getStudentSurname());
            System.out.println("*******************");
            foundIt = true;
            break;
        }
    }

        if (!foundIt) {
            System.out.println("Student number " + studentID + " does not exist or was entered incorrectly");
    }
            System.out.println();
    }  
    
    public static void UpdateMarks(){
            System.out.println("Enter the student name you wish to fix marks for: ");
            String fullname = input.nextLine().trim();

             boolean found = false;

    for (Student_Information si : studentInformation) {
        String studentName = si.getStudentName() + " " + si.getStudentSurname();
        if (studentName.equalsIgnoreCase(fullname)) {  // case-insensitive
            found = true;

            // Get valid marks for all 7 subjects
            si.setAFR(getValidMark("Afrikaans"));
            si.setBS(getValidMark("Business Studies"));
            si.setCS(getValidMark("Consumer Studies"));
            si.setENG(getValidMark("English"));
            si.setLO(getValidMark("Life Orientation"));
            si.setLS(getValidMark("Life Science"));
            si.setMATHS(getValidMark("Mathematics"));
            si.setAVG();

            System.out.println("Student marks successfully updated!");
            System.out.println("New average: " + si.getAVG() + "%");
            break;
        }
    }

    if (!found) {
        System.out.println("Student not found.");
    }
    }
    public static void PrintTopAchievers(){
       if (studentInformation.isEmpty()) {
        System.out.println("There are no students on record.");
        return;
    }

    Student_Information topStudent = studentInformation.get(0);
    topStudent.setAVG();

    for (Student_Information s : studentInformation) {
        s.setAVG();
        if (s.getAVG() > topStudent.getAVG()) {
            topStudent = s;
        }
    }

    System.out.println("***** TOP ACHIEVER *****");
    System.out.println(topStudent.getStudentName() + " " + topStudent.getStudentSurname() +
            " - AVG: " + topStudent.getAVG() + "%");
    }
    
    public static void ExitPortal(){
        System.exit(0);
    }
    
    // the use of this method is to shorten repition of loops for each subject
    public static int getValidMark(String subject) {
    int mark = -1;
    while (true) {
        System.out.print("Enter " + subject + " marks: ");
        if (num.hasNextInt()) {
            mark = num.nextInt();
            if (mark >= 0 && mark <= 100) {
                break;
            } else {
                System.out.println("Enter valid marks (0–100).");
            }
        } else {
            System.out.println("Invalid input! Only numbers allowed. Try again.");
            num.next();
        }
    }
    return mark;
}
}
