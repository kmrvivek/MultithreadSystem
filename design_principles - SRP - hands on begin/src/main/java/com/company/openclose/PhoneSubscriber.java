package com.company.openclose;

import java.util.List;

public class PhoneSubscriber extends Subscriber{

	public PhoneSubscriber() {}

	@Override /*modified - open for modification*/
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration*baseRate/100;
    }



}