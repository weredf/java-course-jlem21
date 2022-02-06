package app.core.beans;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class Count extends Thread {

	private boolean on;

	public Count(String name) {
		super(name);
	}

	public Count() {
	}

	@Override
	public void run() {
		int c = 1;
		while (on) {
			System.out.println(c++);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// @PostConstruct and @PreDestroy are not spring annotations, but can still be used in spring

	@PostConstruct
	public void construct() {
		on = true;
		start();
	}

	@PreDestroy
	public void destroy() {
		on = false;
		
	}
}
