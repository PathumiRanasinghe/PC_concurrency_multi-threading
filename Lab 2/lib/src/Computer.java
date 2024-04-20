import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Computer implements Runnable {
    private SharedQueue queue;
    private int ID;
    private String fileName;

    public Computer(int ID,String fileName,SharedQueue queue) {
        this.ID = ID;
        this.fileName=fileName;
        this.queue=queue;
    }

    
    @Override
    public void run() {
        TextFile textFile=readAFile(fileName,"txt");
        
        PrintJob job=new PrintJob(textFile, "txt");
        
        queue.addPrintJob(job);

    }
      
     

    public TextFile readAFile(String fileName, String fileType) {
        try {
            if (fileName.endsWith(".txt")) {
                FileReader file = new FileReader(fileName);
                BufferedReader br = new BufferedReader(file);
                StringBuilder sb = new StringBuilder();
                String line;

                try {
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                TextFile textfile=new TextFile(sb.toString());
                return textfile;
            } else {
                throw new TypeNotSupportedException("Unsupported file type added: " + fileName);
            }
        } catch (FileNotFoundException e) {
            System.err.println("file not found: " + e.getMessage());
        } catch (TypeNotSupportedException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return null; // or return empty string, depending on your requirement
    }






    
}
