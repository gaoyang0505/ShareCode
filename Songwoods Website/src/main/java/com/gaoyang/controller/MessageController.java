package com.gaoyang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaoyang.dao.MessageDAO;
import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.Message;
import com.gaoyang.pojo.User;

@Controller
public class MessageController {
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("messageDAO")
	MessageDAO messageDAO;
	
	
	@RequestMapping(value = "/sendmessage.htm", method = RequestMethod.POST)
	protected String createMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mesCon=request.getParameter("messageCon");
		String mesTit=request.getParameter("mesTitle");
		String mesTyp=request.getParameter("mesType");
		String senderID = request.getParameter("sender");
		String receiverID = request.getParameter("receiver");
		UserDAO userDAO = new UserDAO();
		
		User sender = userDAO.getSpecificUser(senderID);
		User receiver = userDAO.getSpecificUser(receiverID);
		
		messageDAO.createMessage(mesCon,mesTit,mesTyp,sender,receiver);
		return null;
	}

	
	@RequestMapping(value = "/mailBox.htm", method = RequestMethod.GET)
	protected String getRecMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int unread = 0;
		List<Message> listSend = messageDAO.getSendedMessage(request.getSession().getAttribute("userID").toString());
		List<Message> listReceive = messageDAO.getRecivedMessage(request.getSession().getAttribute("userID").toString());
		
		request.setAttribute("messageList", listReceive);
		
		for(Message mess:listReceive){
			if(mess.getMessageStatus().equals("Unread"))
				unread++;
		}
		User user = userDAO.getSpecificUser(request.getSession().getAttribute("user").toString());
		request.setAttribute("userRole", user.getRoleType());
		request.setAttribute("userfirst", user.getUserFirstName());
		request.setAttribute("unread", unread);
		request.setAttribute("send", listSend.size());
		return "mailbox";
	}
	
	@RequestMapping(value = "/outBox.htm", method = RequestMethod.GET)
	protected String getSendMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int unread = 0;
		List<Message> listSend = messageDAO.getSendedMessage(request.getSession().getAttribute("userID").toString());
		List<Message> listReceive = messageDAO.getRecivedMessage(request.getSession().getAttribute("userID").toString());
		request.setAttribute("messageList", listSend);
		//request.setAttribute("messageSend", listReceive);
		for(Message mess:listReceive){
			if(mess.getMessageStatus().equals("Unread"))
				unread++;
		}
		User user = userDAO.getSpecificUser(request.getSession().getAttribute("user").toString());
		request.setAttribute("userRole", user.getRoleType());
		request.setAttribute("userfirst", user.getUserFirstName());
		request.setAttribute("unread", unread);
		request.setAttribute("send", listSend.size());
		return "mailbox";
	}
	
	@RequestMapping(value = "/messageDte.htm", method = RequestMethod.GET)
	protected String getMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String messageID = request.getParameter("messageID");
		Message message = messageDAO.getMessage(messageID);
		
		JSONObject obj = new JSONObject();

		obj.put("messageCon", message.getMessageText());
		obj.put("messageType", message.getMessageType());
		obj.put("messageStatus", message.getMessageStatus());
		obj.put("messageDate", message.getMessageDate());
		obj.put("messageTitle", message.getMessageTitle());
		obj.put("messageReceiID", message.getReceiver().getUserID());
		obj.put("messageSenderEMail", message.getSender().getUserEMail());
		obj.put("messageReceiName", message.getReceiver().getUserFirstName() + " " + message.getReceiver().getUserLastName());
		obj.put("messageSendID", message.getSender().getUserID());
		obj.put("messageSendName", message.getSender().getUserFirstName() + " " + message.getSender().getUserLastName());
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}
	
}
