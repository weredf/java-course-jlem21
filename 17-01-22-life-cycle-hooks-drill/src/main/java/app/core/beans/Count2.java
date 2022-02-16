package app.core.beans;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Count2 extends Thread implements InitializingBean, DisposableBean {

	private boolean on;

	public Count2(String name) {
		super(name);
	}

	public Count2() {
	}

	@Override
	public void run() {
		int c = 1;
		while (on) {
			System.out.println(">>>" + c++);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception{
		on = true;
		start();
	}

	@Override
	public void destroy() {
		on = false;
	}
}
