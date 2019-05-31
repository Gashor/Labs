package com.filatov;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestHttpConnection {

    @Test
    public void http_status_code_is_200() throws IOException {
        HttpURLConnection connection;
        String address = "http://localhost";
        connection = (HttpURLConnection) new URL(address).openConnection();
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setConnectTimeout(2500);
        connection.setReadTimeout(2500);
        connection.connect();

        Assert.assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());
    }

    @Test
    public void http_post_request() throws IOException {
        String parameters = "x=3&y=4151&operation=%2B";
        HttpURLConnection connection;
        String address = "http://localhost/calculate";
        connection = (HttpURLConnection) new URL(address).openConnection();
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setConnectTimeout(2500);
        connection.setReadTimeout(2500);

        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(parameters.getBytes());
        outputStream.flush();
        outputStream.close();

        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        Assert.assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());
    }
}
