/**
 * 
 */
package com.train.userservice.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Vignesh
 */
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TrainTicket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "from_place")
	@NotBlank(message = "From Location is mandatory")
	private String fromPlace;

	@Column(name = "destination")
	@NotBlank(message = "To Location is mandatory")
	private String destination;

	@Column(name = "price_paid")
	@Min(value = 1 , message = "Value should be greater then then equal to 1")
    @Max(value = 5 , message = "Value should be less then then equal to 5")
	private int pricePaid;

	@Column(name = "section")
	@NotBlank(message = "Section is mandatory")
	private String section;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private User userDetails;
}
