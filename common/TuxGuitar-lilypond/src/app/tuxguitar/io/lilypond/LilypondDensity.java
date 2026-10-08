package app.tuxguitar.io.lilypond;

/**
 * How much air the page gets.
 *
 * A guitar track is visually heavy on its own, because a strummed beat prints as a full stack of
 * note heads in the staff plus six fret numbers underneath. LilyPond's stock spacing packs those
 * systems close together, which makes the result feel cramped even though nothing is wrong with
 * it. These presets only touch spacing, never the music.
 */
public enum LilypondDensity {

	/** Leave LilyPond's own spacing alone. */
	DEFAULT("default"),

	/** Tight, for fitting as much as possible on a sheet. */
	COMPACT("compact"),

	/** Roomy, keeps the notation and the tab clearly apart. */
	AIRY("airy");

	public static final LilypondDensity DEFAULT_DENSITY = AIRY;

	private final String code;

	LilypondDensity(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public static LilypondDensity fromCode(String code) {
		for (LilypondDensity density : values()) {
			if (density.code.equals(code)) {
				return density;
			}
		}
		return DEFAULT_DENSITY;
	}
}
