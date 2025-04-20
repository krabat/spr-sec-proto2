package com.example.sprsecproto2.core;

import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {
	
	@NonNull
	private final EmbeddedStorageManager storage;
	
	
	private StoreRoot get() {
		return ( StoreRoot )storage.root();
	}
	
	public StoreRoot update() {
		StoreRoot root = get();
		root.update();
		storage.storeRoot();
		return root;
	}
	
}
