package frame.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {
	
	static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void exporter(String hostName, int port) throws IOException{
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(hostName, port));
		try {
			while(true){
				executor.execute(new ExporterTask(server.accept()));
			}
		} finally {
			server.close();
		}
	}
}
