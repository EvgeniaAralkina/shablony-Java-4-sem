package org.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MyApplication {
    String fromFile="null";
    String toFile;
    long[] hash;

    public MyApplication(String fromFile, String toFile) {
        this.fromFile = fromFile;
        this.toFile = toFile;
        //start();
    }

    public MyApplication(String toFile) {
        this.toFile = toFile;
        fromFile = "null";
        //start();
    }

    @PostConstruct
    private void start()
    {
        if(fromFile!="null")
        {
            long[] hash = new long[1000];
            int i = 0;
            try (FileReader reader = new FileReader(fromFile))
            {
                int c;
                String str = "";
                while ((c = reader.read()) != -1)
                {
                    while (c != 32 & c != -1)
                    {
                        str += (char) c;
                        c = reader.read();
                    }
                    hash[i] = str.hashCode();
                    str = "";
                    i++;
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            hash = Arrays.copyOf(hash, i);
            this.hash = hash;
            //запись
            try (FileWriter writer = new FileWriter(toFile, false)) {
                for (long j : this.hash) {
                    writer.write(String.valueOf(j));
                    writer.write(" ");
                }
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else{
            try (FileWriter writer = new FileWriter(toFile)) {
                writer.write("null");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @PreDestroy
    private void delete(){
        File file = new File("file1.txt");
        file.delete();
    }
}
