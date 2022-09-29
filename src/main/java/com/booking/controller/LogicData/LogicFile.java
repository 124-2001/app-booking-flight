package com.booking.controller.LogicData;

import com.booking.model.Flight;
import com.booking.model.User;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogicFile {
    public void WriteStringJsonToFile(String json,String url){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File(url);
            // if file  exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(json+"\n");
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //list user
    public List<User> ConvertFileToUser() throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        Gson gson = new Gson();
        // Đọc dữ liệu từ File với File và FileReader
        File file = new File("list_user.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file)); 
        try {
            String json = reader.readLine();
            while (json != null) {
                User user = gson.fromJson(json, User.class);
                users.add(user);
                json = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                reader.close();
                // file.close();
            } catch (IOException ex) {
            }
        }
        return users;
    }

    //list flight
    public List<Flight> ConvertFileToFlight() throws FileNotFoundException {
        List<Flight> flights = new ArrayList<>();
        Gson gson = new Gson();
        // Đọc dữ liệu từ File với File và FileReader
        File file = new File("list_user.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {
            String json = reader.readLine();
            while (json != null) {
                Flight flight = gson.fromJson(json, Flight.class);
                flights.add(flight);
                json = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                reader.close();
                // file.close();
            } catch (IOException ex) {
            }
        }
        return flights;
    }

}
