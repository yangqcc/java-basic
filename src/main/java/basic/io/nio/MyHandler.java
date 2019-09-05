package basic.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-09-02
 * @modified By yangqc
 */
public class MyHandler { // ...
   /* public void run() { // initial state is reader
        socket.read(input);
        if (inputIsComplete()) {
            process();
            sk.attach(new Sender());  //状态迁移, Read后变成write, 用Sender作为新的callback对象
            sk.interest(SelectionKey.OP_WRITE);
            sk.selector().wakeup();
        }
    }

    class Sender implements Runnable {
        @Override
        public void run() { // ...
            socket.write(output);
            if (outputIsComplete()) sk.cancel();
        }
    }*/
}

class Reactor implements Runnable {
    private final Selector selector;
    private final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException { //Reactor初始化
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        //非阻塞
        serverSocket.configureBlocking(false);
        //分步处理,第一步,接收accept事件
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //attach callback object, Acceptor
        sk.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()) {
                    //Reactor负责dispatch收到的事件
                    dispatch((SelectionKey) (it.next()));
                }
                selected.clear();
            }
        } catch (IOException ex) { /* ... */ }
    }

    private void dispatch(SelectionKey k) {
        //调用之前注册的callback对象
        Runnable r = (Runnable) (k.attachment());
        if (r != null) {
            r.run();
        }
    }

    class Acceptor implements Runnable { // inner
        @Override
        public void run() {
            try {
                SocketChannel c = serverSocket.accept();
                if (c != null) {
                    new Handler(selector, c);
                }
            } catch (IOException ex) { /* ... */ }
        }
    }
}

final class Handler implements Runnable {
    private final SocketChannel socket;
    private final SelectionKey sk;
    private ByteBuffer input = ByteBuffer.allocate(1024);
    private ByteBuffer output = ByteBuffer.allocate(1024);
    private static final int READING = 0, SENDING = 1;
    private int state = READING;

    Handler(Selector sel, SocketChannel c) throws IOException {
        socket = c;
        c.configureBlocking(false);
        // Optionally try first read now
        sk = socket.register(sel, 0);
        //将Handler作为callback对象
        sk.attach(this);
        //第二步,接收Read事件
        sk.interestOps(SelectionKey.OP_READ);
        sel.wakeup();
    }

    private boolean inputIsComplete() {
        return true;
    }

    private boolean outputIsComplete() {
        return true;
    }

    private void process() { /* ... */ }

    @Override
    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            }
        } catch (IOException ex) { /* ... */ }
    }

    private void read() throws IOException {
        socket.read(input);
        if (inputIsComplete()) {
            process();
            state = SENDING;
            // Normally also do first write now
            //第三步,接收write事件
            sk.interestOps(SelectionKey.OP_WRITE);
        }
    }

    private void send() throws IOException {
        socket.write(output);
        if (outputIsComplete()) {
            sk.cancel(); //write完就结束了, 关闭select key
        }
    }
}


