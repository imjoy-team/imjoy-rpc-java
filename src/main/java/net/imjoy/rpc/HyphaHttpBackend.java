package net.imjoy.rpc;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.util.component.LifeCycle;

public class HyphaHttpBackend {

	public static void main(String[] args ) throws Exception
	{
		HttpClient httpClient = new HttpClient();
		httpClient.setFollowRedirects(false);

		System.out.println("start");
		httpClient.start();	

		String msg = "http://localhost:9000/My8agxFksFGM2KbJZuxPkz/services/hello-world/hello?name=Wei";
		ContentResponse response = httpClient.GET(msg);
		System.out.println( response );

		System.out.println("stop");
		new Thread(() -> LifeCycle.stop(httpClient)).start();
	}

}
