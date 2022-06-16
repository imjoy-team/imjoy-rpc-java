package net.imjoy.rpc.encoding;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.BiFunction;

import org.junit.Test;

import net.imjoy.rpc.RPC;

public class TestEncodingDecoding {

	/**
	 * Ensure that the encoder returns some object types directly.
	 */
	@Test
	public void testDirectEncoding()
	{
		final HashMap map = new HashMap();
		final ArrayList list = new ArrayList();
		final HashSet set = new HashSet();
		final String string = "hi";
		
		final RPC rpc = new RPC();
		assertTrue( map == rpc.encode( map ));
		assertTrue( list == rpc.encode( list ));
		assertTrue( set == rpc.encode( set ));
		assertTrue( string == rpc.encode( string ));
		
	}
	
	/**
	 * Test the encoding for {@link BiFunction}s.
	 */
	@Test
	public void testFunctionEncoding()
	{
		BiFunction f = new BiFunction() {
			@Override
			public Object apply(Object arg0, Object arg1) {
				return arg0.toString() + arg1.toString(); 
			}
			
		};
		
		final RPC rpc = new RPC();
		rpc.encode( f );
	}
}
