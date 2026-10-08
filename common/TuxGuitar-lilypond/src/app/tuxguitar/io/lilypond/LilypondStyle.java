package app.tuxguitar.io.lilypond;

/**
 * Engraving styles for the LilyPond backend.
 *
 * The note heads, clefs and other musical symbols always come from LilyPond's own Emmentaler
 * font, so a style here only selects the text face and the page typography around the music.
 * That is what actually decides whether a printed page reads as heavy or as clean, because the
 * default title markup is bold and the default text face is a fairly chunky Century Schoolbook.
 */
public enum LilypondStyle {

	/** LilyPond's own defaults, exactly as previous versions of this exporter produced them. */
	LILYPOND_DEFAULT("lilypond-default"),

	/** Computer Modern flavoured: light, high contrast, no bold display type. The LaTeX look. */
	MODERN_CM("modern-cm"),

	/** Sans serif throughout, in the spirit of a modern lead sheet. */
	MODERN_SANS("modern-sans");

	public static final LilypondStyle DEFAULT_STYLE = MODERN_CM;

	private final String code;

	LilypondStyle(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public static LilypondStyle fromCode(String code) {
		for (LilypondStyle style : values()) {
			if (style.code.equals(code)) {
				return style;
			}
		}
		return DEFAULT_STYLE;
	}
}
