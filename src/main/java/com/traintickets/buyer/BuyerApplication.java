package com.traintickets.buyer;

import com.traintickets.buyer.entity.Ticket;
import com.traintickets.buyer.entity.User;
import com.traintickets.buyer.service.BuyerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuyerApplication {

	public static void main(String[] args) {

		try {
			Ticket testTicket = new Ticket();
			testTicket.setId(1);
			testTicket.setStartingStation("wroclaw-glowny");
			testTicket.setDestination("lublin-glowny");
			testTicket.setDepartureTime("16-07-2024_05:00");
			User testUser = new User();

			BuyerService.logInKoleo(testTicket, testUser);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

//		SpringApplication.run(BuyerApplication.class, args);
	}

}
