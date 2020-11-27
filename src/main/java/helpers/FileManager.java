package helpers;

import com.opencsv.bean.*;

import beans.Contact;

import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    private static final String HOME_PATH = System.getProperty("user.home");
    private static final String FILENAME = "contacts.csv";

    private final Path fileLocation;

    public FileManager() throws Exception {
        var separator = FileSystems.getDefault().getSeparator();
        var filepath = String.format("%s%s%s", HOME_PATH, separator, FILENAME);
        fileLocation = Paths.get(filepath);

        if (Files.exists(fileLocation)) return;
        Files.createFile(fileLocation);
    }

    public List<Contact> readFile() throws Exception {
        try (var reader = Files.newBufferedReader(fileLocation, Charset.defaultCharset());) {
            String[] fields = {"phone", "name"};
            var strategy = new ColumnPositionMappingStrategy<Contact>();
            strategy.setType(Contact.class);
            strategy.setColumnMapping(fields);

            var csvToBean = new CsvToBeanBuilder<Contact>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void writeFile(List<Contact> contacts) throws Exception {
        try (var writer = Files.newBufferedWriter(fileLocation, Charset.defaultCharset());) {
            var beanToCsv = new StatefulBeanToCsvBuilder<Contact>(writer)
                    .build();
            beanToCsv.write(contacts);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
