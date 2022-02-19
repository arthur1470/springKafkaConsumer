package com.kafka.consumer.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankAccountDTO {

	private String agency;
	private String accountNumber;
	private Double balance;
}
