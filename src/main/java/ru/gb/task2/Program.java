package ru.gb.task2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Program {
    private static Random random = new Random();
    public static void main(String[] args) {
        prepareFile();
        loadFile();
    }

    private static void doProcess() throws Exception {
        if (random.nextInt(2) == 0){
            throw new Exception("error");
        }
    }

    private static void prepareFile() {

        try (FileWriter fileWriter = new FileWriter("name.txt", false)) {

            fileWriter.write("Anna=4\n");
            fileWriter.write("Elena=5\n");
            fileWriter.write("Marina=6\n");

            //doProcess();

            fileWriter.write("Vladimir=?\n");
            fileWriter.write("Konstantin=?\n");
            fileWriter.write("Ivan=4\n");
            fileWriter.flush();

        }
        catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static int parseInt(String key, String value) throws IncorrectSymbolException {
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e){
            if (!value.equals("?"))
                throw new IncorrectSymbolException("Некорректный символ");
            return key.length();
        }
    }

    private static void loadFile(){
        Map<String, Integer> map =new HashMap<>();
        try (FileReader fileReader = new FileReader("name.txt")){
            char[] buf = new char[256];
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = fileReader.read(buf)) > 0){
                for (int i = 0; i < c; i++){
                    stringBuilder.append(buf[i]);
                }
            }
            String[] parts = stringBuilder.toString().split("\n");
            for (String part : parts){
                String[] rec = part.split("=");
                map.put(rec[0], parseInt(rec[0],rec[1]));
            }
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                System.out.printf("%s = %d\n", e.getKey(), e.getValue());
            }

        }
        catch (IncorrectSymbolException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}

class IncorrectSymbolException extends Exception{
    public IncorrectSymbolException(String message) {
        super(message);
    }
}
