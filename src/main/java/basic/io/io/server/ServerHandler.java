package basic.io.io.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-06
 * @modified By yangqc
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) > 0) {
                System.out.println(new String(bytes, 0, len));
            }
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello every body".getBytes());
            outputStream.close();
        } catch (Exception e) {

        }
    }
}
