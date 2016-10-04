package providers;

import exceptions.PropertiesRetrievalException;

import java.io.File;
import java.util.Properties;

/**
 * Created by David on 10/4/2016.
 */
public interface PropertiesProvider {
    Properties getProperties(String location) throws PropertiesRetrievalException;
}
