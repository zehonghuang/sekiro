package com.hongframe.sekiro;

import com.hongframe.sekiro.config.UserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 21:23
 */
public abstract class AbstractRemotingServer extends AbstractLifeCycle implements RemotingServer {

    private static final Logger logger = LoggerFactory.getLogger(AbstractRemotingServer.class);

    private String ip;
    private int port;

    public AbstractRemotingServer(int port) {
        this(new InetSocketAddress(port).getAddress().getHostAddress(), port);
    }

    public AbstractRemotingServer(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void startup() {
        super.startup();

        try {
            init(config());
            if(start()) {
                logger.warn("Server started on port {}", port);
            } else {
                logger.warn("Failed starting server on port {}", port);
                throw new LifeCycleException("Failed starting server on port: " + port);
            }
        } catch (Throwable e) {
            this.shutdown();
            throw new IllegalStateException("ERROR: Failed to start the Server!", e);
        }
    }

    protected abstract UserConfig config();

    protected abstract void init(UserConfig config);

    protected abstract boolean start() throws InterruptedException;

    protected abstract void stop0();

    @Override
    public String ip() {
        return this.ip;
    }

    @Override
    public int port() {
        return this.port;
    }
}
