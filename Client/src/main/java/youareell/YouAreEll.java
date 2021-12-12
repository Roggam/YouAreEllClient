package youareell;

import controllers.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public class YouAreEll {

    TransactionController tt;
    MessageController messageController;
    IdController idController;


    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public YouAreEll(MessageController messageController, IdController idController) throws IOException {
//       this.messageController = messageController;
//       this.idController = idController;
       this.tt = new TransactionController(messageController, idController);
    }

    public static void main(String[] args) throws IOException {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    private String MakeURLCall(String s, String method, String s1) throws IOException {

      return tt.makecall(s,method,s1);

    }

    public String get_ids() throws IOException {
    return MakeURLCall("/ids", "GET", "");

    }

    public String get_messages() throws IOException {
        return MakeURLCall("/messages", "GET", "");

    }


}
