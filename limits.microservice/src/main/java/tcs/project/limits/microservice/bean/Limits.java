package tcs.project.limits.microservice.bean;

import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class Limits {
	private int min;
	private int max;
	private String message;
	
	public Limits() {
		super();
	}

	public Limits(int min, int max, String message) {
		super();
		this.min = min;
		this.max = max;
		this.message = message;
	}

	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public String getMessage() {
		return message;
	}

	
	public void setMin(int min) {
		this.min = min;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
