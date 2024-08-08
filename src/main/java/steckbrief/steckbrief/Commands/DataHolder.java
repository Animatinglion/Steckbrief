package steckbrief.steckbrief.Commands;
import java.util.List;
import org.yaml.snakeyaml.Yaml;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class DataHolder {
    public List<String> names;
    public List<String[]> arrays;


    public DataHolder(List<String[]> arrays, List<String> names) {
        this.arrays = arrays;
        this.names = names;
    }

    public void LoadDataHolder(String[] args) {
        // Create a new instance of the Yaml class
        Yaml yaml = new Yaml();

        // Read the data from the .yml file
        try (FileReader reader = new FileReader("data.yml")) {
            try {
                DataHolder dataHolder = yaml.load(reader);
                this.names = dataHolder.names;
                this.arrays = dataHolder.arrays;
            } catch(Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataHolder(String[] args) {
        // Create a new instance of the Yaml class
        Yaml yaml = new Yaml();

        // Create a new DataHolder object to hold the list of arrays
        DataHolder dataHolder = new DataHolder(arrays,names);

        // Save the data to a .yml file
        try (FileWriter writer = new FileWriter("data.yml")) {
            yaml.dump(dataHolder, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
