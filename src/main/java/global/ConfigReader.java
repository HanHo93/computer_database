package global;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties pros;

    public void loadFile(String fileName) throws FileNotFoundException {
        pros = new Properties();
        final InputStream inputStream;
        inputStream = new FileInputStream(fileName);
        try{
            pros.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String property){
        return pros.getProperty(property);
    }
}
