package com.hongframe.sekiro.serialization;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;
import io.netty.handler.codec.CodecException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 16:33
 */
public class HessianSerializer implements Serializer {

    private SerializerFactory serializerFactory = new SerializerFactory();

    public static final byte HESSIAN_SERIALIZER = 1;

    @Override
    public byte[] serialize(Object obj) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(byteArray);
        output.setSerializerFactory(serializerFactory);

        try {
            output.writeObject(obj);
            output.close();
        } catch (IOException e) {
            throw new CodecException("IOException occurred when Hessian serializer encode!", e);
        }

        return byteArray.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, String classOfT) {
        Hessian2Input input = new Hessian2Input(new ByteArrayInputStream(data));
        input.setSerializerFactory(serializerFactory);
        Object resultObject;
        try {
            resultObject = input.readObject();
            input.close();
        } catch (IOException e) {
            throw new CodecException("IOException occurred when Hessian serializer decode!", e);
        }
        return (T) resultObject;
    }
}
