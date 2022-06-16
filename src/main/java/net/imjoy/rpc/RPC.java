package net.imjoy.rpc;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import net.imjoy.rpc.encoding.EncodedException;
import net.imjoy.rpc.encoding.EncodedObject;

public class RPC extends MessageEmitter {

	private String client_id;

	private String name;

	public RPC( final String client_id,
		final String name,
		final int max_message_buffer_size) {
	}

	public RPC() {
		this( "id", "name", 1024 * 8 );
	}

	public void register_service()
	{
		CompletableFuture.runAsync(() -> {
		    // method call or code to be asynch.
		});
	}

	@Override
	public void emit(String msg) {
		// TODO Auto-generated method stub
	}

	public Object decode(Object obj)
	{
		if( obj instanceof Map || obj instanceof List || obj instanceof Set || obj instanceof String || 
				obj instanceof EncodedObject || isArray( obj ) )
			return obj;	
		else if( obj instanceof EncodedException )
		{
			
		}

		return obj;
	}

	public Object encode(Object obj)
	{
		if( obj instanceof Map || obj instanceof List || obj instanceof Set || obj instanceof String || 
				obj instanceof EncodedObject || isArray( obj ) )
			return obj;
		else if( obj instanceof Function ) {
			
			return obj;
		}
		else if( obj instanceof Exception ) {
			return new EncodedException( (Exception) obj );
		}
		else {
			// TODO implement
			return obj;
		}
	}

	private boolean isArray(final Object obj) {
	    return obj instanceof Object[] || obj instanceof boolean[] ||
	       obj instanceof byte[] || obj instanceof short[] ||
	       obj instanceof char[] || obj instanceof int[] ||
	       obj instanceof long[] || obj instanceof float[] ||
	       obj instanceof double[];
	}

}
