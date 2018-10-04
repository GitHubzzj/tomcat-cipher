package com.byedbl.tomcat.cipher.valve;

import org.apache.catalina.connector.Response;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ResponseCipherWrapper extends Response {

    //定义打印流，数据通过它存到缓冲区
    private PrintWriter cachedWriter;
    //缓冲区，用来存放后台数据
    private CharArrayWriter bufferedWriter;

    public ResponseCipherWrapper(Response response) {
//        super(response);
        bufferedWriter = new CharArrayWriter();
        cachedWriter = new PrintWriter(bufferedWriter);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return cachedWriter;
    }

    public String getResult() {
        byte[] bytes = bufferedWriter.toString().getBytes();
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
