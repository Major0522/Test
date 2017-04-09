package frame.rpc;

public class EchoServiceImpl implements EchoService {

	public String echo(String ping) {
		return ping != null ? ping + " --> I am ok." : " I am ok.";
	}
}