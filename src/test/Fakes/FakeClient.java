package Fakes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.Socket;

public class FakeClient
{
    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public FakeClient(String serverAddress) throws Exception
    {
        socket = new Socket(serverAddress, PORT);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public void play() throws Exception
    {
        String response;
        try {
            while (true) {
                response = input.readLine();
                output.println("JOIN");
                output.println("hihi");

                System.out.println(response);
            }
        } catch (Exception e) {
            System.out.println("Can`t connect to the server");
        } finally {
            socket.close();
        }
    }


    public static void main(String [] args)
    {
        try {
            FakeClient client = new FakeClient("localhost");
            client.play();

        } catch (Exception e) {
            System.out.println("Can`t connect to the server");
        }
    }
}