package app.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Address;
import app.core.repositories.AddressRepo;

@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application2.class, args);
//		CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
		AddressRepo addressRepo = ctx.getBean(AddressRepo.class);

//		Address address = addressRepo.findById(1).get();
		Optional<Address> opt = addressRepo.findById(4);
		if(opt.isPresent()) {
			Address address = opt.get();
			System.out.println(address);
			System.out.println(address.getCompany());
		} else {
			System.out.println("Not found");
		}
		
		
	}

}
