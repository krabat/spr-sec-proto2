package com.example.sprsecproto2.core;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StoreRoot {
	
	private final LocalDateTime created;
	private LocalDateTime updated;
	
	public StoreRoot() {
		created = LocalDateTime.now();
		update();
	}
	
	public StoreRoot update() {
		updated = LocalDateTime.now();
		return this;
	}
}
