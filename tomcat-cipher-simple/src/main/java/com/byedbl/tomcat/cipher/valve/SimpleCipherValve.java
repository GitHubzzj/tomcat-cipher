package com.byedbl.tomcat.cipher.valve;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.Map;

public class SimpleCipherValve extends ValveBase {

    private final Log log = LogFactory.getLog(SimpleCipherValve.class);

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        printRequest(request);
//        ResponseCipherWrapper wrapper = new ResponseCipherWrapper(response);
        getNext().invoke(request, response);
//        changeResponse(response);
//        changeResponseStream(response);

        //怎么修改response ???????????????
        /*String result = wrapper.getResult();
        result += "aa: ";
//后台数据编辑后，通过真正的response写到前台页面去
        response.getOutputStream().write(result.getBytes());*/
    }

    private void changeResponseStream(Response response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void changeResponse(Response response) {
        try {
            response.getWriter().write("aaa");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printRequest(Request request) {
        log.info(request);
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry :
                parameterMap.entrySet()) {
            log.info(entry.getKey() + " " + getWithComma(entry.getValue()));
        }
    }

    private String getWithComma(String[] value) {
        if (value == null || value.length <= 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            if (sb.length() > 0) {
                sb.append(",").append(value[i]);
            } else {
                sb.append(value[i]);
            }
        }
        return sb.toString();
    }
}
