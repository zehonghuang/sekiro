package com.hongframe.sekiro.serialization;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 16:28
 */
public interface Serializer {

    byte[] serialize(final Object obj);

    <T> T deserialize(final byte[] data, String classOfT);

}
