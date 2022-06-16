package net.imjoy.rpc.encoding;

public class StringEncoder extends EncodedObject {

	public transient Object object;
	
	public StringEncoder( final String rtype)
	{
		super( rtype );
	}
}
