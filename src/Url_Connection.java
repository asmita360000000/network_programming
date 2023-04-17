import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Url_Connection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.gmail.com");
            URLConnection uc = url.openConnection();
            InputStream rawdata = uc.getInputStream();
            InputStream buffer = new BufferedInputStream(rawdata);
            //chain the InputStream to a Reader
            Reader reader = new InputStreamReader(buffer);
            int c;
            while ((c= reader.read())!= -1){
                System.out.print((char)c);
            }
            System.out.println("CONNECTION CREATED");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
