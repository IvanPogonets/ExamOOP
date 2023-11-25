package com.exam.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter implements Writer{
    @Override
    public void writeData() {
        String path = "file.csv";
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Id,Name,Industry,ContactPerson,Revenue");
            writer.newLine();
            for (Client value : ClientService.getClients().values()) {
                writer.write(value.toString());
                writer.newLine();
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

