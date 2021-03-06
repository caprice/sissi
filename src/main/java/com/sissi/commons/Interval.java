package com.sissi.commons;

import java.util.concurrent.TimeUnit;

/**
 * @author kim 2013年11月28日
 */
public class Interval {

	private final Long interval;

	private final TimeUnit unit;

	public Interval(Long interval, TimeUnit unit) {
		super();
		this.interval = interval;
		this.unit = unit;
	}

	public Long getInterval() {
		return interval;
	}

	public TimeUnit getUnit() {
		return unit;
	}
}