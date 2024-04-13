/**
 * 
 */
package com.train.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.userservice.entity.Ticket;

/**
 * 
 */

public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
