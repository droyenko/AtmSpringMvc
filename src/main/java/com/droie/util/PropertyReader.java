package com.droie.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertyReader {

    private static Logger logger = Logger.getLogger(FileReader.class.getName());

    public Properties getProperties(String propFileName) {
        Properties prop = new Properties();

        try (InputStream fis = new FileInputStream(propFileName)) {
            prop.load(fis);
        } catch (FileNotFoundException e) {
            logger.error("PropertyReader.getProperties method FileNotFoundException exception", e);
        } catch (IOException e) {
            logger.error("PropertyReader.getProperties method IOException exception", e);
        }
        return prop;
    }
}
