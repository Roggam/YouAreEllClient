package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Id;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
  //  private URL url = new URL("http://zipcode.rocks:8085");
   // HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) throws IOException {
        msgCtrl = m;
        idCtrl = j;
    }

    public List<Id> getIds() {
    return idCtrl.getIds();
    }

    public String postId(String idtoRegister, String githubName) throws JsonProcessingException {
        Id tid = new Id(idtoRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }

    public String makecall(String url, String method, String s1) throws IOException {
        StringBuilder result = new StringBuilder();
        URL urll = new URL(rootURL+url);
        HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
        conn.setRequestMethod(method);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    public String getRootURL() {
        return rootURL;
    }

    public MessageController getMsgCtrl() {
        return msgCtrl;
    }

    public IdController getIdCtrl() {
        return idCtrl;
    }
}
