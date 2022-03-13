package com.itan.nioweb.bio.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: ye.yanbin
 * @Date: 2022/3/13
 * 服务端：用于接受客户端发送的消息
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动===");
        //定义一个ServerSocket对象进行服务端的端口注册
        ServerSocket ss = new ServerSocket(9999);
        //监听客户端的Socket连接请求，会等待，得到一个Socket管道
        Socket socket = ss.accept();
        //从socket管道中得到一个字节输入流
        InputStream in = socket.getInputStream();
        //把字节输入流包装成自己需要的流进行数据的读取
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //读取数据
        String msg;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
    }
}
