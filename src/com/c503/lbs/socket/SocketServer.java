package com.c503.lbs.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	  private int port=8888;
	  private ServerSocket serverSocket;
	  
	   public SocketServer() throws IOException{
	        serverSocket=new ServerSocket(port);
	        System.out.println("服务器启动");
	    }
	    
	    public void service(){
	        while(true){
	            Socket socket=null;
	            try {
	            	System.out.println("开始...");
	                //接收客户连接,只要客户进行了连接,就会触发accept();从而建立连接
	                socket=serverSocket.accept();
	                Handler  h = new Handler(socket);
	               
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static void main(String[] args) {
			try {
				new SocketServer().service();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
}
