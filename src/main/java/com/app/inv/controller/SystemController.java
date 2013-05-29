package com.app.inv.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.helper.MyUserInfo;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

@Controller
@RequestMapping(value="/system")
public class SystemController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		
		return "system";
	}
	
	@RequestMapping(value="/shutdown", method=RequestMethod.GET)
	public ModelAndView shutdown(Map<String, Object> myModel){
		myModel.put("option", "shutdown");
		return new ModelAndView("system", myModel);
	}
	
	@RequestMapping(value="/shutdown", method=RequestMethod.POST)
	public void submitShutdown(JSch jsch){
		
		
		
		String user = "rick";
	    String host = "192.168.159.10";
	    String password = "asdf1234";

        InputStream in = null;
        
        
            Session session;
			try {
				session = jsch.getSession(user, host, 22);
				session.setPassword(password);
	            UserInfo ui = new MyUserInfo();
	            session.setUserInfo(ui);
	            session.connect();

	            Channel channel = session.openChannel("exec");

	            ((ChannelExec) channel).setCommand("sudo -S -p '' sudo shutdown -h now");

	            in = channel.getInputStream();
	            OutputStream out = channel.getOutputStream();
	            ((ChannelExec) channel).setErrStream(System.err);

	            channel.connect();

	            out.write((password + "\n").getBytes());
	            out.flush();
	            
	            byte[] tmp = new byte[1024];
	            while (true) {
	                while (in.available() > 0) {
	                    int i = in.read(tmp, 0, 1024);
	                    if (i < 0) {
	                        break;
	                    }
	                    System.out.print(new String(tmp, 0, i));
	                }
	                if (channel.isClosed()) {
	                    System.out.println("exit-status: " + channel.getExitStatus());
	                    break;
	                }
	                try {
	                    Thread.sleep(1000);
	                } catch (Exception ee) {
	                }
	            }
	            channel.disconnect();
	            session.disconnect();
			} catch (JSchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	}
	
	@RequestMapping(value="/parameters", method=RequestMethod.GET)
	public ModelAndView loadParameters(Map<String, Object> myModel){
		
		return new ModelAndView();
	}
}
