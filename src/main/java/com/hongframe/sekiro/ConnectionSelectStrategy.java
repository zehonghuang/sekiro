package com.hongframe.sekiro;

import java.util.List;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-01 14:43
 */
public interface ConnectionSelectStrategy {

    Connection select(List<Connection> connections);

}
