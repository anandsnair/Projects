package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MessageHandler {

	public static void main(String[] args) {
		List<Message> messages = new ArrayList<Message>();
		Message message = new Message();
		message.setMessageDesc("ssf");
		message.setMessageName("test");
		message.setMessageId(223);
		messages.add(message);
		
		message = new Message();
		message.setMessageDesc("ssf");
		message.setMessageName("test1");
		message.setMessageId(23);
		messages.add(message);
		
		message = new Message();
		message.setMessageDesc("ssf");
		message.setMessageName("test4");
		message.setMessageId(2);
		messages.add(message);
		
		message = new Message();
		message.setMessageDesc("ssf1");
		message.setMessageName("test3");
		message.setMessageId(1);
		messages.add(message);

		List<String> names = messages.stream().filter(conn -> conn.getMessageDesc().equals("ssf"))
				.map(conn -> conn.getMessageName()).collect(Collectors.toList());
		for(String str : names) 
			System.out.println(str);
		
	}
}
