package com.hongframe.sekiro;

import com.hongframe.sekiro.utils.NamedThreadFactory;

import java.util.concurrent.*;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 20:10
 */
public class RemotingTubeManager {

    private ConcurrentHashMap<CommandCode, RemotingTube<?>> cmd2Tube = new ConcurrentHashMap<CommandCode, RemotingTube<?>>(
            4);

    private RemotingTube<?> tube;

    private ExecutorService executorService;

    public RemotingTubeManager() {
        executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new NamedThreadFactory("remoting-tube-executor", true));
    }

    public void registerTube(CommandCode cmdCode, RemotingTube<?> tube) {
        if (this.cmd2Tube.containsKey(cmdCode)) {
            return;
        }
        this.cmd2Tube.put(cmdCode, tube);
    }

    public RemotingTube<?> getProcessor(CommandCode cmdCode) {
        RemotingTube<?> tube = this.cmd2Tube.get(cmdCode);
        if (tube != null) {
            return tube;
        }
        return this.tube;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }
}
