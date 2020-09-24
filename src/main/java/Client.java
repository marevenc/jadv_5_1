import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4224);

        try (BufferedReader in = new BufferedReader((
                     new InputStreamReader(socket.getInputStream())));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)){

            String msg;
            while (true){
                System.out.println("Введите порядковый номер числа Фибоначчи, которое хотите вычислить:");
                System.out.println("Если хотите выйти, введите end");
                msg = scanner.nextLine();
                out.println(msg);
                if("end".equals(msg)) break;
                System.out.println("SERVER: " + in.readLine());
            }
        }
    }
}
