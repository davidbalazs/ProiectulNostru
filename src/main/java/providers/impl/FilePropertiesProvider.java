package providers.impl;

import exceptions.PropertiesRetrievalException;
import providers.PropertiesProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by David on 10/4/2016.
 */
public class FilePropertiesProvider implements PropertiesProvider {
    public Properties getProperties(String location) throws PropertiesRetrievalException {
        final InputStream stream = this.getClass().getClassLoader().getResourceAsStream(location);

        if (stream == null) {
            throw new PropertiesRetrievalException("Cannot find resource from classpath: " + location);
        }

        final Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new PropertiesRetrievalException("Cannot open file", e);
        }

        return properties;
    }
}
