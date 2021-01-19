package org.thing.in.spring.ratelimiter;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.thing.in.spring.v2.ratelimiter.alg.RateLimiter;
import org.thing.in.spring.v2.ratelimiter.alg.impl.FixedTimeWindowRateLimiter;
import org.thing.in.spring.v2.ratelimiter.exception.InternalErrorException;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;

import junit.framework.TestCase;

public class FixedTimeWindowRateLimiterTest extends TestCase{

  public void testTryAquire() throws InternalErrorException {
    Ticker ticker = Mockito.mock(Ticker.class);
    when(ticker.read()).thenReturn(0*1000*1000l);
    RateLimiter ratelimiter = new FixedTimeWindowRateLimiter(5, Stopwatch.createStarted(ticker));
    
    when(ticker.read()).thenReturn(100*1000*1000l);
    boolean passed1 = ratelimiter.tryAcquire();
    assertTrue(passed1);
    
    when(ticker.read()).thenReturn(200*1000*1000l);
    boolean passed2 = ratelimiter.tryAcquire();
    assertTrue(passed2);
    
    when(ticker.read()).thenReturn(300*1000*1000l);
    boolean passed3 = ratelimiter.tryAcquire();
    assertTrue(passed3);
    
    when(ticker.read()).thenReturn(400*1000*1000l);
    boolean passed4 = ratelimiter.tryAcquire();
    assertTrue(passed4);
    
    when(ticker.read()).thenReturn(500*1000*1000l);
    boolean passed5 = ratelimiter.tryAcquire();
    assertTrue(passed5);
    
    when(ticker.read()).thenReturn(600*1000*1000l);
    boolean passed6 = ratelimiter.tryAcquire();
    assertFalse(passed6);
    
    when(ticker.read()).thenReturn(1001*1000*1000l);
    boolean passed7 = ratelimiter.tryAcquire();
    assertTrue(passed7);
  }
  
  public void testTryAquire_runOnMultiThreads() {
    // TODO
  }

}
