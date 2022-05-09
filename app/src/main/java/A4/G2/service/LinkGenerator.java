package A4.G2.service;

public class LinkGenerator implements ILinkGenerator {
	private final String site = "https://www.g2gallery.com/";

	public String generateLink(String customerSiteId) {
		String link;
		link = site + customerSiteId;
		return link;
	}
}
