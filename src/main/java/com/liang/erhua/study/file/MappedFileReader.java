package com.liang.erhua.study.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liangjia
 * @version 1.0
 * @date 14:06/2020-03-30
 * @description 内存文件映射
 */
public class MappedFileReader {
    private FileInputStream fileInputStream;
    private MappedByteBuffer mappedByteBuffer;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public MappedFileReader(String fileName, int arraySize) throws IOException {
        this.fileInputStream = new FileInputStream(fileName);
        FileChannel fileChannel = fileInputStream.getChannel();
        this.fileLength = fileChannel.size();
        this.mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileLength);
        this.arraySize = arraySize;
    }

    public int read() throws IOException {
        int limit = mappedByteBuffer.limit();
        int position = mappedByteBuffer.position();
        if (position == limit) {
            return -1;
        }
        if (limit - position > arraySize) {
            array = new byte[arraySize];
            mappedByteBuffer.get(array);
            return arraySize;
        } else {
            // 最后一次读取数据
            array = new byte[limit - position];
            mappedByteBuffer.get(array);
            return limit - position;
        }
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
        MappedFileReader reader = new MappedFileReader("/home/zfh/movie.mkv", 65536);
        long start = System.nanoTime();
        while (reader.read() != -1);
        long end = System.nanoTime();
        reader.close();
        System.out.println("MappedFileReader: " + (end - start));
    }

}
