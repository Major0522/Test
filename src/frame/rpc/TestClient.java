package frame.rpc;

import java.net.InetSocketAddress;

public class TestClient {

	public static void main(String[] args) {
		
		RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
		EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
		System.out.println(echo.echo("Are U OK ?"));
	}
}
