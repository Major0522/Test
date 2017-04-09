package frame.rpc;

import java.io.IOException;

public class TestServer {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			public void run() {
				try {
					RpcExporter.exporter("localhost", 8088);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
