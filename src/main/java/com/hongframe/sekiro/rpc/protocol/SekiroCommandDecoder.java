package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.CommandDecoder;
import com.hongframe.sekiro.ResponseStatus;
import com.hongframe.sekiro.rpc.cmd.SekiroCommandCode;
import com.hongframe.sekiro.rpc.cmd.SekiroCommandType;
import com.hongframe.sekiro.rpc.cmd.SekiroRequestCommand;
import com.hongframe.sekiro.rpc.cmd.SekiroResponseCommand;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 10:47
 */
public class SekiroCommandDecoder implements CommandDecoder {

    private int headerLength;

    {
        headerLength = SekiroProtocol.RESPONSE_HEADER_LENGTH <
                SekiroProtocol.REQUEST_HEADER_LENGTH ?
                SekiroProtocol.RESPONSE_HEADER_LENGTH :
                SekiroProtocol.REQUEST_HEADER_LENGTH;
    }

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < headerLength) {
            return;
        }

        in.markReaderIndex();
        byte protocolCode = in.readByte();
        in.resetReaderIndex();
        if (protocolCode != SekiroProtocol.SEKIRO_PROTOCOL_CODE) {
            //TODO protocol error
            return;
        }

        in.markReaderIndex();
        in.readByte();
        byte p_version = in.readByte();//TODO
        byte type = in.readByte();
        if (type == SekiroCommandType.REQUEST) {
            if (in.readableBytes() >= SekiroProtocol.REQUEST_HEADER_LENGTH - 3) {
                short cmdcode = in.readShort();
                byte cmdversion = in.readByte();
                int requestId = in.readInt();
                byte serializer = in.readByte();
                int timeout = in.readInt();
                short clazzLen = in.readShort();
                short headerLen = in.readShort();
                int contentLen = in.readInt();

                byte[] clazzName = null;
                byte[] header = null;
                byte[] content = null;

                if (clazzLen > 0) {
                    clazzName = new byte[clazzLen];
                    in.readBytes(clazzName);
                }
                if (headerLen > 0) {
                    header = new byte[headerLen];
                    in.readBytes(header);
                }
                if (contentLen > 0) {
                    content = new byte[contentLen];
                    in.readBytes(content);
                }

                SekiroRequestCommand command = new SekiroRequestCommand();
                command.setCmdCode(SekiroCommandCode.valueOf(cmdcode));
                command.setVersion(cmdversion);
                command.setRequestId(requestId);
                command.setTimeout(timeout);
                command.setSerializer(serializer);
                command.setClazz(clazzName);
                command.setHeader(header);
                command.setContent(content);

                out.add(command);
            } else {
                in.resetReaderIndex();
            }
        } else if (type == SekiroCommandType.RESPONSE) {
            if(in.readableBytes() >= SekiroProtocol.RESPONSE_HEADER_LENGTH - 3) {
                short cmdcode = in.readShort();
                byte cmdversion = in.readByte();
                int requestId = in.readInt();
                byte serializer = in.readByte();
                short respstatus = in.readShort();
                short clazzLen = in.readShort();
                short headerLen = in.readShort();
                int contentLen = in.readInt();

                byte[] clazzName = null;
                byte[] header = null;
                byte[] content = null;

                if (clazzLen > 0) {
                    clazzName = new byte[clazzLen];
                    in.readBytes(clazzName);
                }
                if (headerLen > 0) {
                    header = new byte[headerLen];
                    in.readBytes(header);
                }
                if (contentLen > 0) {
                    content = new byte[contentLen];
                    in.readBytes(content);
                }

                SekiroResponseCommand command = new SekiroResponseCommand();
                command.setCmdCode(SekiroCommandCode.valueOf(cmdcode));
                command.setVersion(cmdversion);
                command.setRequestId(requestId);
                command.setStatus(ResponseStatus.valueOf(respstatus));
                command.setSerializer(serializer);
                command.setClazz(clazzName);
                command.setHeader(header);
                command.setContent(content);

                out.add(command);
            } else {
                in.resetReaderIndex();
            }
        } else {
            //TODO command error
        }

    }
}
