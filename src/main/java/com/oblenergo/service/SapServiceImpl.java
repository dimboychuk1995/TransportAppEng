package com.oblenergo.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SapServiceImpl implements SapService {

    private static final Logger LOGGER = Logger.getLogger(SapServiceImpl.class);

    private static final String URL = "http://obl-java:8080/SOAPEmpoyee/PersonSearch";
    private static final String ACCEPT_HEADER = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
    private static final String ACCEPT_ENCODING_HEADER = "gzip, deflate";
    private static final String ACCEPT_LANGUAGE_HEADER = "ru,en-US;q=0.8,en;q=0.6,uk;q=0.4";
    private static final String CONNECTION_HEADER = "keep-alive";
    private static final String CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";
    private static final String USER_AGENT_HEADER = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36";
    private static final String EMPTY_FIELD = "";
    private static final String ONLY_COMMUNIC_REQUIRED_VALUE = "X";
    private static final String TASK_REQUIRED_VALUE = "COMMUNIC";

    @Override
    public void httpConnectorForSap(int tabNamber) {

        HttpPost post = new HttpPost(URL);

        post.setHeader("Accept", ACCEPT_HEADER);
        post.setHeader("Accept-Encoding", ACCEPT_ENCODING_HEADER);
        post.setHeader("Accept-Language", ACCEPT_LANGUAGE_HEADER);
        post.setHeader("Connection", CONNECTION_HEADER);
        post.setHeader("Content-Type", CONTENT_TYPE_HEADER);
        post.setHeader("User-Agent", USER_AGENT_HEADER);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("task", TASK_REQUIRED_VALUE));
        urlParameters.add(new BasicNameValuePair("employee_id", Integer.toString(tabNamber)));
        urlParameters.add(new BasicNameValuePair("last_name", EMPTY_FIELD));
        urlParameters.add(new BasicNameValuePair("first_name", EMPTY_FIELD));
        urlParameters.add(new BasicNameValuePair("org_name", EMPTY_FIELD));
        urlParameters.add(new BasicNameValuePair("job_name", EMPTY_FIELD));
        urlParameters.add(new BasicNameValuePair("org_id", EMPTY_FIELD));
        urlParameters.add(new BasicNameValuePair("job_id", EMPTY_FIELD));
        urlParameters.add(new BasicNameValuePair("only_communic", ONLY_COMMUNIC_REQUIRED_VALUE));
        urlParameters.add(new BasicNameValuePair("tel_ats", EMPTY_FIELD));

        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Wrong request parameters encoding", e);
        }

        try {
            HttpResponse response = HttpClientBuilder.create().build().execute(post);
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(responseString);
        } catch (IOException e) {
            LOGGER.error("Can`t get response from" + URL, e);
        }
    }

}
