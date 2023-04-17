
import java.net.*;

    public class URLConnectionExample {
        public static void main(String[] args) {
            try {
                URL url = new URL("http://www.facebook.com");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();
                System.out.print("Response code: " + responseCode);
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


