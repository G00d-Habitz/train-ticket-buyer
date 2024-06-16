package com.traintickets.buyer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private long id;
    private String email;
    private String password;
    private String startingStation;
    private String destination;
    private String departureTime;
    private String arrivalTime;
}
