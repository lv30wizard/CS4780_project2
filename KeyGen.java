package RSA;

public class KeyGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p, q, n, øn, pm1, qm1, e, em1, d;
		// generate random prime number p
		while (true) {
			p = (int) (Math.random() * (199 - 2) + 2);
			if (checkPrime(p)) {
				System.out.println("P = " + p);
				break;
			}
		}

		// generate random prime number q
		while (true) {
			q = (int) (Math.random() * (199 - 2) + 2);
			if (checkPrime(q)) {
				System.out.println("Q = " + q);
				break;
			}
		}

		// calculate n
		n = (p * q);
		System.out.println("N = " + n);

		// calculate ø(n)
		pm1 = (p - 1);
		qm1 = (q - 1);
		øn = (pm1 * qm1);
		System.out.println("ø(n) = " + øn);

		// calculate e
		while (true) {
			e = (int) (Math.random() * øn + 2);
			if (checkPrime(p)) {
				System.out.println("e = " + e);
				break;
			}
		}

		// calculate d
		em1 = (e - 1);
		d = em1 % øn;
		System.out.println("d = " + d);

	}// end of main

	// check if random prime is an actual prime
	private static boolean checkPrime(int ip) {
		for (int i = 2; i <= Math.sqrt(ip); i++) {
			if (ip % i == 0) {
				return false;
			}
		}
		return true;
	}
}

//In this project, you are going to implement a RSA based digital signature system. 
//Please check the textbook or slides for the detailed description of the algorithm. 
//You should use Java to implement the algorithm. In Java, class BigInteger provides 
//the functionality to deal with large n-bit numbers.
//
//1. Write a program KeyGen.java to implement the key generation part of the RSA system.
//
//		· Pick p and q to be random primes of some specified length using the appropriate BigInteger constructor for Java.
//		
//		· Calculate n =  p x q
//		
//		· Calculate ø(n) = ( p-1)x(q-1)  
//		
//		· Pick e to be a random prime between 1 and ø(n), such that gcd(e, ø(n)) = . e should be similar in (bit) length to 
//		  p and q, but does not have to be the same length.
//		
//		· Calculate  d = e-1 mod ø(n) :
//
//In BigInteger the method used for this purpose is
//
//public BigInteger modInverse(BigInteger m)
//
//When you execute this program, it should generate new public and private keys for your RSA cryptosystem, where p, q and e as 
//defined above are all 512-bit integers and n  should be ~1024 bits. Your program should output all three values e, d and n to 
//the console as it generates them.  The values e and n should also be saved to a file called "pubkey.rsa" and the values d and n 
//should be saved to a file "privkey.rsa".  To allow for nice access of these files, you MUST output and input these keys to and 
//from the files using a Java ObjectOutputStream and ObjectInputStream.