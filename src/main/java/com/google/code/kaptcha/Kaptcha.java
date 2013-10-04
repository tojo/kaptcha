package com.google.code.kaptcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.code.kaptcha.util.Config;

/**
 * @author github.com/tojo
 */
public class Kaptcha {

	private Producer kaptchaProducer = null;

	public Kaptcha() {
		// Switch off disk based caching.
		ImageIO.setUseCache(false);

		Config config = new Config();
		this.kaptchaProducer = config.getProducerImpl();
	}

	/**
	 * Create text for the captcha image.
	 * 
	 * @return generated text for a captcha image
	 */
	public String createText() {
		return this.kaptchaProducer.createText();
	}

	/**
	 * Create a new captcha image with the given text.
	 * 
	 * @param text
	 *            the text for the new captcha image
	 * @return captcha image as byte[]
	 */
	public byte[] issueCaptcha(String text) {

		// create the image with the text
		BufferedImage bi = this.kaptchaProducer.createImage(text);

		// write the data out
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(bi, "jpg", out);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return out.toByteArray();
	}
}