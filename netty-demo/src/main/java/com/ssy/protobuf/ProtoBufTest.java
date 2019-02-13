package com.ssy.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * 序列化&反序列化, 非常有实际意义
 * 因为: 字节数组可以在网络上传输了
 * <p>
 * Created by robin on 19/2/13.
 */
public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三")
                .setAge(18)
                .setAddress("北京")
                .build();


        byte[] student2ByteArray = student.toByteArray();

        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());

    }
}
