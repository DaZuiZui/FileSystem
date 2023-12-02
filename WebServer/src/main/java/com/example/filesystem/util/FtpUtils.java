package com.example.filesystem.util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by jlm on 2019-09-17 17:44
 */
public class FtpUtils {

    //本地路径
    @Value("${projecturl}")
    private static String projecturl;
    //绝对路径
    @Value("${absoluteFilePath}")
    private static String absoluteFilePath;


    //从服务器下载到本地
    //保存的位置路径
    @Value("${saveDir}")
    private static String saveDir;
    //服务器路径
    @Value("${serverUrl}")
    private static String serverUrl;
    //目标文件路径
    @Value("${targetFile}")
    private static String targetFile;
    //目标文件夹路径
    @Value("${targetFileDir}")
    private static String targetFileDir;



    public static void download(String reteFilePath,String loFilePath) throws Exception{
        String host = "192.168.88.130";
        int port = 22;
        String username = "hac";
        String password = "1234";
        //目标文件的绝对路径
        //String remoteFilePath = "/home/hac/Desktop/hahaha/Yeah.txt/Yeah.txt";

        String remoteFilePath = reteFilePath;


        //下载到目标位置的绝对路径
        //String localFilePath = "D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/Yeah.txt";

        String localFilePath =loFilePath;

        try {
            JSch jsch = new JSch();

            // 创建会话
            Session session = jsch.getSession(username, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect();

            // 打开SFTP通道
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            // 获取文件输入流
            try (InputStream inputStream = sftpChannel.get(remoteFilePath);
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

                // 将文件内容读取到字节数组中
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] fileBytes = outputStream.toByteArray();

                // 将字节数组写入本地文件
                try (FileOutputStream fileOutputStream = new FileOutputStream(localFilePath)) {
                    fileOutputStream.write(fileBytes);
                    System.out.println("File downloaded successfully to: " + localFilePath);
                }
            }

            // 关闭SFTP通道和会话
            sftpChannel.disconnect();
            session.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    /**
     * 利用JSch包实现SFTP上传文件
     * @param bytes  文件字节流
     * @param fileName  文件名
     * @throws Exception
     */
    public static void sshSftp(byte[] bytes,String fileName) throws Exception{
        //指定的服务器地址
        String ip = "192.168.88.130";
        //用户名
        String user = "hac";
        //密码
        String password = "1234";
        //服务器端口 默认22
        int port = 22;
        //上传文件到指定服务器的指定目录 自行修改
        String path = "/home/hac/Desktop/hahaha/Yeah.txt/";

        Session session = null;
        Channel channel = null;


        JSch jsch = new JSch();


        if(port <=0){
            //连接服务器，采用默认端口
            session = jsch.getSession(user, ip);
        }else{
            //采用指定的端口连接服务器
            session = jsch.getSession(user, ip ,port);
        }

        //如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
            //设置登陆主机的密码
        }

        session.setPassword(password);//设置密码
        //设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        //设置登陆超时时间
        session.connect(1000); //以毫秒为单位，当前设置为1分钟


        OutputStream outstream = null;
        try {
            //创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;




            //进入服务器指定的文件夹
            sftp.cd(path);

            //列出服务器指定的文件列表
//            Vector v = sftp.ls("*");
//            for(int i=0;i<v.size();i++){
//                System.out.println(v.get(i));
//            }

            //以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
            outstream = sftp.put(fileName);
            outstream.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关流操作
            if(outstream != null){
                outstream.flush();
                outstream.close();
            }
            if(session != null){
                session.disconnect();
            }
            if(channel != null){
                channel.disconnect();
            }
        }
    }

}