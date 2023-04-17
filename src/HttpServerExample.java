
import java.io.*;
import java.net.*;

    public class HttpServerExample {
        public static void main(String[] args) {
            try {
                ServerSocket serverSocket = new ServerSocket(8080); // Listen on port 8080
                System.out.println("HTTP server listening on port 8080");

                while (true) {
                    Socket clientSocket = serverSocket.accept(); // Wait for client connections
                    System.out.println("New client connected");

                    InputStream input = clientSocket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    String line = reader.readLine();

                    // Print the client request to the console
                    System.out.println("Client request: " + line);

                    // Send the HTTP response
                    OutputStream output = clientSocket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: text/html");
                    writer.println();
                    writer.println("<html><body><h1>Hello, World!</h1></body></html>");

                    // Close the client connection
                    clientSocket.close();
                    System.out.println("Client connection closed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

