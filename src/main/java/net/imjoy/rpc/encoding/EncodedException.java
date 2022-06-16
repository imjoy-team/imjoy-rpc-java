package net.imjoy.rpc.encoding;

public class EncodedException extends EncodedObject {

	public transient Exception exception;
	public String rvalue;
	
	public EncodedException( final Exception exception )
	{
		super( "error" );
		this.exception = exception;
		rvalue = exception.toString();
	}
}
