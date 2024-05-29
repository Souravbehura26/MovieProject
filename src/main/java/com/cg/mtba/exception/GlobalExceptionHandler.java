package com.cg.mtba.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyUserException(UserException u, HttpServletRequest req) {
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),u.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyCustomerException(CustomerException c, HttpServletRequest req) {
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),c.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookingException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyBookingException(BookingException b,HttpServletRequest req) {
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),b.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SeatException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMySeatException(SeatException s,HttpServletRequest req) {
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),s.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ShowException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyShowException(ShowException sh, HttpServletRequest req) {
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),sh.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MovieException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyMovieException(MovieException m,HttpServletRequest req){
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),m.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(TheatreException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyTheatreException(TheatreException t,HttpServletRequest req){
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),t.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TicketException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyTicketException(TicketException t,HttpServletRequest req){
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),t.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ScreenException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> getMyShowException(ScreenException s,HttpServletRequest req){
		ErrorInfo err=new ErrorInfo (LocalDateTime.now(),s.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}
	
	
}
