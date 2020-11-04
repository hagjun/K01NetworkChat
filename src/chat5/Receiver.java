package chat5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
//서버가 보내는 메세지를 읽어오는 쓰레드 클래스
public class Receiver extends Thread {

	Socket socket;
	BufferedReader in = null;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		
		
		
		try {
			in = new BufferedReader(new 
			InputStreamReader(this.socket.getInputStream()));
		}
		catch (Exception e) {
			System.out.println("예외>Receiver>생성자:"+ e);
		}
	}
	
	@Override
	public void run() {
		while(in != null) {
			try {
				System.out.println("Thread Receive : "+ in.readLine());
			}
			catch (SocketException ne) {
				/*
				클라이언트가 q를 입력하여 접속을 종료하면 무한루프가 발생되므로
				탈출할수 있도록 별도의 catch블럭을 추가한다.
				예외발생시 while을 탈출할수 있도록 break를 걸어준다.
				 */
				System.out.println("SocketException");
				break;
			}
			catch (Exception e) {
				System.out.println("예외>Receiver>run1:"+ e);
			}
		}
		
		try {
			in.close();
		}
		catch (Exception e) {
			System.out.println("예외>Receiver>run2:"+ e);
		}
		
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

