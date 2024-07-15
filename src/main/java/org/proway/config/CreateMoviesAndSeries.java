package org.proway.config;

import org.proway.controller.NetflixSystem;
import org.proway.model.media.Episode;
import org.proway.model.media.Genre;
import org.proway.model.media.Movie;
import org.proway.model.media.Series;

import java.util.*;

import static java.util.Map.entry;

public class CreateMoviesAndSeries {
    private NetflixSystem netflixSystem;

    public NetflixSystem getNetflixSystem() {
        return netflixSystem;
    }

    public void setNetflixSystem(NetflixSystem netflixSystem) {
        this.netflixSystem = netflixSystem;
    }

    public CreateMoviesAndSeries(NetflixSystem netflixSystem) {
        this.netflixSystem = netflixSystem;
        addMovies();
        addSeries();
    }

    private void addMovies(){
        Movie filmeHomemAranha = new Movie(
                "Spider-Man",
                "Spider-Man centers on student Peter Parker (Tobey Maguire) who, after being bitten by a genetically-altered spider, gains superhuman strength and the spider-like ability to cling to any surface. He vows to use his abilities to fight crime, coming to understand the words of his beloved Uncle Ben: With great power comes great responsibility.",
                new ArrayList<String>(Arrays.asList("Tobey Maguire", "Willem Dafoe", "Kirsten Dunst", "James Franco", "Cliff Robertson")),
                7.4,
                "2002-05-03",
                Genre.ACTION,
                121
        );

        Movie filmeDoBatman = new Movie(
                "The Dark Knight",
                "With the help of allies Lt. Jim Gordon (Gary Oldman) and DA Harvey Dent (Aaron Eckhart), Batman (Christian Bale) has been able to keep a tight lid on crime in Gotham City. But when a vile young criminal calling himself the Joker (Heath Ledger) suddenly throws the town into chaos, the caped Crusader begins to tread a fine line between heroism and vigilantism.",
                new ArrayList<String>(Arrays.asList("Christian Bale", "Heath Ledger", "Aaron Eckhart", "Michael Caine", "Maggie Gyllenhaal")),
                7.4,
                "2018-07-18",
                Genre.ACTION,
                152
        );
        netflixSystem.getCatalog().add(filmeHomemAranha);
        netflixSystem.getCatalog().add(filmeDoBatman);
    }

    private void addSeries(){
        Series theBoys = new Series(
                "The Boys",
                "Superheroes are often as popular as celebrities, as influential as politicians, and sometimes even as revered as gods. But that's when they're using their powers for good. What happens when the heroes go rogue and start abusing their powers? When it's the powerless against the super powerful, the Boys head out on a heroic quest to expose the truth about the Seven and Vought, the multibillion-dollar conglomerate that manages the superheroes and covers up their dirty secrets. Based on the comic book series of the same name.",
                new ArrayList<String>(Arrays.asList("Philip Sgriccia", "Frederick E.O. Toye", "Sarah Boyd", "Eric Kripke", "CStefan Schwartz")),
                8.7,
                "2019-07-26",
                Genre.COMEDY,
                new HashMap<Integer, List<Episode>>() {{
                    put(1, Arrays.asList(
                            new Episode(
                                    "The Name of the Game",
                                    60,
                                    1,
                                    1,
                                    "Hughie Campbell suffers mental trauma after his girlfriend Robin is killed in a high-velocity impact with celebrity superhero A-Train. Lawyers from Vought International offer a $45,000 settlement, which Hughie hesitates to accept. Aspiring superhero Annie January auditions as \"Starlight\" and is accepted to join the Seven, following the retirement of the Lamplighter. Arriving at Seven headquarters, she is greeted by the Deep, who blackmails her into giving him oral sex.[6] Billy Butcher offers Hughie a chance to expose superhero corruption. Butcher takes Hughie to a secret \"Supes club\", and shows him security footage of A-Train laughing about Robin's death. Butcher asks Hughie to take the settlement money and to plant a bug at Seven Tower, but Hughie refuses. In Central Park, Annie meets Hughie. They motivate each other to stand up for themselves, and face their challenges. Hughie plants the bug. Translucent discovers the bug and confronts Hughie alone at work. Butcher arrives and together they incapacitate Translucent. Elsewhere, Homelander shoots down the Mayor of Baltimore's plane, owing to his attempts to blackmail Vought."
                            ),
                            new Episode(
                                    "Cherry",
                                    60,
                                    1,
                                    2,
                                    "Butcher and Hughie take Translucent to Frenchie, who makes a meta-bullet to pierce his diamond-hard skin, but it fails to kill Translucent. Butcher turns to CIA Dept. Director Susan Raynor for the \"Mallory files\", but she refuses. Vought VP Madelyn Stillwell tells Seven leader Homelander about the evidence Deep found incriminating him for the plane crash, so she handles it while he talks to Deep. The night Starlight teams-up with the Deep, she promises to kill him if he ever tries to sexually assault her again. Stillwell blackmails Oklahoma Senator Calhoun into allowing a vote that could enable Vought to contract superheros to the military. Annie stops a rape, unaware she is being recorded. Her agent, Ashley, rages at her because of the negative exposure and legal implications. While Homelander searches for Translucent, Frenchie decides to place C-4 in Translucent's colon, who then fearfully reveals A-Train was with his girlfriend Popclaw before he killed Robin. They learn Homelander is nearby, and cannot risk killing Translucent. Frenchie and Butcher cause an explosive distraction.—Aaron Kyle"
                            )
                    ));
                }}
        );
        /*
        Map<Integer, List<Episode>> seasons = new HashMap<Integer, List<Episode>>();
        List<Episode> episodes = new ArrayList<Episode>();
        Episode EPone = new Episode(
                "The Name of the Game",
                60,
                1,
                1,
                "Hughie Campbell suffers mental trauma after his girlfriend Robin is killed in a high-velocity impact with celebrity superhero A-Train. Lawyers from Vought International offer a $45,000 settlement, which Hughie hesitates to accept. Aspiring superhero Annie January auditions as \"Starlight\" and is accepted to join the Seven, following the retirement of the Lamplighter. Arriving at Seven headquarters, she is greeted by the Deep, who blackmails her into giving him oral sex.[6] Billy Butcher offers Hughie a chance to expose superhero corruption. Butcher takes Hughie to a secret \"Supes club\", and shows him security footage of A-Train laughing about Robin's death. Butcher asks Hughie to take the settlement money and to plant a bug at Seven Tower, but Hughie refuses. In Central Park, Annie meets Hughie. They motivate each other to stand up for themselves, and face their challenges. Hughie plants the bug. Translucent discovers the bug and confronts Hughie alone at work. Butcher arrives and together they incapacitate Translucent. Elsewhere, Homelander shoots down the Mayor of Baltimore's plane, owing to his attempts to blackmail Vought."
        );
        Episode EPtwo = new Episode(
                "Cherry",
                60,
                1,
                2,
                "Butcher and Hughie take Translucent to Frenchie, who makes a meta-bullet to pierce his diamond-hard skin, but it fails to kill Translucent. Butcher turns to CIA Dept. Director Susan Raynor for the \"Mallory files\", but she refuses. Vought VP Madelyn Stillwell tells Seven leader Homelander about the evidence Deep found incriminating him for the plane crash, so she handles it while he talks to Deep. The night Starlight teams-up with the Deep, she promises to kill him if he ever tries to sexually assault her again. Stillwell blackmails Oklahoma Senator Calhoun into allowing a vote that could enable Vought to contract superheros to the military. Annie stops a rape, unaware she is being recorded. Her agent, Ashley, rages at her because of the negative exposure and legal implications. While Homelander searches for Translucent, Frenchie decides to place C-4 in Translucent's colon, who then fearfully reveals A-Train was with his girlfriend Popclaw before he killed Robin. They learn Homelander is nearby, and cannot risk killing Translucent. Frenchie and Butcher cause an explosive distraction.—Aaron Kyle"
                );
        episodes.add(EPone);
        episodes.add(EPtwo);
        seasons.put(1, episodes);
        theBoys.addSeason(seasons);
        */
        netflixSystem.getCatalog().add(theBoys);
    }
}
