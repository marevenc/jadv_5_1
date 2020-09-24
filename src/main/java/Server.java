import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4224);

        while(true){
            try(Socket socket = serverSocket.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))){
                String line;
                while ((line = in.readLine()) != null){
                    if(line.equals("end")) break;
                    try{
                        int number = Integer.parseInt(line);
                        out.println(fibNumber(number));
                    } catch (NumberFormatException e){
                        out.println("Введите число");
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    public static long fibNumber(int n){
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
