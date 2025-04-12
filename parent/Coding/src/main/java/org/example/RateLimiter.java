package org.example;

import java.util.*;

public class RateLimiter {

    Map<Integer, List<Long>> customerRequests;
    int limit;

    public RateLimiter(int limitPerMinute) {
        customerRequests = new HashMap<>();
        limit = limitPerMinute;
    }

    public boolean isAllowed(int customerId, long millis) {

        List<Long> oldRequests =  customerRequests.getOrDefault(customerId, new LinkedList<>());

        customerRequests.put(customerId, oldRequests);

        int size = oldRequests.size();

        if ( size == limit ) {

            System.out.println("Limit Reached !!");
            System.out.println("Size : " + size );
            long oldestTimestamp = oldRequests.get(0);
            long difference = millis - oldestTimestamp;

            if (difference < 60000) {

                return false;
            }
        }

        oldRequests.add(millis);
        size = oldRequests.size();

        if ( size > limit ) {
            oldRequests.remove(0);
        }



        return true;
    }

    public static void main(String[] args) {

        RateLimiter rateLimiter = new RateLimiter(5);

        System.out.println(rateLimiter.isAllowed(100, 1));
        System.out.println(rateLimiter.isAllowed(100, 1001));
        System.out.println(rateLimiter.isAllowed(100, 2001));
        System.out.println(rateLimiter.isAllowed(100, 3001));
        System.out.println(rateLimiter.isAllowed(100, 4001));
        System.out.println(rateLimiter.isAllowed(100, 5001));
        System.out.println(rateLimiter.isAllowed(100, 65001));


    }

}
