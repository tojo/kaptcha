package com.google.code.kaptcha;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class KaptchaTest {
	static Kaptcha sut;

	@BeforeClass
	public static void before() {
		sut = new Kaptcha();
	}

	@Test
	public void testIssueKaptcha() {
		byte[] captcha = sut.issueCaptcha("foo");
		assertNotNull(captcha);
	}

}
