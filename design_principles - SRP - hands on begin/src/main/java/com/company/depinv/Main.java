package com.company.depinv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// client is responsible for chosing format option
		
		/*
		Message msg = new Message("Change the message");
		MessagePrinter printer = new MessagePrinter();
		printer.writeMessage(msg, "test_msg.txt");*/
		
		Message msg = new Message("My New message has changed");
		MessagePrinter printer = new MessagePrinter();
		printer.writeMessage(msg, new JSONFormatter(), new PrintWriter(new FileWriter("test_msg.txt")));
		
		msg = new Message("My console message");
		 printer = new MessagePrinter();
		printer.writeMessage(msg, new JSONFormatter(), new PrintWriter(System.out));
	}

}
