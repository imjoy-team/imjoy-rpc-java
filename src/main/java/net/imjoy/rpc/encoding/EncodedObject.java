package net.imjoy.rpc.encoding;

public abstract class EncodedObject {
	
	public final String rtype;

	public EncodedObject( String rtype ) {
		this.rtype = rtype;
	}
}
