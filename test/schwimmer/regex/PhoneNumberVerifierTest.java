package schwimmer.regex;

import org.junit.Test;

import junit.framework.Assert;

public class PhoneNumberVerifierTest {

	@Test
	public void testVerify() {
		PhoneNumberVerifier verifier = new PhoneNumberVerifier();
		Assert.assertTrue(verifier.verify("2345678"));
		Assert.assertTrue(verifier.verify("12345678901"));
		Assert.assertTrue(verifier.verify("1-2345678901"));
		Assert.assertTrue(verifier.verify("1 2345678901"));
		Assert.assertTrue(verifier.verify("2345678901"));
		Assert.assertFalse(verifier.verify("12345678"));
		Assert.assertFalse(verifier.verify("1234567"));
		Assert.assertFalse(verifier.verify("223456"));
		Assert.assertFalse(verifier.verify("22345678"));
	}

}
