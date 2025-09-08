
package tvseries;
import java.util.*;
import java.util.ArrayList;

/**
 * Student name: Oregolele Mangwegape
 * Student number: ST104714814
 * Section A
 */
public class TvSeries {
static Scanner input = new Scanner(System.in);
static List<SeriesModel> seriesList = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    SeriesModel sm = new SeriesModel();
     System.out.println("LATEST SERIES - 2025");
     System.out.println("************************************************");
     
     System.out.print("Enter (1) to launch menu or any other key to exit: ");
      String launch = input.nextLine();
     while(launch.equals("1")){
         menu();
         System.out.print("Enter (1) to launch menu again or any other key to exit: ");
         launch = input.nextLine();
     }  
    }

    private static void menu() {
        System.out.println("Please select one of the following menu items: ");
        System.out.print("(1) Capture a new series." + 
                           "\n(2) Search for a series" +
                           "\n(3) Update series age restriction" +
                           "\n(4) Delete a series" + 
                           "\n(5)Print series report - 2025" +
                           "\n(6) Exit Application\n"
                           
                           
        );
          System.out.print("Please select an option: ");
          String choice = input.nextLine();
              
    switch (choice) {
        case "1":
            CaptureSeries();
            break;
        case "2":
            SearchSeries();
            break;
        case "3":
            UpdateSeries();
            break;
        case "4":
            DeleteSeries();
            break;
        case "5":
            SeriesReport();
            break;
        case "6":
            ExitSeriesApplication();
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
    }
    }

    public static void CaptureSeries() {
        System.out.println();
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("********************");
     
     //enter series ID     
     String  id;
     while(true){
         System.out.print("Enter the series ID: ");
             id = input.nextLine();
         try{
            int userID = Integer.parseInt(id);
            if(userID < 0){
                System.out.print("Invalid ID. Please try again");
              id = input.nextLine();
            }else{
                break;
            }   
         }catch(NumberFormatException e){
             System.out.print("Enter a numeric ID");
         }
}
     
     //enter series name
     System.out.print("enter the series name: ");
     String name = input.nextLine();
     while(name.isEmpty()){
         System.out.println("Please enter a valid name: ");
         name = input.nextLine();
     }
     //enter series  age  restriction
     String age;
               while(true) {   
            System.out.print("Enter the age restriction: ");
            age = input.nextLine();
               try{
                int ageInt = Integer.parseInt(age);
                if(ageInt < 2 || ageInt > 18) {
                    System.out.print("You have entered a incorrect series age!!!.\n Please re-enter the series age >>  ");
                    age = input.nextLine();
                } else {
                    break;
                }
               }catch(NumberFormatException e){
                   System.out.println("Please enter a numeric value:");
               }                 
}
     
//enter the number of episodes
System.out.print("Enter the number of episodes for " + name + " : ");
String episodes = input.nextLine();

System.out.println("Series processed successfully");
//save the added series
SeriesModel sm = new SeriesModel();
seriesList.add(sm);
sm.setSeriesAge(age);
sm.setSeriesID(id);
sm.setSeriesName(name);
sm.setSeriesNumberOfEpisodes(episodes);
    }

public static void UpdateSeries() {
     System.out.println();
     System.out.print("Enter the series id to update: " );
     String id = input.nextLine();
    
     boolean found = false;
     for(SeriesModel sm : seriesList){
        if(sm.getSeriesID().equalsIgnoreCase(id)){
            
        System.out.print("Enter the age restriction: ");
        String age = input.nextLine();
         boolean validAge = false;
        while(!validAge) {
            
                int ageInt = Integer.parseInt(age);
                if(ageInt < 2 || ageInt > 18) {
                    System.out.print("You have entered a incorrect series age!!!.\n Please re-enter the series age >>  ");
                    age = input.nextLine();
                } else {
                    validAge = true;
                }            
}   
        System.out.print("enter the series name: ");
        String name = input.nextLine();
            while(name.isEmpty()){
                System.out.println("Please enter a valid");
                name = input.nextLine();
            }
     
                System.out.print("Enter the number of episodes for " + name + " : ");
                String episodes = input.nextLine();
        
         //save to new updated list 
         sm.setSeriesAge(age);
         sm.setSeriesID(id);
         sm.setSeriesName(name);
         sm.setSeriesNumberOfEpisodes(episodes);
         found = true ;
         break;
        }
    }
}
       public static void SeriesReport() {
        System.out.println();
      if(seriesList.isEmpty()){
          System.out.println("No series have been captured");
          return;
      }
        for(SeriesModel sm : seriesList) {
          System.out.println(sm.SeriesName);
          System.out.println("--------------------------------");
          System.out.println("SERIES ID: " + sm.SeriesID);
          System.out.println("SERIES NAME: " + sm.SeriesName);
          System.out.println("SERIES AGE RESTRICTION: " + sm.SeriesAge);
          System.out.println("NUMBER OF EPISODES: " + sm.SeriesNumberOfEpisodes);
          System.out.println("--------------------------------");
               
      }  
    }

    public static void ExitSeriesApplication() {
        System.exit(0);
    }

    public static void DeleteSeries() {
       System.out.println();
       System.out.print("Enter the series id to delete: ");
       String id = input.nextLine();
        
        for(int i = 0; i < seriesList.size(); i++ ) {
           SeriesModel sm = seriesList.get(i);
           if(sm.SeriesID.equalsIgnoreCase(id)){
               
               System.out.println("Are you sure you want to delete series: " + id + " from the system. Yes(y) to delete");
               String delete = input.nextLine();
               if(delete.equals("y")){
                   seriesList.remove(i);
                   System.out.println("Series with series id: " + id + " was deleted");
               }
           break;
           }
       }
    }

    public static void SearchSeries() {  
    System.out.println();    
    System.out.print("Enter series id to search: "  );
    String searchID = input.nextLine();
    boolean found = false;
    
    for(SeriesModel sm : seriesList){
        if(sm.SeriesID.equals(searchID)){
    System.out.println("--------------------------------------");
    System.out.println("SERIES ID: " + sm.SeriesID );
    System.out.println( "SERIES NAME: " + sm.SeriesName);
    System.out.println("SERIES AGE RESTRICTION: " + sm.SeriesAge);
    System.out.println("SERIES NUMBER OF EPISODES" + sm.SeriesNumberOfEpisodes );
    System.out.println("--------------------------------------");
    found = true;
    break;
                                  }
                              }
    if(!found){
       System.out.println("Series with Series ID: " + searchID + " was not found!"); 
    }
    }
}
        
    
    
    


