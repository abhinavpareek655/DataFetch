package com.example.data2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class HelloController {
    @FXML
    protected TextField name;
    @FXML
    protected TextField fatherName;
    @FXML
    protected ListView<String> result;
    @FXML
    protected void onSearchButtonClick() {
        String name = this.name.getText();
        String fatherName = this.fatherName.getText();


        String file = "src/main/java/com/example/data2/data2.csv";
        BufferedReader reader = null;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            ArrayList<String> data = new ArrayList<>();
            data.add(line);
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");
                if(values[8].toLowerCase().contains(name.toLowerCase()) && values[9].toLowerCase().contains(fatherName.toLowerCase()) ){
                    data.add(line);
                }
            }
            result.getItems().addAll(data);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}