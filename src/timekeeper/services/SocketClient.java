package timekeeper.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import timekeeper.model.*;

//F5  D  0 F2  FF  FE  3 1          0 4 5D 91  B2  2C 5E 80  4D CF
//245 13 0 242 255 254 3 1	tag id: 0 4 93 145 178 44 94 128 crc 77 207
//045D91B22C5E80
//245 13 0 242 255 254 3 1 0 4 13 127 178 44 94 129 92 91 
//040D7FB22C5E81

//Mihai 245130242255254310493145178449412877207


public class SocketClient implements Runnable {
	
	private static SocketClient Instance;
	private static Socket Client;
	
	private static final String IP = "192.168.0.101";
	private static final int PORT = 1234;
	
	private static byte[] input = new byte[1024];
	boolean inputIsReset;
	
	private static Integer WorkerId;
	private static Integer ProjectId;
	
	private SocketClient() {};
	
	public static synchronized SocketClient getInstance() {
		if (Instance == null) {
			Instance = new SocketClient();
		}
		return Instance;
	}
	
	public void run() {
		
		ProjectId = DbHandler.getInstance().getProjectFromDevice(IP);
		System.out.println("Project id = " + ProjectId);
		String tag = "";
		
		try {
			Client = new Socket(InetAddress.getByName(IP), PORT);
			SocketAddress address = Client.getLocalSocketAddress();
			
			while (Client.isConnected()) {
				int size = Client.getInputStream().available();
				
				while(size-- > 0) {
					tag += Client.getInputStream().read();
				}
				if (tag.length() > 0) {
					getWorkerId(tag);
					updateWorkday();
					tag = "";
					Thread.sleep(10000);
				}
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void updateWorkday() {
		ArrayList<Workday> workdays = (ArrayList<Workday>) DbHandler.getInstance().getWorkdays();
		
		Optional<Workday> workday = workdays
				.stream()
				.filter((w) -> w.getProject() == ProjectId && w.getWorker() == WorkerId && w.getStopHour() == null)
				.findFirst();
		if (workday.isPresent()) {
			DbHandler.getInstance().updateWorkday(
					new Workday(workday.get().getId(), workday.get().getWorker()
					, workday.get().getProject(), workday.get().getStartHour(), LocalDateTime.now()));
		}
		else {
			DbHandler.getInstance().addWorkday(
					new Workday(0, WorkerId, ProjectId, LocalDateTime.now(), null));
		}
	}
	
	private void getWorkerId(String tag) {
		WorkerId =  DbHandler.getInstance().getWorkerByTag(tag);
		System.out.println("Worker id = " + WorkerId);
	}
	
	private void resetInput() {
		input = new byte[1024];
		for (int i = 0; i < 1024; i++) {
			input[i] = -1;
		}
		inputIsReset = true;
		
/*		
		if (input.length > 0) {
			for (int i = 0; i < input.length; i++) {
				tag += input[i];
				System.out.println(tag);
			}
		}
		
		if (tag.length() > 0) {
			System.out.println("Tag : " + tag);

		}*/
	}
}
