import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> namesList = new ArrayList<>(List.of("Justin", "Dustin", "Austin", "Bustin"));
        ArrayList<HashSet<String>> countriesList = new ArrayList<>();
        countriesList.add(new HashSet<>(List.of("Canada", "England", "Russia")));
        countriesList.add(new HashSet<>(List.of("Mexico", "Germany", "Thailand", "England")));
        countriesList.add(new HashSet<>(List.of("China", "Japan", "Brazil", "Canada", "Mexico")));
        countriesList.add(new HashSet<>(List.of("Spain", "Belgium", "China", "Thailand", "Vietnam")));

        
        while(true){

            System.out.println("Please make a selection: ");
            System.out.println("(A) Search for people who visited a country");
            System.out.println("(B) Add a country to a person's set of visited countries");
            System.out.println("(C) List the countries a person has visited");
            System.out.println("(Q) Quit");
            String selection = sc.nextLine();
            
            if(selection.equalsIgnoreCase("A")){
            System.out.println("What country would you like to search for?");
            String searchCountry = sc.nextLine();
            System.out.println(String.format("The following people have visited %s ", searchCountry));
            for (int i = 0; i < countriesList.size(); i++){
                HashSet<String> countriesVisited = countriesList.get(i);
                if (countriesVisited.contains(searchCountry)){
                    System.out.println(namesList.get(i));
                }
            }
        }
        // people.stream().anyMatch(p-> p.equalsIgnoreCase(input))
        else if(selection.equalsIgnoreCase("B")){
            System.out.println("Who would you like to add a country to?");
            String nameToAddCountry = sc.nextLine();
            if(namesList.stream().anyMatch(p-> p.equalsIgnoreCase(nameToAddCountry))){
                int index = namesList.indexOf(nameToAddCountry);
                String name = namesList.get(index);
                HashSet<String> countries = countriesList.get(index);
                System.out.println(String.format("What country would you like to add for %s ? ", name));
                String countryToAdd = sc.nextLine();
                countriesList.get(index).add(countryToAdd);
                System.out.println(String.format("%s was added to %s's list.", countryToAdd, name));
                
                
                // System.out.println(name);
                // for(String c: countries){
                    //     System.out.println(c);
                    // }
                    
                    
                    
                }
                else{
                    System.out.println("No matches for that name.");
                }
        }
        else if(selection.equalsIgnoreCase("C")){
            System.out.println("Who would you like to see the countries they've visited?");
            String searchName = sc.nextLine();
            if(namesList.stream().anyMatch(p-> p.equalsIgnoreCase(searchName))){
                int index = namesList.indexOf(searchName);
                String name = namesList.get(index);
                HashSet<String> countries = countriesList.get(index);
                System.out.println(String.format("%s has been to these countries...", searchName));
                for (String c: countries){
                    System.out.println(c);
                }
            }
            
        }
        else if(selection.equalsIgnoreCase("D")){
            System.out.println("Thank you and goodbye!");
            break;
            
        }
        else{
            System.out.println("Invalid choice.");
        }
    }
    }
}
