package chat3;

//무한루프에 빠지게 되면q누르고 소켓클로즈 에러랑
//서버에 bye 뜨는거 확인하고 cirl + c
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
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
			System.out.println("예외1:"+ e);
		}
	}
	
	@Override
	public void run() {
		while(in != null) {
			try {
				System.out.println("Thread Receive : "+ in.readLine());
			}
			catch (Exception e) {
				System.out.println("예외2:"+ e);
			}
		}
		
		try {
			in.close();
		}
		catch (Exception e) {
			System.out.println("예외3:"+ e);
		}
		
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

