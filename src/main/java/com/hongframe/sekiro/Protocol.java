package com.hongframe.sekiro;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 10:39
 */
public interface Protocol {

    CommandEncoder encoder();

    CommandDecoder decoder();

    CommandHandler commandHander();

}
