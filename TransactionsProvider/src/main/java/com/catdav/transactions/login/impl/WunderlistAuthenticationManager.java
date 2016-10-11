package com.catdav.transactions.login.impl;

import com.catdav.transactions.exceptions.LoginException;
import com.catdav.transactions.exceptions.PropertiesRetrievalException;
import com.catdav.transactions.login.AuthenticationManager;
import com.catdav.transactions.providers.PropertiesProvider;
import com.catdav.transactions.providers.impl.FilePropertiesProvider;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class WunderlistAuthenticationManager implements AuthenticationManager {
  private static final Logger LOG = Logger.getLogger(WunderlistAuthenticationManager.class);
  public static final String PROPERTIES_FILE_LOCATION = "wunderlist.properties";
  private PropertiesProvider propertiesProvider;


  public WunderlistAuthenticationManager() {
    propertiesProvider = new FilePropertiesProvider();
  }

  @Override
  public String login() throws LoginException {
    Properties properties = getProperties();
    URI authorizationUri = getFullAuthorizationUri(properties);

    String authorizationCode = getAuthorizationCode(authorizationUri);
    return null;
  }

  private URI getFullAuthorizationUri(Properties properties) throws LoginException {
    String baseUrl = getAuthorizationUrl(properties);
    URIBuilder builder = new URIBuilder();
    builder.setScheme("https").setHost(baseUrl)
        .setParameter("client_id", getClientId(properties))
        .setParameter("redirect_uri", getRedirectUri(properties))
        .setParameter("state", "abcabc");
    try {
      return builder.build();
    } catch (URISyntaxException e) {
      throw new LoginException("Cannot build authorization URI.", e);
    }
  }

  private String getAuthorizationCode(URI authorizationUrl) throws LoginException {
    LOG.info("Sending authorization request for uri:"+authorizationUrl);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpGet httpRequest = new HttpGet(authorizationUrl);

    HttpResponse httpResponse = null;
    try {
      httpResponse = httpClient.execute(httpRequest);
      int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
      if (responseStatusCode != HttpStatus.SC_MOVED_TEMPORARILY) {
        throw new LoginException(
            "Authorization request ended with response status code different from 302. The actual status code is "
            + responseStatusCode);
      }

      String redirectUrl = httpResponse.getFirstHeader("Location").getValue();
      if (redirectUrl == null) {
        throw new LoginException("Received response does not have a header with name 'Location'.");
      }

      System.out.println(redirectUrl);
      return null;
    } catch (IOException e) {
      throw new LoginException("Cannot send request to url:" + authorizationUrl, e);
    }
  }

  private String getAuthorizationUrl(Properties properties) {
    return properties.getProperty("wunderlist.authorization.url");
  }

  private String getClientId(Properties properties) {
    return properties.getProperty("wunderlist.client.id");
  }

  private String getRedirectUri(Properties properties) {
    return properties.getProperty("wunderlist.redirect.uri");
  }

  private Properties getProperties() throws LoginException {
    try {
      return propertiesProvider.getProperties(PROPERTIES_FILE_LOCATION);
    } catch (PropertiesRetrievalException e) {
      throw new LoginException("Login failed, because an error occured while reading properties.", e);
    }
  }
}
