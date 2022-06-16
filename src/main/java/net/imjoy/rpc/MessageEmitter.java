package net.imjoy.rpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class MessageEmitter {

	// do handlers return things?
	protected Map<Object,List<Consumer<?>>> eventHandlers;

	public MessageEmitter() {
		eventHandlers = new HashMap<>();
	}

	public abstract void emit( String msg );

	public void on(Object event, Consumer<?> handler) {
		if (!eventHandlers.containsKey(event)) {
			ArrayList<Consumer<?>> l = new ArrayList<>();
			l.add(handler);
			eventHandlers.put(event, l);
		}
	}

	public void once( Object event, Consumer<?> handler ) {
		
		// TODO see if we need this, and implement if we do
		// wrap func( *args, **kwargs ) = True
		// create a function that wraps the handler

		Consumer<?> wrapFunc = null;
		on( event, wrapFunc);
	}

	public void off( Object event, Consumer<?> handler ) {
		if( event == null && handler == null )
			eventHandlers.clear();
		else if( event != null && handler == null )
			eventHandlers.put(event, new ArrayList<>());
		else
			eventHandlers.remove(event);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fire( Object event, Object data ) {
		if( eventHandlers.containsKey(event)) {
			for( Consumer handler : eventHandlers.get(event) ) {
				try {
					// do something
					handler.accept(data);
				}catch(Exception e) { 
					// TODO better error handling
					e.printStackTrace();
				}
			}
		}
	}

}
