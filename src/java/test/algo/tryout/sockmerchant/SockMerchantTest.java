package algo.tryout.sockmerchant;

import org.junit.jupiter.api.Test;


public class SockMerchantTest {

	@Test
	public void testSockMerchant() {
		SockMerchant sockMerchant=new SockMerchant();
		int sd=sockMerchant.sockMerchant(9, new int[] {20,10,20,10,10,30,50,10,20});
		System.out.println(sd);
	}
	
	@Test
	public void testSockMerchant1() {
		SockMerchant sockMerchant=new SockMerchant();
		int sd=sockMerchant.sockMerchant(10, new int[] {1,1,3,1,2,1,3,3,3,3});
		System.out.println(sd);
	}
	
	
	 
}
