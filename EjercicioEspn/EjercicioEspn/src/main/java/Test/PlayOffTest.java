package Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Page.EspnHomePage;
import Page.NflPage;
import Page.PlayOffPage;
import Page.StandingsPage;

public class PlayOffTest extends BaseTest{

	@Test
	public void test1() {
		EspnHomePage page=homePage();
		page.handlePopUps(page.getString(),page.mainWindowHandle());
		NflPage nfl=page.initialSubmit();
		StandingsPage standings=nfl.submitStandings();
		standings.handlePopUps(standings.getString(),standings.mainWindowHandle());
		PlayOffPage playoff=standings.selectPlayOff();
		playoff.handlePopUps(playoff.getString(),playoff.mainWindowHandle());
		assertTrue(playoff.getLogo().isDisplayed());
	}
}
