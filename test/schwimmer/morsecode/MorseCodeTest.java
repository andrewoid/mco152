package schwimmer.morsecode;
import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testToMorseCode() {
		final MorseCode translater = new MorseCode();

		final String code = translater
				.toMorseCode("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
		Assert.assertEquals(
				".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. ----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.",
				code);

	}

	@Test
	public void testToPlainText() {
		final MorseCode translater = new MorseCode();

		final String plainText = translater
				.toPlainText(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. ----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.");
		Assert.assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", plainText);
	}

	@Test
	public void testToMorseCodeWithSpaces() {
		final MorseCode translater = new MorseCode();
		final String code = translater.toMorseCode("Three Blind Mice");
		Assert.assertEquals(
				"- .... .-. . . / -... .-.. .. -. -.. / -- .. -.-. .", code);
	}

	@Test
	public void testToPlainTextWithSpaces() {
		final MorseCode translater = new MorseCode();
		final String plainText = translater
				.toPlainText("- .... .-. . . / -... .-.. .. -. -.. / -- .. -.-. .");
		Assert.assertEquals("THREE BLIND MICE", plainText);
	}

}
