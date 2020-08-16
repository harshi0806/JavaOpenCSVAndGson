package com.dummyproject;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.bean.CsvtoBean;
import com.opencsv.bean.CsvtoBeanBuilder;

public class OpenCSVAndGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/users.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "./src/main/resources/users.json";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvtoBean<CSVUser> csvtoBean = new csvToBeanBuilder.build(reader);
            List<CSVUser> csvUsers = csvtoBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
