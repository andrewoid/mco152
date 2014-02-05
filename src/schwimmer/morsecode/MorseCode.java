package schwimmer.morsecode;

import java.util.HashMap;

public class MorseCode {

	private final HashMap<Character, String>	charToCode;
	private final HashMap<String, Character>	codeToChar;

	public MorseCode() {
		charToCode = new HashMap<Character, String>();
		codeToChar = new HashMap<String, Character>();

		add('A', ".-");
		add('B', "-...");
		add('C', "-.-.");
		add('D', "-..");
		add('E', ".");
		add('F', "..-.");
		add('G', "--.");
		add('H', "....");
		add('I', "..");
		add('J', ".---");
		add('K', "-.-");
		add('L', ".-..");
		add('M', "--");
		add('N', "-.");
		add('O', "---");
		add('P', ".--.");
		add('Q', "--.-");
		add('R', ".-.");
		add('S', "...");
		add('T', "-");
		add('U', "..-");
		add('V', "...-");
		add('W', ".--");
		add('X', "-..-");
		add('Y', "-.--");
		add('Z', "--..");

		add(' ', "/");

		add('0', "-----");
		add('1', ".----");
		add('2', "..---");
		add('3', "...--");
		add('4', "....-");
		add('5', ".....");
		add('6', "-....");
		add('7', "--...");
		add('8', "---..");
		add('9', "----.");

	}

	private void add(final char c, final String s) {
		charToCode.put(c, s);
		codeToChar.put(s, c);
	}

	public String toMorseCode(final String plainText) {

		if (plainText.length() == 0) {
			return "";
		}

		final StringBuilder builder = new StringBuilder();
		final char[] array = plainText.toUpperCase().toCharArray();
		for (int i = 0; i < array.length; i++) {
			final String code = charToCode.get(array[i]);
			if (code == null) {
				continue;
			}
			builder.append(code);
			builder.append(" ");
		}
		return builder.toString().trim();
	}

	public String toPlainText(final String morseCode) {
		if (morseCode.length() == 0) {
			return "";
		}

		final StringBuilder builder = new StringBuilder();
		final String[] words = morseCode.split("/");

		convertWordToPlainText(builder, words[0]);
		for (int i = 1; i < words.length; i++) {
			builder.append(" ");
			convertWordToPlainText(builder, words[i]);
		}
		return builder.toString();
	}

	private void convertWordToPlainText(final StringBuilder builder, final String word) {
		for (final String code : word.split(" ")) {
			final Character c = codeToChar.get(code);
			if (c == null) {
				continue;
			}
			builder.append(c);
		}
	}
}
