package TeacherPortal;

public class Student_Information {
   private String studentName;
   private String studentSurname;
   private int studentNumber;
   private int Mathematics;
   private int English;
   private int ConsumerStudies;
   private int BusinessStudies;
   private int Afrikaans;
   private int LifeScience;
   private int LifeOrientation;
   private double Average;
   
    
    //sets the student name
    public void setStudentName(String name){
        studentName = name;
    }
    
    //fetches the student name
    public String getStudentName(){
        return studentName;
    }
    
    //sets the students surname
    public void setStudentSurname(String surname){
        studentSurname = surname;
    }
    
    //fetches the student surname
    public String getStudentSurname(){
        return studentSurname;
    }
    
    //sets the student number
    public void setStudentNumber(int std_no){
        studentNumber = std_no;
    }
    
    //retrieves the student number
    public int getStudentNumber(){
        return studentNumber;
    }
    
    //sets the Afrikaans marks
    public void setAFR(int Afr){
        Afrikaans = Afr;
    }
    
    //retrives the Afrikaans marks
    public int getAFR(){
        return Afrikaans;
    }
    
    //sets the Business studies marks
    public void setBS(int Bs){
        BusinessStudies = Bs;
    }
    
    //retrieves the Business studies marks
    public int getBS(){
        return BusinessStudies;
    }
    
    //sets the consumer studies marks
    public void setCS(int Cs){
        ConsumerStudies = Cs;
    }
    
    //retrieves the consumer studies marks
    public int getCS(){
        return ConsumerStudies;
    }
    
    //sets the English marks
    public void setENG(int Eng){
      English = Eng;  
    }
    
    //retrieves the English marks
    public int getENG(){
        return English;
    }
    
    //sets the Life Orientation marks
    public void setLO(int Lo){
        LifeOrientation = Lo;
    }
    
    //retrieves the Life Orientation marks
    public int getLO(){
        return LifeOrientation;
    }
    
    //sets the Life Science marks
    public void setLS(int Ls){
        LifeScience = Ls;
    }
    
    //retrieves Life Science marks
    public int getLS(){
        return LifeScience;
    }
    //sets the Mathematics  marks
    public void setMATHS(int Math){
        Mathematics = Math;
    }
    
    //retrieves Math marks
    public int getMATHS(){
        return Mathematics;
    }
    public void setAVG(){
        Average = (Afrikaans + BusinessStudies + ConsumerStudies + English + LifeOrientation + LifeScience + Mathematics)/7.0;
        
        
    }
    public double getAVG(){
     return Average;  
    }
}
