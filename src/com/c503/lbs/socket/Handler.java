package com.c503.lbs.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.c503.lbs.entity.Car;
import com.c503.lbs.entity.RTLocation;
import com.example.jtt808.FrameBase;
import com.example.jtt808.FrameFactory;
import com.example.jtt808.FrameLocaInfoRep;
import com.example.jtt808.FrameLogin;
import com.example.jtt808.FrameServerAnswer;
import com.example.jtt808.argument.FrameType;

class Handler implements Runnable{
    private Socket socket;
    public Handler(Socket socket){
        this.socket=socket;
    }
    
    public void run(){
    		
    		try {
    			while(true){
	                InputStream socketIn = socket.getInputStream();
	                OutputStream socketOut = socket.getOutputStream();
	                byte[] temp = new byte[1024 * 4];
	                int length = socketIn.read(temp, 0, 1024 * 4);
	                
	                while(-1 != length){
	                	
	                	  FrameBase fBase = FrameFactory.CreatFrame(temp,length);
	                	 
	                	  //终端注册
	                      if(fBase.getm_FrameHead().getID() == FrameType.MSG_ZDZC){
	
	                      }
	                      
	                      //终端鉴权
	                      if(fBase.getm_FrameHead().getID() == FrameType.MSG_ZDJQ){
	                    	  String key = "黑B22222";
	                    	  Car value = null;
	                    	  RTLocation.carRT.put(key, value);
	                    	  	FrameLogin fraLogin = (FrameLogin)fBase;
	    	                  	System.out.println("终端鉴权::");
	    	                  	System.out.println("鉴权码::"+fraLogin.getM_strRegCode());
	    	                  	//如果鉴权码为808，则返回平台通用应答
	    	                  	if(fraLogin.getM_strRegCode().equals("808")){
	    	                  		FrameServerAnswer frameServer = new FrameServerAnswer("18734135922",2014,false,false);
	    	                  		frameServer.setInfo(333, 1);
	    	                  		byte[] bDataServer = frameServer.getM_DataBuf();
	    	                  		socketOut.write(bDataServer);
	    	                  		socketOut.flush();
	    	                  		length = -1;
	    	                  	}
	                      }
	                      
	                      //位置信息汇报
	                      if(fBase.getm_FrameHead().getID() == FrameType.MSG_WZXXHB){
	    			        	  FrameLocaInfoRep fa = (FrameLocaInfoRep)fBase;
	    			        	  
	    			        	  RTLocation.carRT.get("黑B22222").setLatitude(String.valueOf(fa.getM_dlatitude()));
	    			        	  RTLocation.carRT.get("黑B22222").setLongitude(String.valueOf(fa.getM_dlongitude()));
	    			        	  RTLocation.carRT.get("黑B22222").setElevation(String.valueOf(fa.getM_ielevation()));
	    			        	  RTLocation.carRT.get("黑B22222").setOil(fa.getM_iorientation());
	    			        	  RTLocation.carRT.get("黑B22222").setGasSolubility(String.valueOf(fa.getM_ddangerGas()));
	    			        	  RTLocation.carRT.get("黑B22222").setSpeed(fa.getM_ispeed());
	    			        	  
	    			        	  
	    			        	  System.out.println(fa.getM_dataLen());
	    			        	  System.out.println("位置信息汇报::");
	    		                  System.out.println("报警标志:紧急报警:"+fa.getM_warningMark().urgency); 
	    		                  System.out.println("报警标志:超速报警:"+fa.getM_warningMark().overspeed); 
	    		                  System.out.println("报警标志:GXSS模块故障:"+fa.getM_warningMark().GXSSModel); 
	    		                  System.out.println("状态:开/关:"+fa.getM_locationStatus().acc); 
	    		                  System.out.println("状态:定位:"+fa.getM_locationStatus().location);
	    		                  System.out.println("状态:北纬/南纬:"+fa.getM_locationStatus().isNorth);
	    		                  System.out.println("纬度::"+fa.getM_dlatitude()); 
	    		                  System.out.println("经度::"+fa.getM_dlongitude()); 
	    		                  System.out.println("高程::"+fa.getM_ielevation()); 
	    		                  System.out.println("速度::"+fa.getM_ispeed());
	    		                  System.out.println("方向::"+fa.getM_iorientation());  
	    		                  System.out.println("时间::"+fa.getM_date()); 
	    		                  System.out.println("油量::"+fa.getM_doilMass()); 
	    		                  System.out.println("里程::"+fa.getM_dmileage());
	    		                  System.out.println("有害气体::"+fa.getM_ddangerGas());
	    		                  if(true){
	    		                  		FrameServerAnswer frameServer = new FrameServerAnswer("18734135922",2014,false,false);
	    		                  		frameServer.setInfo(333, 1);
	    		                  		byte[] bDataServer = frameServer.getM_DataBuf();
	    		                  		socketOut.write(bDataServer);
	    		                  		socketOut.flush();
	    		                  		System.out.println("088");
	    		                  		length = -1;
	    		                  }
	                      }
	                	}
	    			}
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
	            try {
	                if(socket!=null)
	                    socket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
            }
    }
}