package net.imjoy.rpc.encoding;

public class ByteEncodedObject extends EncodedObject {

	public final byte[] rvalue;

	public ByteEncodedObject( final String rtype, final byte[] bytes ) {
		super( rtype );
		this.rvalue = bytes;
	}
}
