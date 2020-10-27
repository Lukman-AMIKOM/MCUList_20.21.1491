package com.pam.mculist_20211491;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MoviesData {
    
    private static final String QUOTE = "\"";
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String QCQ = QUOTE + COLON + QUOTE;
    private static final String QCMQ = QUOTE + COMMA + QUOTE;
    private static final String CLOSING_BRACKET = "}";
    
    private static final String poster = "poster";
    private static final String title = "title";
    private static final String year = "year";
    private static final String date = "date";
    private static final String details = "details";
    private static final String director = "director";
    private static final String stars = "stars";
    private static final String synopsis = "synopsis";
    private static final String chronologicalIndex = "chronologicalIndex";
    private static final String phase = "phase";
    
    private static final String POSTER = QUOTE + poster + QUOTE + COLON;
    private static final String TITLE = COMMA + QUOTE + title + QCQ;
    private static final String YEAR = QCMQ + year + QCQ;
    private static final String DATE = QCMQ + date + QCQ;
    private static final String DETAILS = QCMQ + details + QCQ;
    private static final String DIRECTOR = QCMQ + director + QCQ;
    private static final String STARS = QCMQ + stars + QCQ;
    private static final String SYNOPSIS = QCMQ + synopsis + QCQ;
    private static final String CHRONOLOGICAL_INDEX = QCMQ + chronologicalIndex + QCQ;
    private static final String PHASE = QCMQ + phase + QCQ;
    
    public static final String PHASE_ONE = "One";
    public static final String PHASE_TWO = "Two";
    public static final String PHASE_THREE = "Three";
    public static final String PHASE_FOUR = "Four";
    
    private static final String[] movies = {
            "{" +
                    POSTER + R.drawable.poster_iron_man +
                    TITLE + "Iron Man" +
                    YEAR + "2008" +
                    DETAILS + "PG-13 | 2h 6min | Action, Adventure, Sci-Fi | " +
                    DATE + "2 May 2008" +
                    DIRECTOR + "Jon Favreau" +
                    STARS + "Robert Downey Jr., Gwyneth Paltrow, Terrence Howard, Jeff Bridges" +
                    SYNOPSIS + "Tony Stark. Genius, billionaire, playboy, philanthropist. Son " +
                    "of legendary inventor and weapons contractor Howard Stark. When Tony Stark is " +
                    "assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James" +
                    " Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee" +
                    " that he's riding in is attacked by enemy combatants. He survives - barely - with a" +
                    " chest full of shrapnel and a car battery attached to his heart. In order to survive " +
                    "he comes up with a way to miniaturize the battery and figures out that the battery can " +
                    "power something else. Thus Iron Man is born. He uses the primitive device to escape from " +
                    "the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But " +
                    "the man who was put in charge of Stark Industries has plans of his own to take over Tony's" +
                    " technology for other matters." +
                    CHRONOLOGICAL_INDEX + 3 +
                    PHASE + PHASE_ONE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_the_incredible_hulk +
                    TITLE + "The Incredible Hulk" +
                    YEAR + "2008" +
                    DETAILS + "PG-13 | 1h 52min | Action, Adventure, Sci-Fi | " +
                    DATE + "13 June 2008" +
                    DIRECTOR + "Louis Leterrier" +
                    STARS + "Edward Norton, Liv Tyler, Tim Roth, William Hurt" +
                    SYNOPSIS + "Depicting the events after the Gamma Bomb. 'The Incredible Hulk'" +
                    " tells the story of Dr Bruce Banner, who seeks a cure to his unique condition," +
                    " which causes him to turn into a giant green monster under emotional stress. Whilst" +
                    " on the run from military which seeks his capture, Banner comes close to a cure. But" +
                    " all is lost when a new creature emerges: The Abomination." +
                    CHRONOLOGICAL_INDEX + 4 +
                    PHASE + PHASE_ONE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_iron_man_2 +
                    TITLE + "Iron Man 2" +
                    YEAR + "2010" +
                    DETAILS + "PG-13 | 2h 4min | Action, Adventure, Sci-Fi | " +
                    DATE + "7 May 2010" +
                    DIRECTOR + "Jon Favreau" +
                    STARS + "Robert Downey Jr., Mickey Rourke, Don Cheadle, Gwyneth Paltrow, Scarlett Johansson" +
                    SYNOPSIS + "With the world now aware of his dual life as the armored superhero" +
                    " Iron Man, billionaire inventor Tony Stark faces pressure from the government, " +
                    "the press, and the public to share his technology with the military. Unwilling to " +
                    "let go of his invention, Stark, along with Pepper Potts, and James \\\"Rhodey\\\" Rhodes " +
                    "at his side, must forge new alliances - and confront powerful enemies." +
                    CHRONOLOGICAL_INDEX + 5 +
                    PHASE + PHASE_ONE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_thor +
                    TITLE + "Thor" +
                    YEAR + "2011" +
                    DETAILS + "PG-13 | 1h 55min | Action, Adventure, Fantasy | " +
                    DATE + "6 May 2011" +
                    DIRECTOR + "Kenneth Branagh" +
                    STARS + "Chris Hemsworth, Anthony Hopkins, Natalie Portman, Tom Hiddleston, Stellan Skarsgård" +
                    SYNOPSIS + "The warrior Thor (Chris Hemsworth) is cast out of the fantastic realm of Asgard by" +
                    " his father Odin (Sir Anthony Hopkins) for his arrogance and sent to Earth to live amongst humans." +
                    " Falling in love with scientist Jane Foster (Natalie Portman) teaches Thor much-needed lessons, and" +
                    " his new-found strength comes into play as a villain from his homeland sends dark forces toward Earth." +
                    CHRONOLOGICAL_INDEX + 6 +
                    PHASE + PHASE_ONE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_captain_america_the_first_avenger +
                    TITLE + "Captain America: The First Avenger" +
                    YEAR + "2011" +
                    DETAILS + "PG-13 | 2h 4min | Action, Adventure, Sci-Fi | " +
                    DATE + "22 July 2011" +
                    DIRECTOR + "Joe Johnston" +
                    STARS + "Chris Evans, Hugo Weaving, Hayley Atwell, Sebastian Stan, Tommy Lee Jones, Samuel L. Jackson" +
                    SYNOPSIS + "It is 1942, America has entered World War II, and sickly but determined Steve Rogers is " +
                    "frustrated at being rejected yet again for military service. Everything changes when Dr. Erskine recruits" +
                    " him for the secret Project Rebirth. Proving his extraordinary courage, wits and conscience, Rogers undergoes" +
                    " the experiment and his weak body is suddenly enhanced into the maximum human potential. When Dr. Erskine is " +
                    "then immediately assassinated by an agent of Nazi Germany's secret HYDRA research department (headed by Johann " +
                    "Schmidt, a.k.a. the Red Skull), Rogers is left as a unique man who is initially misused as a propaganda mascot; " +
                    "however, when his comrades need him, Rogers goes on a successful adventure that truly makes him Captain America, " +
                    "and his war against Schmidt begins." +
                    CHRONOLOGICAL_INDEX + 1 +
                    PHASE + PHASE_ONE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_the_avengers +
                    TITLE + "The Avengers" +
                    YEAR + "2012" +
                    DETAILS + "PG-13 | 2h 23min | Action, Adventure, Sci-Fi | " +
                    DATE + "4 May 2012" +
                    DIRECTOR + "Joss Whedon" +
                    STARS + "Robert Downey Jr., Chris Evans, Chris Hemsworth, Scarlett Johansson, Mark Ruffalo, Jeremy Renner, " +
                    "Tom Hiddleston, Samuel L. Jackson, Clark Gregg" +
                    SYNOPSIS + "Nick Fury is the director of S.H.I.E.L.D., an international peace-keeping agency. The agency is" +
                    " a who's who of Marvel Super Heroes, with Iron Man, The Incredible Hulk, Thor, Captain America, Hawkeye and" +
                    " Black Widow. When global security is threatened by Loki and his cohorts, Nick Fury and his team will need" +
                    " all their powers to save the world from disaster which is formed by Loki and his team." +
                    CHRONOLOGICAL_INDEX + 7 +
                    PHASE + PHASE_ONE + QUOTE + CLOSING_BRACKET,
            
            "{" +
                    POSTER + R.drawable.poster_iron_man_3 +
                    TITLE + "Iron Man 3" +
                    YEAR + "2013" +
                    DETAILS + "PG-13 | 2h 10min | Action, Adventure, Sci-Fi | " +
                    DATE + "3 May 2013" +
                    DIRECTOR + "Shane Black" +
                    STARS + "Robert Downey Jr., Guy Pearce, Don Cheadle, Gwyneth Paltrow, Ben Kingsley" +
                    SYNOPSIS + "Marvel's \\\"Iron Man 3\\\" pits brash-but-brilliant industrialist Tony Stark/Iron Man against an enemy" +
                    " whose reach knows no bounds. When Stark finds his personal world destroyed at his enemy's hands, he embarks on " +
                    "a harrowing quest to find those responsible. This journey, at every turn, will test his mettle. With his back against" +
                    " the wall, Stark is left to survive by his own devices, relying on his ingenuity and instincts to protect those closest" +
                    " to him. As he fights his way back, Stark discovers the answer to the question that has secretly haunted him: does the" +
                    " man make the suit or does the suit make the man?" +
                    CHRONOLOGICAL_INDEX + 8 +
                    PHASE + PHASE_TWO + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_thor_the_dark_world +
                    TITLE + "Thor: The Dark World" +
                    YEAR + "2013" +
                    DETAILS + "PG-13 | 1h 52min | Action, Adventure, Fantasy | " +
                    DATE + "8 November 2013" +
                    DIRECTOR + "Alan Taylor" +
                    STARS + "Chris Hemsworth, Natalie Portman, Tom Hiddleston, Anthony Hopkins, Idris Elba" +
                    SYNOPSIS + "Thousands of years ago, a race of beings known as Dark Elves tried to send the universe into darkness by using" +
                    " a weapon known as the Aether. Warriors from Asgard stopped them, but their leader Malekith (Christopher Eccleston) escaped" +
                    " to wait for another opportunity. The warriors find the Aether, and since it cannot be destroyed, they try to hide it. In the" +
                    " present day, Jane Foster (Natalie Portman) awaits the return of Thor (Chris Hemsworth), although it has been two years since" +
                    " they last saw once another. In the meantime, Thor has been trying to bring peace to the nine realms. Jane discovers an anomaly" +
                    " similar to the one that brought Thor to Earth. She goes to investigate, finds a wormhole, and is sucked into it. Back on Asgard," +
                    " Thor wishes to return to Earth, but his father, Odin (Sir Anthony Hopkins), refuses to let him. Thor learns from Heimdall (Idris" +
                    " Elba), who can see into all of the realms, that Jane disappeared. Thor then returns to Earth just as Jane reappears. However, when" +
                    " some Policemen try to arrest her, an unknown energy repulses them. Thor then brings Jane to Asgard to find out what happened to her." +
                    " When the energy is released again, they discover that when Jane disappeared, she crossed paths with the Aether and it entered her." +
                    " Malekith, upon sensing that the time to strike is now, seeks out the Aether. He attacks Asgard and Thor's mother Frigga (Rene Russo)" +
                    " is killed protecting Jane. Odin wants to keep Jane on Asgard so that Malekith will come. Thor disagrees with his plan, so with his " +
                    "cohorts, he decides to take Jane away. He enlists the aid of his brother, Loki (Tom Hiddleston). Unfortunately, Loki's motivations remain unknown." +
                    CHRONOLOGICAL_INDEX + 9 +
                    PHASE + PHASE_TWO + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_captain_america_the_winter_soldier +
                    TITLE + "Captain America: The Winter Soldier" +
                    YEAR + "2014" +
                    DETAILS + "PG-13 | 2h 16min | Action, Adventure, Sci-Fi | " +
                    DATE + "4 April 2014" +
                    DIRECTOR + "Anthony Russo & Joe Russo" +
                    STARS + "Chris Evans, Samuel L. Jackson, Scarlett Johansson, Sebastian Stan, Anthony Mackie, Robert Redford" +
                    SYNOPSIS + "For Steve Rogers, awakening after decades of suspended animation involves more than catching up on pop culture; it also means" +
                    " that this old school idealist must face a world of subtler threats and difficult moral complexities. That becomes clear when Director " +
                    "Nick Fury is killed by the mysterious assassin, the Winter Soldier, but not before warning Rogers that SHIELD has been subverted by its " +
                    "enemies. When Rogers acts on Fury's warning to trust no one there, he is branded as a traitor by the organization. Now a fugitive, Captain" +
                    " America must get to the bottom of this deadly mystery with the help of the Black Widow and his new friend, The Falcon. However, the battle" +
                    " will be costly for the Sentinel of Liberty, with Rogers finding enemies where he least expects them while learning that the Winter Soldier" +
                    " looks disturbingly familiar." +
                    CHRONOLOGICAL_INDEX + 10 +
                    PHASE + PHASE_TWO + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_guardians_of_the_galaxy +
                    TITLE + "Guardians of the Galaxy" +
                    YEAR + "2014" +
                    DETAILS + "PG-13 | 2h 1min | Action, Adventure, Comedy | " +
                    DATE + "1 August 2014" +
                    DIRECTOR + "James Gunn" +
                    STARS + "Chris Pratt, Zoe Saldana, Vin Diesel, Bradley Cooper, Michael Rooker, Karen Gillan, Lee Pace" +
                    SYNOPSIS + "After stealing a mysterious orb in the far reaches of outer space, Peter Quill from Earth is now the main target of a manhunt led " +
                    "by the villain known as Ronan the Accuser. To help fight Ronan and his team and save the galaxy from his power, Quill creates a team of space" +
                    " heroes known as the \\\"Guardians of the Galaxy\\\" to save the galaxy." +
                    CHRONOLOGICAL_INDEX + 11 +
                    PHASE + PHASE_TWO + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_avengers_age_of_ultron +
                    TITLE + "Avengers: Age of Ultron" +
                    YEAR + "2015" +
                    DETAILS + "PG-13 | 2h 21min | Action, Adventure, Sci-Fi | " +
                    DATE + "1 May 2015" +
                    DIRECTOR + "Joss Whedon" +
                    STARS + "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson, Mark Ruffalo, Jeremy Renner, Samuel L. Jackson, James Spader" +
                    "Elizabeth Olsen, Aaron Taylor-Johnson" +
                    SYNOPSIS + "Tony Stark creates the Ultron Program to protect the world, but when the peacekeeping program becomes hostile, The Avengers go into " +
                    "action to try and defeat a virtually impossible enemy together. Earth's mightiest heroes must come together once again to protect the world from" +
                    " global extinction." +
                    CHRONOLOGICAL_INDEX + 13 +
                    PHASE + PHASE_TWO + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_ant_man +
                    TITLE + "Ant-Man" +
                    YEAR + "2015" +
                    DETAILS + "PG-13 | 1h 57min | Action, Adventure, Comedy | " +
                    DATE + "6 May 2016" +
                    DIRECTOR + "Peyton Reed" +
                    STARS + "Paul Rudd, Michael Douglas, Evangeline Lilly, Corey Stoll, Michael Peña" +
                    SYNOPSIS + "Armed with the astonishing ability to shrink in scale but increase in strength, con-man Scott Lang must embrace his inner-hero and help his" +
                    " mentor, Dr. Hank Pym, protect the secret behind his spectacular Ant-Man suit from a new generation of towering threats. Against seemingly insurmountable" +
                    " obstacles, Pym and Lang must plan and pull off a heist that will save the world." +
                    CHRONOLOGICAL_INDEX + 14 +
                    PHASE + PHASE_TWO + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_captain_america_civil_war +
                    TITLE + "Captain America: Civil War" +
                    YEAR + "2016" +
                    DETAILS + "PG-13 | 2h 27min | Action, Adventure, Sci-Fi | " +
                    DATE + "6 May 2016" +
                    DIRECTOR + "Anthony Russo & Joe Russo" +
                    STARS + "Chris Evans, Robert Downey Jr., Scarlett Johansson, Sebastian Stan, Anthony Mackie, Don Cheadle, Jeremy Renner, Chadwick Boseman, Paul Bettany," +
                    " Elizabeth Olsen, Paul Rudd, Tom Holland, Daniel Brühl" +
                    SYNOPSIS + "With many people fearing the actions of super heroes, the government decides to push for the Hero Registration Act, a law that limits a hero's" +
                    " actions. This results in a division in The Avengers. Iron Man stands with this Act, claiming that their actions must be kept in check otherwise cities will" +
                    " continue to be destroyed, but Captain America feels that saving the world is daring enough and that they cannot rely on the government to protect the world." +
                    " This escalates into an all-out war between Team Iron Man (Iron Man, Black Panther, Vision, Black Widow, War Machine, and Spider-Man) and Team Captain America" +
                    " (Captain America, Bucky Barnes, Falcon, Scarlet Witch, Hawkeye, and Ant Man) while a new villain emerges." +
                    CHRONOLOGICAL_INDEX + 15 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_doctor_strange +
                    TITLE + "Doctor Strange" +
                    YEAR + "2016" +
                    DETAILS + "PG-13 | 1h 55min | Action, Adventure, Fantasy | " +
                    DATE + "4 November 2016" +
                    DIRECTOR + "Scott Derrickson" +
                    STARS + "Benedict Cumberbatch, Chiwetel Ejiofor, Rachel McAdams, Benedict Wong, Mads Mikkelsen, Tilda Swinton" +
                    SYNOPSIS + "Marvel's \\\"Doctor Strange\\\" follows the story of the talented neurosurgeon Doctor Stephen Strange who, after a tragic car accident, must put ego aside" +
                    " and learn the secrets of a hidden world of mysticism and alternate dimensions. Based in New York City's Greenwich Village, Doctor Strange must act as an intermediary" +
                    " between the real world and what lies beyond, utilising a vast array of metaphysical abilities and artifacts to protect the Marvel Cinematic Universe." +
                    CHRONOLOGICAL_INDEX + 18 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_guardians_of_the_galaxy_vol_2 +
                    TITLE + "Guardians of the Galaxy Vol. 2" +
                    YEAR + "2017" +
                    DETAILS + "PG-13 | 2h 16min | Action, Adventure, Comedy | " +
                    DATE + "5 May 2017" +
                    DIRECTOR + "James Gunn" +
                    STARS + "Chris Pratt, Zoe Saldana, Vin Diesel, Bradley Cooper, Michael Rooker, Karen Gillan, Pom Klementieff, Kurt Russell" +
                    SYNOPSIS + "After saving Xandar from Ronan's wrath, the Guardians are now recognized as heroes. Now the team must help their leader Star Lord (Chris Pratt) uncover the" +
                    " truth behind his true heritage. Along the way, old foes turn to allies and betrayal is blooming. And the Guardians find that they are up against a devastating new menace" +
                    " who is out to rule the galaxy." +
                    CHRONOLOGICAL_INDEX + 12 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_spider_man_homecoming +
                    TITLE + "Spider-Man: Homecoming" +
                    YEAR + "2017" +
                    DETAILS + "PG-13 | 2h 13min | Action, Adventure, Sci-Fi | " +
                    DATE + "7 July 2017" +
                    DIRECTOR + "Jon Watts" +
                    STARS + "Tom Holland, Michael Keaton, Robert Downey Jr., Jacob Batalon, Zendaya" +
                    SYNOPSIS + "Thrilled by his experience with the Avengers, Peter returns home, where he lives with his Aunt May, under the watchful eye of his new mentor Tony Stark, Peter " +
                    "tries to fall back into his normal daily routine - distracted by thoughts of proving himself to be more than just your friendly neighborhood Spider-Man - but when the " +
                    "Vulture emerges as a new villain, everything that Peter holds most important will be threatened." +
                    CHRONOLOGICAL_INDEX + 16 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_thor_ragnarok +
                    TITLE + "Thor: Ragnarok" +
                    YEAR + "2017" +
                    DETAILS + "PG-13 | 2h 10min | Action, Adventure, Comedy | " +
                    DATE + "3 November 2017" +
                    DIRECTOR + "Taika Waititi" +
                    STARS + "Chris Hemsworth, Tom Hiddleston, Cate Blanchett, Mark Ruffalo, Tessa Thompson, Jeff Goldblum, Taika Waititi, Karl Urban, Idris Elba, Benedict Cumberbatch, Anthony Hopkins" +
                    SYNOPSIS + "Imprisoned on the other side of the universe, the mighty Thor (Chris Hemsworth) finds himself in a deadly gladiatorial contest that pits him against The Incredible" +
                    " Hulk (Mark Ruffalo), his former ally and fellow Avenger. Thor's quest for survival leads him in a race against time to prevent the all-powerful Hela (Cate Blanchett) from destroying" +
                    " his home world and the Asgardian civilization." +
                    CHRONOLOGICAL_INDEX + 19 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_black_panther +
                    TITLE + "Black Panther" +
                    YEAR + "2018" +
                    DETAILS + "PG-13 | 2h 14min | Action, Adventure, Sci-Fi | " +
                    DATE + "16 February 2018" +
                    DIRECTOR + "Ryan Coogler" +
                    STARS + "Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o, Danai Gurira, Letitia Wright, Martin Freeman, Winston Duke, Angela Bassett, Forest Whitaker, Andy Serkis, Daniel Kaluuya" +
                    SYNOPSIS + "After the events of Captain America: Civil War, Prince T'Challa returns home to the reclusive, technologically advanced African nation of Wakanda to serve as his country's" +
                    " new king. However, T'Challa soon finds that he is challenged for the throne from factions within his own country. When two foes conspire to destroy Wakanda, the hero known as Black " +
                    "Panther must team up with C.I.A. agent Everett K. Ross and members of the Dora Milaje, Wakandan special forces, to prevent Wakanda from being dragged into a world war." +
                    CHRONOLOGICAL_INDEX + 17 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_avengers_infinity_war_main +
                    TITLE + "Avengers: Infinity War" +
                    YEAR + "2018" +
                    DETAILS + "PG-13 | 2h 29min | Action, Adventure, Sci-Fi | " +
                    DATE + "27 April 2018" +
                    DIRECTOR + "Anthony Russo & Joe Russo" +
                    STARS + "Josh Brolin, Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Benedict Cumberbatch, Tom Holland, Chris Pratt, Zoe Saldana, Chris Evans, Scarlett Johansson, Chadwick Boseman," +
                    " Paul Bettany, Elizabeth Olsen, Tom Hiddleston, Anthony Mackie, Don Cheadle, Vin Diesel, Karen Gillan, Bradley Cooper, Dave Bautista, Pom Klementieff" +
                    SYNOPSIS + "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows:" +
                    " Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality." +
                    " Everything the Avengers have fought for has led up to this moment, the fate of Earth and existence has never been more uncertain." +
                    CHRONOLOGICAL_INDEX + 21 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_ant_man_and_the_wasp +
                    TITLE + "Ant-Man and the Wasp" +
                    YEAR + "2018" +
                    DETAILS + "PG-13 | 1h 58min | Action, Adventure, Comedy | " +
                    DATE + "6 July 2018" +
                    DIRECTOR + "Peyton Reed" +
                    STARS + "Paul Rudd, Evangeline Lilly, Michael Douglas, Michael Peña, Hannah John-Kamen, Walton Goggins, Laurence Fishburne, Michelle Pfeiffer" +
                    SYNOPSIS + "In the aftermath of Captain America: Civil War (2016), Scott Lang grapples with the consequences of his choices as both a superhero and a father. As he struggles to rebalance" +
                    " his home life with his responsibilities as Ant-Man, he's confronted by Hope van Dyne and Dr. Hank Pym with an urgent new mission. Scott must once again put on the suit and learn to fight " +
                    "alongside The Wasp as the team works together to uncover secrets from their past." +
                    CHRONOLOGICAL_INDEX + 20 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_captain_marvel +
                    TITLE + "Captain Marvel" +
                    YEAR + "2019" +
                    DETAILS + "PG-13 | 2h 3min | Action, Adventure, Sci-Fi | " +
                    DATE + "8 March 2019" +
                    DIRECTOR + "Anna Boden & Ryan Fleck" +
                    STARS + "Brie Larson, Samuel L. Jackson, Lashana Lynch, Ben Mendelsohn, Jude Law, Annette Bening, Gemma Chan, Djimon Hounsou" +
                    SYNOPSIS + "After crashing an experimental aircraft, Air Force pilot Carol Danvers is discovered by the Kree and trained as a member of the elite Starforce Military under the command of her " +
                    "mentor Yon-Rogg. Six years later, after escaping to Earth while under attack by the Skrulls, Danvers begins to discover there's more to her past. With help from S.H.I.E.L.D. agent Nick Fury," +
                    " they set out to unravel the truth." +
                    CHRONOLOGICAL_INDEX + 2 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_avengers_endgame +
                    TITLE + "Avengers: Endgame" +
                    YEAR + "2019" +
                    DETAILS + "PG-13 | 3h 1min | Action, Adventure, Drama | " +
                    DATE + "26 April 2019" +
                    DIRECTOR + "Anthony Russo & Joe Russo" +
                    STARS + "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Jeremy Renner, Don Cheadle, Karen Gillan, Josh Brolin, Brie Larson, " +
                    "Tessa Thompson, Danai Gurira, Tilda Swinton, John Slattery, Elizabeth Olsen, Benedict Cumberbatch, Tom Holland, Chris Pratt, Zoe Saldana, Anthony Mackie, " +
                    "Chadwick Boseman, Vin Diesel, Bradley Cooper, Dave Bautista, Pom Klementieff, Samuel L. Jackson, Taika Waititi" +
                    SYNOPSIS + "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of " +
                    "remaining allies, the Avengers must assemble once more in order to undo Thanos's actions and undo the chaos to the universe, no matter what consequences may be in " +
                    "store, and no matter who they face...\\\n\\\nThe grave course of events set in motion by Thanos, that wiped out half the universe and fractured the Avengers ranks," +
                    " compels the remaining Avengers to take one final stand in Marvel Studios' grand conclusion to twenty-two films - Avengers: Endgame.\\\n\\\n" +
                    "After half of all life is snapped away by Thanos, the Avengers are left scattered and divided. Now with a way to reverse the damage, the Avengers and their allies must" +
                    " assemble once more and learn to put differences aside in order to work together and set things right. Along the way, the Avengers realize that sacrifices must be made" +
                    " as they prepare for the ultimate final showdown with Thanos, which will result in the heroes fighting the biggest battle they have ever faced." +
                    CHRONOLOGICAL_INDEX + 22 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET,
            "{" +
                    POSTER + R.drawable.poster_spider_man_far_from_home +
                    TITLE + "Spider-Man: Far from Home" +
                    YEAR + "2019" +
                    DETAILS + "PG-13 | 2h 9min | Action, Adventure, Sci-Fi | " +
                    DATE + "2 July 2019" +
                    DIRECTOR + "Jon Watts" +
                    STARS + "Tom Holland, Samuel L. Jackson, Jake Gyllenhaal, Zendaya, Jacob Batalon, Jon Favreau, Marisa Tomei, Tony Revolori, Cobie Smulders" +
                    SYNOPSIS + "Our friendly neighborhood Super Hero decides to join his best friends Ned, MJ, and the rest of the gang on a European vacation. However, Peter's plan to leave" +
                    " super heroics behind for a few weeks are quickly scrapped when he begrudgingly agrees to help Nick Fury uncover the mystery of several elemental creature attacks, creating" +
                    " havoc across the continent." +
                    CHRONOLOGICAL_INDEX + 23 +
                    PHASE + PHASE_THREE + QUOTE + CLOSING_BRACKET
    };
    
    static ArrayList<Movie> getListData() {
        System.out.println("--New Array Created--");
        ArrayList<Movie> list = new ArrayList<>();
        
        for (int i = 0; i < movies.length; i++) {
            try {
                JSONObject obj = new JSONObject(movies[i]);
                Movie movie = new Movie(
                        obj.getInt(poster),
                        obj.getString(title),
                        obj.getString(year),
                        obj.getString(details) + obj.getString(date),
                        obj.getString(date),
                        obj.getString(director),
                        obj.getString(stars),
                        obj.getString(synopsis),
                        obj.getInt(chronologicalIndex),
                        obj.getString(phase)
                );
                
                list.add(movie);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
}
