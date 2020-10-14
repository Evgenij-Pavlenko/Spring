package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    File file = new File("fortune.txt");
    BufferedReader br;
    List<String> data = new ArrayList<>();

    {
        try {
            FileReader fr = new FileReader("src/main/resources/fortune.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                data.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private Random rnd = new Random();

    @Override
    public String getFortune() {
        int index = rnd.nextInt(data.size());
        return index + " index: " + data.get(index);
    }
}
