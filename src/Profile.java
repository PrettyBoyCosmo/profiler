// Profiler
// Created By : Chris Taylor [C0SM0]

// utility modules
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

// time modules
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// file editing modules
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Profile {

	public static void main(String[] args) {
		// create utility objects
		Scanner s = new Scanner (System.in);
		Random r = new Random();

		// output files
		String output_file = "profiles.txt";

		// first names array
		String[] first_name = {"Emma ", "Olivia ", "Ava ", "Isabella ", "Sophia ", "Charlotte ", "Mia ", "Amelia ", "Harper ", "Evelyn ", "Abigail ", "Emily ",
												   "Elizabeth ", "Mila ", "Ella ", "Avery ", "Sofia ", "Camila ", "Aria ", "Scarlett ", "Victoria ", "Madison ", "Luna ", "Grace ",
												   "Chloe ", "Liam ", "Noah ", "William ", "James ", "Oliver ", "Benjamin ", "Elijah ", "Lucas ", "Mason ", "Logan ", "Alexander ",
												   "Ethan ", "Jacob ", "Michael ", "Daniel ", "Henry ", "Jackson ", "Sebastian ", "Aiden ", "Matthew ", "Samuel ", "David ",
												   "Joseph ", "Carter ", "Owen ", "Penelope ", "Layla ", "Riley ", "Zoey ", "Nora ", "Lily ", "Eleanor ", "Hannah ", "Lillian ",
												   "Addison ", "Aubrey ", "Ellie ", "Stella ", "Natalie ", "Zoe ", "Leah ", "Hazel ", "Violet ", "Aurora ", "Savannah ", "Audrey ",
												   "Brooklyn ", "Bella ", "Claire ", "Skylar ", "Wyatt ", "John ", "Jack ", "Luke ", "Jayden ", "Dylan ", "Grayson ", "Levi ",
												   "Isaac ", "Gabriel ", "Julian ", "Mateo ", "Anthony ", "Jaxon ", "Lincoln ", "Joshua ", "Christopher ", "Andrew ", "Theodore ",
												   "Caleb ", "Ryan ", "Asher ", "Nathan ", "Thomas ", "Leo ", "Lucy ", "Paisley ", "Everly ", "Anna ", "Caroline ", "Nova ",
												   "Genesis ", "Emilia ", "Kennedy ", "Samantha ", "Maya ", "Willow ", "Kinsley ", "Naomi ", "Aaliyah ", "Elena ", "Sarah ",
												   "Ariana ", "Allison ", "Gabriella ", "Alice ", "Madelyn ", "Cora ", "Ruby ", "Eva ", "Isaiah ", "Charles ", "Josiah ",
												   "Hudson ", "Christian ", "Hunter ", "Connor ", "Eli ", "Ezra ", "Aaron ", "Landon ", "Adrian ", "Jonathan ", "Nolan ",
												   "Jeremiah ", "Easton ", "Elias ", "Colton ", "Cameron ", "Carson ", "Robert ", "Angel ", "Maverick ", "Nicholas ", "Dominic ",
												   "Serenity ", "Autumn ", "Adeline ", "Hailey ", "Gianna ", "Valentina ", "Isla ", "Eliana ", "Quinn ", "Nevaeh ", "Ivy ", "Sadie ",
												   "Piper ", "Lydia ", "Alexa ", "Josephine ", "Emery ", "Julia ", "Delilah ", "Arianna ", "Vivian ", "Kaylee ", "Sophie ",
												   "Brielle ", "Madeline ", "Jaxson ", "Greyson ", "Adam ", "Ian ", "Austin ", "Santiago ", "Jordan ", "Cooper ", "Brayden ", "Roman ",
												   "Evan ", "Ezekiel ", "Xavier ", "Jose ", "Jace ", "Jameson ", "Leonardo ", "Bryson ", "Axel ", "Everett ", "Parker ", "Kayden ", "Miles ",
												   "Sawyer ", "Jason "};

		// middle initial
		char middle_initial_input = (char) ('A' + r.nextInt(26));

		// last names array
		String[] last_name = {"Dover ", "Smith ", "Johnson ", "Williams ", "Jones ", "Brown ", "Davis ", "Miller ", "Wilson ", "Moore ", "Taylor ", "Anderson ", "Thomas ",
												  "Jackson ", "White ", "Harris ", "Martin ", "Thompson ", "Garcia ", "Martinez ", "Robinson ", "Clark ", "Lewis ", "Lee ", "Walker ", "Hall ",
											   	"Allen ", "Young ", "Hernandez ", "King ", "Wright ", "Lopez ", "Hill ", "Scott ", "Green ", "Adams ", "Baker ", "Gonzalez ", "Nelson ",
											   	"Carter ", "Mitchell ", "Perez ", "Roberts ", "Turner ", "Phillips ", "Campbell ", "Parker ", "Evans ", "Edwards ", "Collins ", "Stewart ",
											    "Sanchez ", "Morris ", "Rogers ", "Reed ", "Cook ", "Morgan ", "Bell ", "Murphy ", "Bailey ", "Rivera ", "Cooper ", "Richardson ", "Cox ",
											    "Howard ", "Ward ", "Torres ", "Peterson ", "Gray ", "Ramirez ", "James ", "Watson ", "Brooks ", "Kelly ", "Sanders ", "Price ", "Bennett ",
											    "Wood ", "Barnes ", "Ross ", "Henderson ", "Coleman ", "Jenkins ", "Perry ", "Powell ", "Long ", "Patterson ", "Hughes ", "Flores ", "Washington ",
											    "Butler ", "Simmons ", "Foster ", "Gonzales ", "Bryant  ", "Alexander ", "Russell ", "Griffin ", "Diaz ", "Hayes "};

		// month array
		String[] month = {"Jabuary ", "Febuary ", "March ", "April ", "May ", "June ", "July ", "August ", "September ", "October ", "November ", "December "};

		// race/ethinc background
		String[] race = {"White American", "Black American", "American Indian", "Alaska Native", "Asian", "African American", "Native Hawaiian", "Pacific Islander", "Bi-Racial",
										 "Mulatto", "Mestizo", "Itallian American", "French American", "Russian"};

		// street [name] array
		String[] street_name = {"Second ", "Third ", "First ", "Fourth ", "Park ", "Fifth ", "Main ", "Sixth ", "Oak ", "Seventh ", "Pine ", "Maple ", "Cedar ", "Eighth ", "Elm ",
														"View ", "Washington ", "Ninth ", "Lake ", "Hill ", "Church ", "Liberty ", "Walnut ", "Chestnut ", "Union ", "North ", "South ", "East ", "West ",
														"River ", "Water ", "Center ", "Broad ", "Market ", "Cherry ", "Highland ", "Mill ", "Franklin ", "School ", "State ", "Front ", "Back ", "Side ",
														"Prospect ", "Summer ", "Winter ", "Spring ", "Fall ", "Autumn ", "Jefferson ", "Jackson ", "Locust ", "Madison ", "Meadow ", "Spruce ", "Ridge ",
														"Pearl ", "Dogwood ", "Lincoln ", "Pennsylvania ", "Pleasant ", "Adams ", "Academy ", "Green ", "Brown ", "Hickory ", "Virginia ", "Charles ",
														"Elizabeth ", "Colonial ", "Monroe ", "Winding ", "Valley ", "Fairway ", "Delaware ", "Sunset ", "Vine ", "Woodland ", "Brookside ", "Hillside ",
														"College ", "Division ", "Harrison ", "Heather ", "Laurel ", "New ", "Primrose ", "Railroad ", "Willow ", "Berkshire ", "Buckingham ", "Clinton ",
														"George ", "Hillcrest ", "Hillside ", "Penn ", "Durham ", "Grant ", "Hamilton ", "Holly ", "King ", "Lafayette ", "Linden ", "Popular ", "Cambridge ",
														"Clark ", "Essex ", "James ", "Magnolia ", "Myrtle ", "Route ", "Shady ", "Surrey ", "Warren ", "Willams ", "Williamson ", "Wood "};

		// street [abbreviated] array
		String[] street_abbreviation = {"ALY, ", "AVE, ", "BCH, ", "BLVD, ", "CTR, ", "CIR, ", "COR, ", "XING, ", "DR, ", "EXPY, ", "FT, ", "GTWY, ", "GLN, ", "GRV, ", "HBR, ", "HWY, ",
																		"LN, ", "MNR, ", "OVAL, ", "PARK, ", "PASS, ", "PIKE, ", "PLZ, ", "RIV, ", "RD, ", "SHR, ", "SQ, ", "ST, ", "TPKE, ", "VLY, ", "VLG, ", "WAY, "};

		// states [abbreviated] array
		String[] state = { "AL ", "AK ", "AZ ", "AR ", "CA ", "CO ", "CT ", "DE ", "FL ", "GA ", "HI ", "ID ", "IL ", "IN ", "IA ", "KS ", "KY ", "LA ", "ME ", "MD ", "MA ", "MI ", "MN ",
										   "MS ", "MO ", "MT ", "NE ", "NV ", "NH ", "NJ ", "NM ", "NY ", "NC ", "ND ", "OH ", "OK ", "OR ", "PA ", "RI ", "SC ", "SD ", "TN ", "TX ", "UT ", "VT ", "VA ",
										   "WA ", "WV ", "WI ", "WY ", "DC "};

		// city name array
		String[] city = {"Washington ", "Springfield ", "Franklin ", "Greenville ", "Bristol ", "Clinton ", "Fairview ", "Salem ", "Madison ", "Georgetown ", "Alexandria", "Maplewood ",
										 "Cedaroak ", "Liberty ", "Union ", "Highland ", "Franklin ", "Prospect ", "Jefferson ", "Jackson ", "Locust ", "Madison ", "Meadow ", "Spruce ", "Dogwood ",
										 "Lincoln ", "Adams ", "Hickory ", "Charles ", "Elizabeth ", "Colonial ", "Monroe ", "Winding ", "Valley ", "Fairway ", "Vineyard ", "Woodland ", "Brookside ",
										 "Hillside ", "Harrison ", "Heather ", "Primrose ", "Berkshire ", "Buckingham ", "Clinton ", "George ", "Hillcrest ", "Hillside ", "Penn ", "Durham ", "Hamilton ",
										 "Holly ", "Lafayette ", "Linden ", "Cambridge ", "Clark ", "Jameston ", "Magnolia ", "Surrey ", "Warren ", "Willams ", "Williamson "};

		// email domain array
		String[] email = {"@gmail.com", "@yahoo.com", "@me.com", "@microsoft.com", "@icloud.com", "@godaddy.org", "@outlook.com", "@hotmail.com", "@msn.com", "@aol.com"};

		// favorite color array
		String[] color = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Pink", "Brown", "Grey", "White", "Black"};

		// main code
		while (true) {
			// clears terminal
			System.out.print("\033[H\033[2J");
			System.out.flush();

			// outputs banner
			System.out.println(SOURCE_TITLE_COLOR+bannerGenerator()+RESET);
			System.out.println(CONFIRMATION_STATUS_COLOR+"\t\t\t[::]False Identity Profile Generator | v.1[::]\n\t\t\t       [::]Created By : Chris Taylor[::]\n"+RESET);
			System.out.println(HEADER_COLOR+"[::]GitHub : https://github.com/CosmodiumCS/profiler[::]"+RESET);
			String profiles = "";

			// user input
			try {
				// formats terminal user@program
				String term_host = "\n"+INPUT_STATUS_COLOR+"[~] "+RESET+SUB_BANNER_COLOR+"root"+RESET+SOURCE_TITLE_COLOR+"@"+RESET+EXCEPTION_STATUS_COLOR+"profiler "+RESET+SOURCE_TITLE_COLOR+"$ "+RESET;
				// gets number of profiles
				System.out.print(term_host+INPUT_STATUS_COLOR+"How Many Profiles Do You Wish To Generate? : "+RESET);
				int profile_number = s.nextInt();

				// determines whether or not the output will be written to a file
				System.out.print(term_host+INPUT_STATUS_COLOR+"Would You like To Output This To Be Written to \""+output_file+"\"? [y/n]: "+RESET);
				String write_file = s.next();

				// notifies user of progress
				System.out.print(CONFIRMATION_STATUS_COLOR+"\n[*] Generating Profiles...\n"+RESET);

				// initializes output variables
				boolean write_to_file;
				boolean colored_print;

				// formats file output
				if (write_file.equalsIgnoreCase("y") || write_file.equalsIgnoreCase("yes")) {
					write_to_file = true;
					colored_print = false;
				}

				// formats terminal output
				else if (write_file.equalsIgnoreCase("n") || write_file.equalsIgnoreCase("no")) {
					write_to_file = false;
					colored_print = true;
				}

				// exception
				else {
					System.out.println(EXCEPTION_STATUS_COLOR+"\n[!!] Input Not Recognized, Try Again With "+RESET+SOURCE_TITLE_COLOR+
													  "\"y\""+RESET+EXCEPTION_STATUS_COLOR+" for "+RESET+SOURCE_TITLE_COLOR+"\"yes\""+RESET+
													  EXCEPTION_STATUS_COLOR+" or "+RESET+SOURCE_TITLE_COLOR+"\"n\""+RESET+EXCEPTION_STATUS_COLOR+
													  " for "+RESET+SOURCE_TITLE_COLOR+"\"no\"\n"+RESET);
					break;
				}
				// creates colored variable titles if os allows for it
				String title_color;
				String data_color;
				String symbol_color;
				String reset_text;

				if (colored_print == true) {
					title_color = CONFIRMATION_STATUS_COLOR;
					data_color = SOURCE_TITLE_COLOR;
					symbol_color = EXCEPTION_STATUS_COLOR;
					reset_text = RESET;
				}

				else{
					title_color = "";
					data_color = "";
					symbol_color = "";
					reset_text = "";
				}

				for (int i = 0; i < profile_number; i++) {
					// identity variables
					String first_name_input = randomItem(first_name);
					String last_name_input = randomItem(last_name);
					String email_input = randomItem(email);
					String input_month = randomItem(month);
					String name_of_street = randomItem(street_name);
					String abbreviated_street = randomItem(street_abbreviation);
					String name_of_city = randomItem(city);
					String abbreviated_state = randomItem(state);
					String favorite_color = randomItem(color);
					String race_ethnicity = randomItem(race);

					// output variables
					String contact = contactGenerator(first_name_input, middle_initial_input, last_name_input, email_input, title_color, data_color, symbol_color, reset_text);
					String racial_output = String.format("\n%s[+]-----------%s%sRACE%s%s : %s%s%s%s", symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, race_ethnicity, reset_text);
					String dob = dobGenerator(input_month, title_color, data_color, symbol_color, reset_text);
					String location = locationGenerator(name_of_street, abbreviated_street, name_of_city, abbreviated_state, title_color, data_color, symbol_color, reset_text);
					String color_output = String.format("\n%s[+]-%s%sFAVORITE-COLOR%s%s : %s%s%s%s\n", symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, favorite_color, reset_text);

					// counts profiles
					int iterable = i + 1;

					// sets profile header for each profile [written to file]
					profiles += "[+] Profile-"+iterable+":\n=============="+contact+racial_output+dob+location+color_output+"\n";

					// writes output to file
					if (write_to_file == true) {
						System.out.println(writeFile(output_file, profiles, iterable));
					}

					// terminal output
					else {
						// prints profile number
						System.out.print(HEADER_COLOR+"\n[+] Profile-"+RESET+iterable+SUB_BANNER_COLOR+":\n=============="+RESET);

						// outputs contact information [full name, email, phone #, social security #]
						System.out.print(contact);

						// outputs race and ethnic background
						System.out.print(racial_output);

						// outputs date of birth and age
						System.out.print(dob);

						// outputs location
						System.out.print(location);

						// outputs favorite color, possible security question
						System.out.print(color_output);
					}
				}
				break;
			}

			 // exception
			catch (InputMismatchException e){
				System.out.println(EXCEPTION_STATUS_COLOR+"[!!] Input Not Recognized, Enter a Number"+RESET+CONFIRMATION_STATUS_COLOR+"\n[+] i.e "+RESET+SOURCE_TITLE_COLOR+"\"23\""+RESET+"\n");
				break;
			}

		}

	  }

	// confirms use of color based on operating system [os]
	public static String colorDetect(String color, String os) {
		String confirm;

		// confirms color use
		if (os.toLowerCase().indexOf("mac") >= 0 || os.toLowerCase().indexOf("nix") >= 0 || os.toLowerCase().indexOf("nux") >= 0 || os.toLowerCase().indexOf("aix") > 0 ) {
			confirm = color;
		}

		// denies color use
		else {
			confirm = "";
		}

		return confirm;
	}

		// gets operating system [os] distro
		public static final String OS = System.getProperty("os.name");

		// colored variables
    public static final String RESET = colorDetect("\033[0m", OS);  // Text Reset
    public static final String SOURCE_TITLE_COLOR = colorDetect("\033[0;33m", OS);  // YELLOW
    public static final String INPUT_STATUS_COLOR = colorDetect("\033[0;37m", OS);   // WHITE
    public static final String EXCEPTION_STATUS_COLOR = colorDetect("\033[0;31m", OS);// RED
    public static final String CONFIRMATION_STATUS_COLOR = colorDetect("\033[0;36m", OS);    // CYAN
    public static final String HEADER_COLOR = colorDetect("\033[0;35m", OS);  // PURPLE
    public static final String SUB_BANNER_COLOR = colorDetect("\033[0;32m", OS);   // GREEN

	// gets random item from array
	public static String randomItem(String[] array) {
		int r = new Random().nextInt(array.length);

	    return array[r];
	}

	// gets random banner
	public static String bannerGenerator() {
		// banners
		String stargazing_font = "      :::::::::  :::::::::   ::::::::  :::::::::: ::::::::::: :::        :::::::::: ::::::::: \r\n" +
											 			 "     :+:    :+: :+:    :+: :+:    :+: :+:            :+:     :+:        :+:        :+:    :+: \r\n" +
														 "    +:+    +:+ +:+    +:+ +:+    +:+ +:+            +:+     +:+        +:+        +:+    +:+  \r\n" +
													 	 "   +#++:++#+  +#++:++#:  +#+    +:+ :#::+::#       +#+     +#+        +#++:++#   +#++:++#:    \r\n" +
														 "  +#+        +#+    +#+ +#+    +#+ +#+            +#+     +#+        +#+        +#+    +#+    \r\n" +
														 " #+#        #+#    #+# #+#    #+# #+#            #+#     #+#        #+#        #+#    #+#     \r\n" +
														 "###        ###    ###  ########  ###        ########### ########## ########## ###    ###     ";

		String graffiti_font = "__________                _____.__.__                \r\n" +
							         	   "\\______   \\_______  _____/ ____\\__|  |   ___________ \r\n" +
							         	   " |     ___/\\_  __ \\/  _ \\   __\\|  |  | _/ __ \\_  __ \\\r\n" +
							         	   " |    |     |  | \\(  <_> )  |  |  |  |_\\  ___/|  | \\/\r\n" +
							         	   " |____|     |__|   \\____/|__|  |__|____/\\___  >__|   \r\n" +
							         	   "                                            \\/ ";

		// gets and returns random banner
		String[] font_options = {stargazing_font, graffiti_font};
		String banner = randomItem(font_options);

		return "\n"+banner;
	}

	// creates file
	public static String createFile(String file) {
		// creates or checks output file
		try {
		      File outputFile = new File(file);

		      // creates file
		      if (outputFile.createNewFile()) {
		        return CONFIRMATION_STATUS_COLOR+"\n[+] File Created: "+RESET+SOURCE_TITLE_COLOR+outputFile.getName()+RESET;
		      }

		      // checks file
		      else {
		        return EXCEPTION_STATUS_COLOR+"\n[!] File Already Exists...\n"+RESET+CONFIRMATION_STATUS_COLOR+"[+] Continuing Profile Generation..."+RESET;
		      }
		    }

		// exception
		catch (IOException e) {
		      e.printStackTrace();
		      return EXCEPTION_STATUS_COLOR+"\n[!!] Error Creating File"+RESET;
		    }
	}

	// writes to file
	public static String writeFile(String file, String write, int iteration) {
		String profile = "Profile-"+iteration;

		// write file formatting
		try {
		      FileWriter output = new FileWriter(file);

		      // writes output to file
		      output.write(write);
		      output.close();
		      return CONFIRMATION_STATUS_COLOR+"\n[+] Success! "+RESET+SOURCE_TITLE_COLOR+
								 profile+RESET+CONFIRMATION_STATUS_COLOR+" Written To "+RESET+
								 SOURCE_TITLE_COLOR+"\""+file+"\""+RESET;
		    }

		// exception
		catch (IOException e) {
		      e.printStackTrace();
		      return EXCEPTION_STATUS_COLOR+"\n[!!] Error Writing File"+RESET;
		    }
	}

	// full name, email, and phone number generator [contact information]
	public static String contactGenerator(String first, char middle, String last, String domain, String title_color, String data_color, String symbol_color, String reset_text) {
		Random r = new Random();

		// full name formatting
		String fullname_format = symbol_color+"\n[+]-----------"+reset_text+title_color+"NAME"+reset_text+symbol_color+" : "+reset_text+data_color+"%s%c. %s\n"+reset_text;
		String fullname = String.format(fullname_format, first, middle, last);

		// phone number formatting
		int phone_number = r.nextInt(10000 - 1000) + 1000;

		//social security number [ssn] formatting
		int ssn1 = r.nextInt(1000 - 100) + 100;
		int ssn2 = r.nextInt(100 - 10) + 10;

		// email formatting
		String email = first.toLowerCase() + last.toLowerCase() + domain;
		String user_email = email.replaceAll(" ", "");

		// make string variables for password formatting
		String phone = String.valueOf(phone_number);
		String ssn_one = String.valueOf(ssn1);
		String ssn_two = String.valueOf(ssn2);
		String[] password_options = {first, last, phone, ssn_one, ssn_two};

		// create password
		String password_part1 = randomItem(password_options);
		int password_part2 = r.nextInt(1000 - 10) + 10;
		String partone = password_part1.toString();
		String parttwo = String.valueOf(password_part2);

		// password formatting
		String password_unformatted = partone + parttwo;
		String password = password_unformatted.replaceAll(" ", "");

		// return output
		String contact = String.format("%s%s[+]----------%s%sEMAIL%s%s : %s%s%s%s\n%s[+]-------%s%sPASSWORD%s%s : %s%s%s%s\n%s[+]----------%s%sPHONE%s%s : %s%sXXX-XXX-%d%s\n%s[+]------------%s%sSSN%s%s : %s%s%d-%d-XXXX%s",
																	 fullname, symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, user_email, reset_text,
																	 symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, password, reset_text,
																	 symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, phone_number, reset_text,
																	 symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, ssn1, ssn2, reset_text);

		return contact;
	}

	// date of birth [dob] and age generator
	public static String dobGenerator(String birth_month, String title_color, String data_color, String symbol_color, String reset_text) {
		Random r = new Random();

		// get and format current year
		LocalDateTime getTime = LocalDateTime.now();
	    DateTimeFormatter get_year_format = DateTimeFormatter.ofPattern("yyyy");
		String year = getTime.format(get_year_format);
		int current_year = Integer.parseInt(year);

		// maximum and minimum birth years
		int max_year = current_year - 10;
		int min_year = current_year - 65;

		// dob variables
		int birth_year = r.nextInt(max_year - min_year) + min_year;
		int birth_day = r.nextInt(32 - 1) + 1;
		int age = (current_year - birth_year);

		// return output
		String dob = String.format("\n%s[+]------------%s%sDOB%s%s : %s%s%s%d, %s%s\n%s[+]------------%s%sAGE%s%s : %s%s%d Years of Age%s",
															 symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, birth_month, birth_day, birth_year, reset_text,
															 symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, age, reset_text);

		return dob;
	}

	// address and location generator
	public static String locationGenerator(String street, String abbr, String city_name, String state_name, String title_color, String data_color, String symbol_color, String reset_text) {
		Random r = new Random();

		// generate numeric variables
		int address_number = r.nextInt(10000 - 1) + 1;
		int zip_code = r.nextInt(100000 - 10000) + 10000;

		// return output
		String location = String.format("\n%s[+]-------%s%sLOCATION%s%s : %s%s%d %s%s%s%s%d%s", symbol_color, reset_text, title_color, reset_text, symbol_color, reset_text, data_color, address_number, street, abbr, city_name, state_name, zip_code, reset_text);

		return location;
	}


}
