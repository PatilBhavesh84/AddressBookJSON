package com.bridgelabz;

import java.io.IOException;
import java.util.LinkedList;

public class AddressBook {

    public static void main(String[] args) throws AddressBookException, IOException {
        final String JSON_SIMPLE_FILE_PATH = "D:\\Workspace eclipse\\addressBook\\src\\main\\resourcesJSonSimpleAddressbook.json";
        int flag = 0;
        String filePath = null;
        LinkedList<Person> personList;
        FileOperations fileOperations = new FileOperations();
        final AddressBookService addressBookService = new AddressBookService();

        System.out.println("Create contact using JSON sample");
        filePath = JSON_SIMPLE_FILE_PATH;
                
        while (flag == 0) {
            System.out.println("--- Address Book Management ---\n");
            System.out.println("\t--MENU--");
            System.out.println("1: Add New Person");
            System.out.println("2: Display Records");
            System.out.println("3: Edit Person");
            System.out.println("4: Delete Person");
            System.out.println("5: Sort");
            System.out.println("6: Search");
            System.out.println("7: Exit\n");
            System.out.println("--- Enter Your Choice ---");
            int choice = InputUtil.getIntValue();
            switch (choice) {
		       case 1:
		                personList = fileOperations.getDataInList(filePath);
		                personList = addressBookService.addRecord(personList);
		                fileOperations.convertToFile(personList, filePath);
		            break;
		        case 2:
		                LinkedList<Person> person = fileOperations.getDataInList(filePath);
		                addressBookService.displayRecord(person);
		            break;
		        case 3:
		                personList = fileOperations.getDataInList(filePath);
		                personList = addressBookService.editRecord(personList);
		                fileOperations.convertToFile(personList, filePath);
		
		            break;
		        case 4:
		                personList = fileOperations.getDataInList(filePath);
		                personList = addressBookService.deleteRecord(personList);
		                fileOperations.convertToFile(personList, filePath);
		            break;
		        case 5:
		                personList = fileOperations.getDataInList(filePath);
		                addressBookService.sortRecords(personList);
		            break;
		        case 6:
		                personList = fileOperations.getDataInList(filePath);
		                addressBookService.searchInRecords(personList);
		            break;
		        case 7:
		            flag = 1;
            break;
                default:
                    System.out.println("Please Enter Valid Option!!!");
            }
        }
    }
}