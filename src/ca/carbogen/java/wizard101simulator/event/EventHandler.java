package ca.carbogen.java.wizard101simulator.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler 
{
	// Priority of 1 will be executed first, 
	// with decreasing priority as the value increases.
	int priority() default 50;
	boolean ignoreCancelled() default false;
}
