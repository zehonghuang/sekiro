package com.hongframe.sekiro.demo;

import com.hongframe.sekiro.config.UserConfig;
import com.hongframe.sekiro.rpc.SekiroServer;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 10:47
 */
public class DemoSekiroServer {

    private SekiroServer sekiroServer;

    public void start() {
        sekiroServer = new SekiroServer(19999);

        UserConfig.Builder builder = new UserConfig.Builder();
        sekiroServer.setConfig(builder.build());
        sekiroServer.startup();

    }

    public static void main(String[] args) {
        DemoSekiroServer server = new DemoSekiroServer();
        server.start();
    }
}
