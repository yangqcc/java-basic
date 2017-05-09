package com.yqc.collection.map;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

class VeryBig {
	private static final int SIZE = 10000;
	private long[] la = new long[SIZE];
	private String ident;

	public VeryBig(String id) {
		ident = id;
	}

	public String toString() {
		return ident;
	}

	protected void finalize() {
		System.out.println("Finalizing " + ident);
	}
}

public class References {
	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

	public static void checkQueue() {
		Reference<? extends VeryBig> inq = rq.poll();
		if (inq != null) {
			System.out.println("In queue: " + inq.get());
		}
	}
}
