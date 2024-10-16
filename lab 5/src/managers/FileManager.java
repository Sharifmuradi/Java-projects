package managers;

import java.io.*;

public class FileManager {
    private String path;
    public FileManager (String path){
        this.path = path;
    }
    public String read (){
        StringBuilder csv = new StringBuilder();
        try {
            if (path == null || path.equals("")) throw new Exception ("File path wasn't passed!!!!!");
            File file = new File(path);
            if (!file.exists()) throw new Exception("File doesn't exist!!!") ;
            if (!file.canRead()) throw new Exception  ("File can't be read!!!");
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            int character = 0;
            while ((inputStream.read())!=-1)
                csv.append((char) character);
            inputStream.close();
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }
        return csv.toString();
    }
    public boolean write (String csv)throws  Exception{
        boolean isWritten = false;
        try{
            if (path == null || path.equals("")) path = "File.csv";
            File file = new File(path);
            if (!file.exists() || !file.getName().contains(".csv")){
                System.out.println("File doesn't exist creating new file.");
                createNewFile();
            }
            BufferedWriter writer =  new BufferedWriter(new FileWriter(file));
            writer.write(csv);
            writer.close();
            isWritten = true;
        }catch (Exception exception ){
            throw new Exception(exception.getMessage());
        }
        return isWritten;
    }
    private boolean createNewFile (){
        try{
            File file = new File(path);
            return file.createNewFile();
        }catch (Exception exception ){
            System.err.println(exception.getMessage());
            return false;
        }
    }
}
