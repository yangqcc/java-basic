package basic.io.io.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>title:BIO</p>
 * <p>description:
 * JDK1.4 IO方式 之前都是BIO
 * 文件流 磁盘进行交互
 * 网络流 网络中进行交互
 * <p>
 * 如何把BIO的同步非阻塞改成非阻塞
 * <p>
 * 阻塞和非阻塞
 * <p>
 * 能不能同时读写操作
 * <p>
 * 用数组方式实现读写操作
 * Channel 多路复用
 * Selector 选择器
 * Buffer 缓冲区
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-05-06
 * @modified By yangqc
 */
public class BIoServer {

    /**
     * 单线程操作
     */
    public static void serve() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("服务端启动成功，监听端口为8000,等待客户端连接。。。");
            //阻塞，客户端
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, len));
            }
            //向客户端写数据
            outputStream = socket.getOutputStream();
            outputStream.write("hello,everybody".getBytes());
            outputStream.close();
        } catch (Exception e) {
            System.out.println("出错了,抛出异常!");
        }
    }

    public void server2() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 手动创建线程改为线程池方式
     */
    public void server3() {
        ServerSocket serverSocket = null;
        Executor executor = Executors.newFixedThreadPool(60);
        try {
            serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                executor.execute(new ServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BIoServer.serve();
    }
}
