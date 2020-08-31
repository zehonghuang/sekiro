package com.hongframe.sekiro.serialization;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 16:38
 */
public class SerializerManager {

    private static Serializer[] serializers = new Serializer[2];

    static {
        addSerializer(HessianSerializer.HESSIAN_SERIALIZER, new HessianSerializer());
    }

    public static void addSerializer(int index, Serializer serializer) {
        serializers[index] = serializer;
    }

}
