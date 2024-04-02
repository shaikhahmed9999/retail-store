package com.store.retail.modals;

import java.time.LocalDateTime;

import com.store.retail.constants.Industry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String itemName;
	private String description;
	private double price;
	private Industry industry;
	private boolean status;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

}
