package basic.io.io.server;

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
 * <p>description:
 * NIO
 * <p>
 * 所需要的Channel是根据SelectorProvider()决定的Provider
 * <p>
 * linux的借用epoll()模型
 *
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-05-06
 * @modified By yangqc
 */
public class NIoServer {

    private int port = 8000;
    private InetSocketAddress address = null;
    private Selector selector;

    public NIoServer(int port) {
        try {
            this.port = port;
            address = new InetSocketAddress(port);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(address);
            //服务端设置成给阻塞模式
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            while (true) {
                //select()也是阻塞的
                int wait = this.selector.select();
                if (wait == 0) {
                    continue;
                }
                //key就相当于原来的 ClientA/B/C
                Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    process(key);
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(SelectionKey selectionKey) throws IOException {
        //ByteBuffer底层就是数组
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        if (selectionKey.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel client = serverSocketChannel.accept();
            client.configureBlocking(false);
            //接下来表示可以读了
            client.register(this.selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            int len = socketChannel.read(buffer);
            if (len > 0) {
                buffer.flip();
                String content = new String(buffer.array(), 0, len);
                socketChannel.register(selector, SelectionKey.OP_WRITE);
                System.out.println(content);
            }
            buffer.clear();
        } else if (selectionKey.isWritable()) {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            socketChannel.write(ByteBuffer.wrap("Hello,World!".getBytes()));
            socketChannel.close();
        }

    }

}
