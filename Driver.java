import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();
        
        // Menu Loop
        // I figured it was better to implement the menu not using a while loop and just call the menu back when needed
        displayMenu();
    
    }
    

    // This method prints the menu options
    public static void displayMenu() {
        
        
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
    	switch (userInput) {
    		case "1": 
    			intakeNewDog(scanner);
    			break;
    		case "2": 
    			intakeNewMonkey(scanner);
    			break;
    		case "3": 
    			reserveAnimal(scanner);
    			break;
    		case "4": 
    			printAnimals("4");
    			break;
    		case "5": 
    			printAnimals("5");
    			break;
    		case "6": 
    			printAnimals("6");
    			break;
    		case "q":
    			System.out.println("You have exited the application.");
    			System.exit(0);
    		default:
    			System.out.println("Invalid option. Please try again.");
    			displayMenu();
    	}
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey newMonkey1 = new Monkey("George", "Capuchan", "male", "2", "24", "10", "24", "24", "Jun 6 2022", "USA", "training", false, "USA");
    	
    	monkeyList.add(newMonkey1);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                displayMenu(); //returns to menu
            }
        }
        System.out.println("Enter breed:");
        String breed = scanner.nextLine();
        System.out.println("Enter gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter age:");
        String age = scanner.nextLine();
        System.out.println("Enter weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter acquisition date:");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Enter reserved status (true/false):");
        // input validation
        boolean reserved = false;
    	while(true){
    		try {
    	    reserved = scanner.nextBoolean();
    	    break;
    	} catch (InputMismatchException e) {
    	    System.out.println("Invalid input. Please enter either true or false.");
    	    scanner.next(); // clear the scanner buffer
    	}
    	}
    	scanner.nextLine();
        System.out.println("Enter country in service:");
        
        String inServiceCountry = scanner.nextLine();
         
        // instantiating a new dog and adding  it to the appropriate list
        Dog newDog1 = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog1);
        // return to menu
        displayMenu();
        
        
        
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
        	String [] allowedMonkeySpecies = {"Capuchin","Guenon","Macaque","Marmoset","Squirrel monkey","Tamarin"};
        	System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    displayMenu(); //returns to menu
                }
                }
                
                	// If monkey is not in system, user enters info for new monkey
                	//
                	System.out.println("Enter species type: ");
                	String species = scanner.nextLine();
                	
                	// species validation
                	boolean speciesAllowed = false;
                    for (String allowedSpecies : allowedMonkeySpecies) {
                        if (species.equalsIgnoreCase(allowedSpecies)) {
                            speciesAllowed = true;
                            break;
                        }
                    }
                    if (!speciesAllowed) {
                        System.out.println("\n\nThis species is not allowed.\n\n");
                        displayMenu(); // returns to menu
                    }
                    // user continues to enter info for in-take 
                	System.out.println("Enter gender: ");
                	String gender = scanner.nextLine();
                	System.out.println("Enter age: ");
                	String age = scanner.nextLine();
                	System.out.println("Enter weight: ");
                	String weight = scanner.nextLine();
                	System.out.println("Enter tail length: ");
                	String monkeyTailLength = scanner.nextLine();
                	System.out.println("Enter height: ");
                	String monkeyHeight = scanner.nextLine();
                	System.out.println("Enter body length: ");
                	String monkeyBodyLength = scanner.nextLine();
                	System.out.println("Enter the date of acquisition: ");
                	String acquisitionDate = scanner.nextLine();
                	System.out.println("Enter country of acquisition: ");
                	String acquisitionCountry = scanner.nextLine();
                	System.out.println("Enter training status: ");
                	String trainingStatus = scanner.nextLine();
                	
                	System.out.println("Enter reserved (true/false): ");
                	// validating input
                	boolean reserved = false;
                	while(true){
                		try {
                	    reserved = scanner.nextBoolean();
                	    break;
                	} catch (InputMismatchException e) {
                	    System.out.println("Invalid input. Please enter either true or false.");
                	    scanner.next(); // clear the scanner buffer
                	}
                	}
                	scanner.nextLine();
                	
                	System.out.println("Enter the country of service:  ");
                	String inServiceCountry = scanner.nextLine();
                	
                	// Creating new monkey object
                	Monkey monkey1 = new Monkey(name, species, gender, age, weight, monkeyTailLength, monkeyHeight, monkeyBodyLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                	//Adding new monkey object to monkeyList
                	monkeyList.add(monkey1);
                	// return to menu
                	displayMenu();
       
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Enter animal type: ");
            String type = scanner.next();
            System.out.println("Enter in service country: ");
            String country = scanner.next();
            if (type.equalsIgnoreCase("Dog")) {
            for (int i = 0; i<dogList.size(); i++) {
            	if(dogList.get(i).getInServiceLocation().equals(country)) {
            		dogList.get(i).setReserved(true);
            		break;
            		}
            	}
            	displayMenu();
            }
            
            else if(type.equalsIgnoreCase("Monkey")){
            	for(int i = 0; i<monkeyList.size(); i++) {
            		if (monkeyList.get(i).getInServiceLocation().equals(country)){
            			monkeyList.get(i).setReserved(true);
            			break;
            		}
            	}
            	displayMenu();
            }

        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String choice) {
        	
        	// print all dogs
            if (choice.equals("4")) {
            	System.out.println("Name\tTraining Status\t\tAcquisition Country\tReserved");
            	for(int i = 0; i<dogList.size();i++) {
            		System.out.println(dogList.get(i).getName()+"\t"+ dogList.get(i).getTrainingStatus()+"\t\t\t"+dogList.get(i).getAcquisitionLocation()+"\t\t"+ dogList.get(i).getReserved());
            	}
            	displayMenu();
            }
            // print all monkeys
            else if (choice.equals("5")) {
            	System.out.println("Name\tTraining Status\t\tAcquisition Country\tReserved");
            		for(int i = 0; i<monkeyList.size(); i++) {
            			System.out.println(monkeyList.get(i).getName()+"\t"+ monkeyList.get(i).getTrainingStatus()+"\t\t\t"+monkeyList.get(i).getAcquisitionLocation()+"\t\t"+ monkeyList.get(i).getReserved());
            		}
            		displayMenu();
            	}
            // print all available
            else if(choice.equals("6")) {
            	System.out.println("Name\tTraining Status\t\tAcquisition Country\tReserved");
            	for (int i = 0; i<dogList.size(); i++) {
            		if(!dogList.get(i).getInServiceLocation().isEmpty() && !dogList.get(i).getReserved()) {
            			System.out.println(dogList.get(i).getName()+"\t"+ dogList.get(i).getTrainingStatus()+"\t\t\t"+dogList.get(i).getAcquisitionLocation()+"\t\t"+ dogList.get(i).getReserved());
            		}
            	}
            	for (int i = 0; i<monkeyList.size(); i++) {
            		if(!monkeyList.get(i).getInServiceLocation().isEmpty() && !monkeyList.get(i).getReserved()) {
            			System.out.println(monkeyList.get(i).getName()+"\t"+ monkeyList.get(i).getTrainingStatus()+"\t\t\t"+monkeyList.get(i).getAcquisitionLocation()+"\t\t"+ monkeyList.get(i).getReserved());
            		}
            		displayMenu();
            	}
           }
      }  
}

