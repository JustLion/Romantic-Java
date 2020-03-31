package com.liang.erhua.study.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liangjia
 * @version 1.0
 * @date 14:03/2020-03-30
 * @description：文件通道
 */
public class ChannelFileReader {
    private FileInputStream fileInputStream;
    private ByteBuffer byteBuffer;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public ChannelFileReader(String fileName, int arraySize) throws IOException {
        this.fileInputStream = new FileInputStream(fileName);
        this.fileLength = fileInputStream.getChannel().size();
        this.arraySize = arraySize;
        this.byteBuffer = ByteBuffer.allocate(arraySize);
    }

    public int read() throws IOException {
        FileChannel fileChannel = fileInputStream.getChannel();
        // 读取到ByteBuffer中
        int bytes = fileChannel.read(byteBuffer);
        if (bytes != -1) {
            // 字节数组长度为已读取长度
            array = new byte[bytes];
            byteBuffer.flip();
            // 从ByteBuffer中得到字节数组
            byteBuffer.get(array);
            byteBuffer.clear();
            return bytes;
        }
        return -1;
    }

    public void close() throws IOException {
        fileInputStream.close();
        array = null;
    }

    public byte[] getArray() {
        return array;
    }

    public long getFileLength() {
        return fileLength;
    }

    public static void main(String[] args) throws IOException {
        ChannelFileReader reader = new ChannelFileReader("/home/zfh/movie.mkv", 65536);
        long start = System.nanoTime();
        while (reader.read() != -1) ;
        long end = System.nanoTime();
        reader.close();
        System.out.println("ChannelFileReader: " + (end - start));
    }

}
