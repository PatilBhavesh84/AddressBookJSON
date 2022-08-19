package com.bridgelabz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.LinkedList;

public class FileOperations {

    public void convertToFile(LinkedList<Person> addressBook, String filePath) {
                JSONArray personList = new JSONArray();
                for (Person person : addressBook) {
                    JSONObject personDetails = new JSONObject();
                    personDetails.put("First Name", person.getFirstName());
                    personDetails.put("Last Name", person.getLastName());
                    personDetails.put("Phone", person.getPhone());
                    personDetails.put("Address", person.getAddress());
                    personDetails.put("City", person.getCity());
                    personDetails.put("State", person.getState());
                    personDetails.put("Zip", person.getZip());
                    JSONObject personObject = new JSONObject();
                    personObject.put("person", personDetails);
                    personList.add(personObject);
                }
                try {
                    FileWriter fileWriter = new FileWriter(filePath);
                    fileWriter.append(personList.toJSONString());
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }
    public LinkedList<Person> getDataInList(String filePath) throws IOException {

        LinkedList<Person> addressBook = new LinkedList<>();
                JSONParser jsonParser = new JSONParser();
                try {
                    FileReader fileReader = new FileReader(filePath);
                    Object obj = jsonParser.parse(fileReader);
                    JSONArray personList = (JSONArray) obj;
                    personList.forEach(person -> addressBook.add(parseJSONObject((JSONObject) person)));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }        
        return addressBook;
    }
    private Person parseJSONObject(JSONObject personJson) {
        JSONObject personObj = (JSONObject) personJson.get("person");
        return new Person((String) personObj.get("First Name"),
                (String) personObj.get("Last Name"),
                (String) personObj.get("Address"),
                (String) personObj.get("City"),
                (String) personObj.get("State"),
                (String) personObj.get("Zip"),
                (String) personObj.get("Phone"));
    }
}