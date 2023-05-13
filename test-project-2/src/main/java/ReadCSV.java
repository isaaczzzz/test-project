import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class ReadCSV {
    public static List<Map<String, String>> read(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader());
        List<Map<String, String>> list = new ArrayList<>();
        csvParser.forEach(csvRecord -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("username", csvRecord.get("username"));
            map.put("password", csvRecord.get("password"));
            map.put("expected", csvRecord.get("expected"));
            list.add(map);
        });
        csvParser.close();
        fileReader.close();
        return list;
    }
}