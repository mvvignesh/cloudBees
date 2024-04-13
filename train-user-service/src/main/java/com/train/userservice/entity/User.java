/**
 * 
 */
package com.train.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@Column(name = "first_name")
	@NotBlank(message = "First Name is mandatory")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Last Name is mandatory")
	private String lastName;

	@Column(name = "email_address")
	@NotBlank(message = "Mail address is mandatory")
	@Email(message = "Provide mail id in proper format")
	private String emailAddress;
}
