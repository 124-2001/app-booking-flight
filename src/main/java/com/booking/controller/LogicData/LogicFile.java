package com.booking.controller.LogicData;

import com.google.gson.Gson;

import java.io.*;

public class LogicFile {
    public void WriteFile(String json,String url){
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
    public void ReadFile(Object object,String url) throws FileNotFoundException {
        Gson gson = new Gson();
        // Đọc dữ liệu từ File với File và FileReader
        File file = new File(url);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {
            String line = reader.readLine();
            while (line != null) {
                object = gson.fromJson(line,Object.class);
                line = reader.readLine();
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
    }
}
