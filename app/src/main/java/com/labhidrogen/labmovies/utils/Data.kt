package com.labhidrogen.labmovies.utils

import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.remote.response.ProgrammeResponse

object Data {

    fun generateBookmarkedMovies(): List<ProgrammeEntity> {
        val listBookmarkedMovies = ArrayList<ProgrammeEntity>()
        val movies = ArrayList<ProgrammeEntity>()

        movies.add(
            ProgrammeEntity(
                "M1",
                "The Tomorrow War",
                "A family man is drafted to fight in a future war where the fate of humanity relies on his ability to confront the past.",
                "2021",
                "July 2, 2021",
                "1",
                "PG-13",
                "2h 20min",
                "Action, Adventure, Sci-Fi, Thriller",
                "Chris McKay",
                "Zach Dean",
                "Chris Pratt, Yvonne Strahovski, J.K. Simmons",
                "6.7/10",
                "English",
                "https://gamezero.id/wp-content/uploads/2021/06/The-Tomorrow-War-696x696.jpg",
                true
            )
        )

        movies.add(
            ProgrammeEntity(
                "M2",
                "F9",
                "Cipher enlists the help of Jakob, Dom's younger brother to take revenge on Dom and his team.",
                "2021",
                "June 16, 2021",
                "1",
                "PG-13",
                "2h23min",
                "Action, Adventure, Crime, Thriller",
                "Justin Lin",
                "Daniel Casey, Justin Lin, Alfredo Botello",
                "Vin Diesel, Michelle Rodriguez, Jordana Brewster",
                "5.5/10",
                "English",
                "https://movies.universalpictures.com/media/ff9-teaser-1sheet-group-thursday-rgb-1sm-5e334ab003740-1.jpg",
                false
            )
        )
        movies.add(
            ProgrammeEntity(
                "M3",
                "Luca",
                "On the Italian Riviera, an unlikely but strong friendship grows between a human being and a sea monster disguised as a human.",
                "2021",
                "June 18, 2021",
                "1",
                "PG",
                "1h 35min",
                "Animation, Adventure, Comedy",
                "Enrico Casarosa",
                "Enrico Casarosa, Jesse Andrews, Simon Stephenson",
                "Jacob Tremblay, Jack Dylan Grazer, Emma Berman",
                "7.5/10",
                "English, Italian",
                "https://www.joblo.com/assets/images/joblo/posters/2021/04/luca-disney-pixar-trailer-poster-2021.jpg",
                false
            )
        )

        movies.add(
            ProgrammeEntity(
                "M4",
                "Fear Street",
                "A circle of teenage friends accidentally encounter the ancient evil responsible for a series of brutal murders that have plagued their town for over 300 years. Welcome to Shadyside.",
                "2021",
                "July 2, 2021",
                "1",
                "R",
                "1h 47min",
                "Horror, Mystery",
                "Leigh Janiak",
                "R.L. Stine, Kyle Killen, Phil Graziadei",
                "Kiana Madeira, Olivia Scott Welch, Benjamin Flores Jr.",
                "6.2/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNzQzYjIyZDQtMjBhZS00MzU3LTk0MTQtNTVmMDI3ZWY0ZWU3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                false
            )
        )

        movies.add(
            ProgrammeEntity(
                "M5",
                "The Ice Road",
                "After a remote diamond mine collapses in far northern Canada, a ‘big-rig’ ice road driver must lead an impossible rescue mission over a frozen ocean to save the trapped miners.",
                "2021",
                "June 25, 2021",
                "1",
                "PG-13",
                "1h 49min",
                "Action, Adventure, Drama, Thriller",
                "Jonathan Hensleigh",
                "Jonathan Hensleigh",
                "Liam Neeson, Marcus Thomas, Laurence Fishburne",
                "5.5/10",
                "English",
                "https://cinemags.co.id/wp-content/uploads/2021/05/The-Ice-Road-Poster.jpg",
                false
            )
        )

        movies.add(
            ProgrammeEntity(
                "M6",
                "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.",
                "2021",
                "May 26, 2021",
                "1",
                "13+",
                "1h 37min",
                "Drama, Horror, Sci-Fi",
                "John Krasinski",
                "John Krasinski, Scott Beck, Bryan Woods",
                "Emily Blunt, Millicent Simmonds, Cillian Murphy",
                "7.5/10",
                "English",
                "https://lsf.go.id/wp-content/uploads/2021/05/Quiet2.jpeg",
                false
            )
        )

        movies.add(
            ProgrammeEntity(
                "M7",
                "No Sudden Move",
                "A group of criminals are brought together under mysterious circumstances and have to work together to uncover what's really going on when their simple job goes completely sideways.",
                "2021",
                "July 1, 2021",
                "1",
                "R",
                "1h 55min",
                "Crime, Drama, Mystery, Thriller",
                "Steven Soderbergh",
                "Ed Solomon",
                "Don Cheadle, Benicio Del Toro, David Harbour",
                "6.6/10",
                "English",
                "https://www.cineplex.com.au/MovieImages/nosuddenmove.jpg",
                false
            )
        )

        movies.add(
            ProgrammeEntity(
                "M8",
                "Black Widow",
                "A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.",
                "2021",
                "July 7, 2021",
                "1",
                "PG-13",
                "2h 13min",
                "Action, Adventure, Sci-Fi",
                "Cate Shortland",
                "Jac Schaffer, Ned Benson, Eric Pearson",
                "Scarlett Johansson, Florence Pugh, David Harbour",
                "6.8/10",
                "English",
                "https://terrigen-cdn-dev.marvel.com/content/prod/1x/blackwidow_lob_crd_06.jpg",
                true
            )
        )

        movies.add(
            ProgrammeEntity(
                "M9",
                "In the Heights",
                "A film version of the Broadway musical in which Usnavi, a sympathetic New York bodega owner, saves every penny every day as he imagines and sings about a better life.",
                "2021",
                "June 9, 2021",
                "1",
                "13+",
                "2h 23min",
                "Drama, Music, Musical, Romance",
                "Jon M. Chu",
                "Quiara Alegría Hudes, Lin-Manuel Miranda",
                "Anthony Ramos, Corey Hawkins, Leslie Grace",
                "7.5/10",
                "English, Spanish",
                "https://www.theatermania.com/s/tm-photos-production/150855.jpg",
                true
            )
        )

        movies.add(
            ProgrammeEntity(
                "M10",
                "Cruella",
                "A live-action prequel feature film following a young Cruella de Vil.",
                "2021",
                "May 26, 2021",
                "1",
                "17+",
                "2h 14min",
                "Comedy, Crime",
                "Craig Gillespie",
                "Dana Fox, Tony McNamara, Aline Brosh McKenna",
                "Emma Stone, Emma Thompson, Joel Fry",
                "7.4/10",
                "English, French",
                "https://m.media-amazon.com/images/M/MV5BOWI5YTUxOWEtZmRiZS00ZmQxLWE2NzctYTRiODA2NzE1ZjczXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg",
                false
            )
        )

        for (movie in movies) {
            if (movie.bookmarked) {
                listBookmarkedMovies.add(movie)
            }
        }

        return listBookmarkedMovies
    }

    fun generateBookmarkedTvShows(): List<ProgrammeEntity> {
        val listBookmarkedTvShows = ArrayList<ProgrammeEntity>()
        val tvShows = ArrayList<ProgrammeEntity>()

        tvShows.add(
            ProgrammeEntity(
                "TV1",
                "Planet Earth II",
                "Wildlife documentary series with David Attenborough, beginning with a look at the remote islands which offer sanctuary to some of the planet's rarest creatures, to the beauty of cities, which are home to humans, and animals.",
                "2016",
                "November 6, 2016",
                "6",
                "TV-G",
                "60min",
                "Nature Documentary",
                "-",
                "-",
                "David Attenborough",
                "9.5/10",
                "French, English",
                "https://images-na.ssl-images-amazon.com/images/I/51Tlm-10rjL._SX300_SY300_QL70_FMwebp_.jpg",
                false
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV2",
                "Band of Brothers",
                "The story of Easy Company of the U.S. Army 101st Airborne Division, and their mission in World War II Europe, from Operation Overlord, through V-J Day.",
                "2001",
                "September 9, 2001",
                "10",
                "TV-MA",
                "49-70min",
                "Action, Drama, History, War",
                "Phil Alden Robinson",
                "Erik Jendresen, Tom Hanks, John Orioff, E.Max Frye, Graham Yost, Bruce C. Mc.Kenna, Erik Bork",
                "Scott Grimes, Damian Lewis, Ron Livingston, Donnie Wahlberg",
                "9.4/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/51DRuxxRJxL.__AC_SX300_SY300_QL70_FMwebp_.jpg",
                false
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV3",
                "Chernobyl",
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "2019",
                "May 6, 2019",
                "5",
                "TV-MA",
                "60-72min",
                "Drama, History, Thriller",
                "Johan Renck",
                "Craig Mazin",
                "Jessie Buckley, Jared Harris, Stellan Skarsgård",
                "9.4/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/91qFtxYzkcL._AC_SY879_.jpg",
                true
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV4",
                "The Wire",
                "The Baltimore drug scene, as seen through the eyes of drug dealers and law enforcement.",
                "2002",
                "June 2, 2002",
                "60",
                "TV-MA",
                "55-60min",
                "Crime, Drama, Thriller",
                "-",
                "David Simon",
                "Dominic West, Lance Reddick, Sonja Sohn",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNTllYzFhMjAtZjExNS00MjM4LWE5YmMtOGFiZGRlOTU5YzJiXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SX178_AL_.jpg",
                false
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV5",
                "Blue Planet II",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face.",
                "2017",
                "October 29, 2017",
                "7",
                "TV-G",
                "60min",
                "Documentary",
                "-",
                "-",
                "David Attenborough, Peter Drost, Roger Horrocks",
                "9.3/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/81HgqrFSmqL._SY445_.jpg",
                false
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV6",
                "Our Planet",
                "Documentary series focusing on the breadth of the diversity of habitats around the world, from the remote Arctic wilderness and mysterious deep oceans to the vast landscapes of Africa and diverse jungles of South America.",
                "2019",
                "April 5, 2019",
                "8",
                "TV-G",
                "48-53min",
                "Documentary",
                "-",
                "-",
                "David Attenborough",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BN2I1ZjA5YjQtYmQ0ZS00ZmE1LTk1ZjktNTQ5ODIzY2JiZDdhXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_.jpg",
                true
            )
        )
        tvShows.add(
            ProgrammeEntity(
                "TV7",
                "Cosmos: A Spacetime Odyssey",
                "An exploration of our discovery of the laws of nature and coordinates in space and time.",
                "2014",
                "March 9, 2014",
                "13",
                "TV-PG",
                "41-44min",
                "Documentary",
                "-",
                "Ann Druyan, Steven Soter",
                "Neil deGrasse Tyson, Stoney Emshwiller, Piotr Michael",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BZTk5OTQyZjYtMDk3Yy00YjhmLWE2MTYtZmY4NTg1YWUzZTQ0XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY1200_CR90,0,630,1200_AL_.jpg",
                false
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV8",
                "Game of Thrones",
                "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.",
                "2011",
                "April 17, 2011",
                "73",
                "TV-MA",
                "57min",
                "Action, Adventure, Drama, Fantasy",
                "Alan Taylor",
                "David Benioff, D.B. Weiss",
                "Emilia Clarke, Peter Dinklage, Kit Harington",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg",
                false
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV9",
                "Sherlock",
                "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
                "2010",
                "July 25, 2010",
                "15",
                "TV-14",
                "85-90min",
                "Crime, Drama, Mystery, Thriller",
                "Paul McGuigan",
                "Mark Gatiss, Steven Moffat",
                "Benedict Cumberbatch, Martin Freeman, Una Stubbs",
                "9.1/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BMWY3NTljMjEtYzRiMi00NWM2LTkzNjItZTVmZjE0MTdjMjJhL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTQ4NTc5OTU@._V1_UY1200_CR88,0,630,1200_AL_.jpg",
                false
            )
        )

        tvShows.add(
            ProgrammeEntity(
                "TV10",
                "Loki",
                "The mercurial villain Loki resumes his role as the God of Mischief in a new series that takes place after the events of “Avengers: Endgame.",
                "2021",
                "June 9, 2021",
                "6, ongoing",
                "TV-14",
                "42-54min",
                "Action, Adventure, Fantasy, Sci-Fi",
                "Kate Herron",
                "Michael Waldron",
                "Tom Hiddleston, Owen Wilson, Gugu Mbatha-Raw",
                "8.9",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNTkwOTE1ZDYtODQ3Yy00YTYwLTg0YWQtYmVkNmFjNGZlYmRiXkEyXkFqcGdeQXVyNTc4MjczMTM@._V1_.jpg",
                true
            )
        )

        for (tvShow in tvShows) {
            if (tvShow.bookmarked) {
                listBookmarkedTvShows.add(tvShow)
            }
        }
        return listBookmarkedTvShows
    }

    fun generateDataMovies(): List<ProgrammeEntity> {
        val movies = ArrayList<ProgrammeEntity>()

        movies.add(
            ProgrammeEntity(
                "M1",
                "The Tomorrow War",
                "A family man is drafted to fight in a future war where the fate of humanity relies on his ability to confront the past.",
                "2021",
                "July 2, 2021",
                "1",
                "PG-13",
                "2h 20min",
                "Action, Adventure, Sci-Fi, Thriller",
                "Chris McKay",
                "Zach Dean",
                "Chris Pratt, Yvonne Strahovski, J.K. Simmons",
                "6.7/10",
                "English",
                "https://gamezero.id/wp-content/uploads/2021/06/The-Tomorrow-War-696x696.jpg",
                false
            )
        )

        movies.add(
            ProgrammeEntity(
                "M2",
                "F9",
                "Cipher enlists the help of Jakob, Dom's younger brother to take revenge on Dom and his team.",
                "2021",
                "June 16, 2021",
                "1",
                "PG-13",
                "2h23min",
                "Action, Adventure, Crime, Thriller",
                "Justin Lin",
                "Daniel Casey, Justin Lin, Alfredo Botello",
                "Vin Diesel, Michelle Rodriguez, Jordana Brewster",
                "5.5/10",
                "English",
                "https://movies.universalpictures.com/media/ff9-teaser-1sheet-group-thursday-rgb-1sm-5e334ab003740-1.jpg"
            )
        )
        movies.add(
            ProgrammeEntity(
                "M3",
                "Luca",
                "On the Italian Riviera, an unlikely but strong friendship grows between a human being and a sea monster disguised as a human.",
                "2021",
                "June 18, 2021",
                "1",
                "PG",
                "1h 35min",
                "Animation, Adventure, Comedy",
                "Enrico Casarosa",
                "Enrico Casarosa, Jesse Andrews, Simon Stephenson",
                "Jacob Tremblay, Jack Dylan Grazer, Emma Berman",
                "7.5/10",
                "English, Italian",
                "https://www.joblo.com/assets/images/joblo/posters/2021/04/luca-disney-pixar-trailer-poster-2021.jpg"
            )
        )

        movies.add(
            ProgrammeEntity(
                "M4",
                "Fear Street",
                "A circle of teenage friends accidentally encounter the ancient evil responsible for a series of brutal murders that have plagued their town for over 300 years. Welcome to Shadyside.",
                "2021",
                "July 2, 2021",
                "1",
                "R",
                "1h 47min",
                "Horror, Mystery",
                "Leigh Janiak",
                "R.L. Stine, Kyle Killen, Phil Graziadei",
                "Kiana Madeira, Olivia Scott Welch, Benjamin Flores Jr.",
                "6.2/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNzQzYjIyZDQtMjBhZS00MzU3LTk0MTQtNTVmMDI3ZWY0ZWU3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg"
            )
        )

        movies.add(
            ProgrammeEntity(
                "M5",
                "The Ice Road",
                "After a remote diamond mine collapses in far northern Canada, a ‘big-rig’ ice road driver must lead an impossible rescue mission over a frozen ocean to save the trapped miners.",
                "2021",
                "June 25, 2021",
                "1",
                "PG-13",
                "1h 49min",
                "Action, Adventure, Drama, Thriller",
                "Jonathan Hensleigh",
                "Jonathan Hensleigh",
                "Liam Neeson, Marcus Thomas, Laurence Fishburne",
                "5.5/10",
                "English",
                "https://cinemags.co.id/wp-content/uploads/2021/05/The-Ice-Road-Poster.jpg"
            )
        )

        movies.add(
            ProgrammeEntity(
                "M6",
                "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.",
                "2021",
                "May 26, 2021",
                "1",
                "13+",
                "1h 37min",
                "Drama, Horror, Sci-Fi",
                "John Krasinski",
                "John Krasinski, Scott Beck, Bryan Woods",
                "Emily Blunt, Millicent Simmonds, Cillian Murphy",
                "7.5/10",
                "English",
                "https://lsf.go.id/wp-content/uploads/2021/05/Quiet2.jpeg"
            )
        )

        movies.add(
            ProgrammeEntity(
                "M7",
                "No Sudden Move",
                "A group of criminals are brought together under mysterious circumstances and have to work together to uncover what's really going on when their simple job goes completely sideways.",
                "2021",
                "July 1, 2021",
                "1",
                "R",
                "1h 55min",
                "Crime, Drama, Mystery, Thriller",
                "Steven Soderbergh",
                "Ed Solomon",
                "Don Cheadle, Benicio Del Toro, David Harbour",
                "6.6/10",
                "English",
                "https://www.cineplex.com.au/MovieImages/nosuddenmove.jpg"
            )
        )

        movies.add(
            ProgrammeEntity(
                "M8",
                "Black Widow",
                "A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.",
                "2021",
                "July 7, 2021",
                "1",
                "PG-13",
                "2h 13min",
                "Action, Adventure, Sci-Fi",
                "Cate Shortland",
                "Jac Schaffer, Ned Benson, Eric Pearson",
                "Scarlett Johansson, Florence Pugh, David Harbour",
                "6.8/10",
                "English",
                "https://terrigen-cdn-dev.marvel.com/content/prod/1x/blackwidow_lob_crd_06.jpg"
            )
        )

        movies.add(
            ProgrammeEntity(
                "M9",
                "In the Heights",
                "A film version of the Broadway musical in which Usnavi, a sympathetic New York bodega owner, saves every penny every day as he imagines and sings about a better life.",
                "2021",
                "June 9, 2021",
                "1",
                "13+",
                "2h 23min",
                "Drama, Music, Musical, Romance",
                "Jon M. Chu",
                "Quiara Alegría Hudes, Lin-Manuel Miranda",
                "Anthony Ramos, Corey Hawkins, Leslie Grace",
                "7.5/10",
                "English, Spanish",
                "https://www.theatermania.com/s/tm-photos-production/150855.jpg"
            )
        )

        movies.add(
            ProgrammeEntity(
                "M10",
                "Cruella",
                "A live-action prequel feature film following a young Cruella de Vil.",
                "2021",
                "May 26, 2021",
                "1",
                "17+",
                "2h 14min",
                "Comedy, Crime",
                "Craig Gillespie",
                "Dana Fox, Tony McNamara, Aline Brosh McKenna",
                "Emma Stone, Emma Thompson, Joel Fry",
                "7.4/10",
                "English, French",
                "https://m.media-amazon.com/images/M/MV5BOWI5YTUxOWEtZmRiZS00ZmQxLWE2NzctYTRiODA2NzE1ZjczXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg"
            )
        )

        return movies
    }

    fun generateDataTvShow(): List<ProgrammeEntity> {

        val tvShow = ArrayList<ProgrammeEntity>()

        tvShow.add(
            ProgrammeEntity(
                "TV1",
                "Planet Earth II",
                "Wildlife documentary series with David Attenborough, beginning with a look at the remote islands which offer sanctuary to some of the planet's rarest creatures, to the beauty of cities, which are home to humans, and animals.",
                "2016",
                "November 6, 2016",
                "6",
                "TV-G",
                "60min",
                "Nature Documentary",
                "-",
                "-",
                "David Attenborough",
                "9.5/10",
                "French, English",
                "https://images-na.ssl-images-amazon.com/images/I/51Tlm-10rjL._SX300_SY300_QL70_FMwebp_.jpg",
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV2",
                "Band of Brothers",
                "The story of Easy Company of the U.S. Army 101st Airborne Division, and their mission in World War II Europe, from Operation Overlord, through V-J Day.",
                "2001",
                "September 9, 2001",
                "10",
                "TV-MA",
                "49-70min",
                "Action, Drama, History, War",
                "Phil Alden Robinson",
                "Erik Jendresen, Tom Hanks, John Orioff, E.Max Frye, Graham Yost, Bruce C. Mc.Kenna, Erik Bork",
                "Scott Grimes, Damian Lewis, Ron Livingston, Donnie Wahlberg",
                "9.4/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/51DRuxxRJxL.__AC_SX300_SY300_QL70_FMwebp_.jpg"
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV3",
                "Chernobyl",
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "2019",
                "May 6, 2019",
                "5",
                "TV-MA",
                "60-72min",
                "Drama, History, Thriller",
                "Johan Renck",
                "Craig Mazin",
                "Jessie Buckley, Jared Harris, Stellan Skarsgård",
                "9.4/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/91qFtxYzkcL._AC_SY879_.jpg"
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV4",
                "The Wire",
                "The Baltimore drug scene, as seen through the eyes of drug dealers and law enforcement.",
                "2002",
                "June 2, 2002",
                "60",
                "TV-MA",
                "55-60min",
                "Crime, Drama, Thriller",
                "-",
                "David Simon",
                "Dominic West, Lance Reddick, Sonja Sohn",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNTllYzFhMjAtZjExNS00MjM4LWE5YmMtOGFiZGRlOTU5YzJiXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SX178_AL_.jpg"
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV5",
                "Blue Planet II",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face.",
                "2017",
                "October 29, 2017",
                "7",
                "TV-G",
                "60min",
                "Documentary",
                "-",
                "-",
                "David Attenborough, Peter Drost, Roger Horrocks",
                "9.3/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/81HgqrFSmqL._SY445_.jpg"
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV6",
                "Our Planet",
                "Documentary series focusing on the breadth of the diversity of habitats around the world, from the remote Arctic wilderness and mysterious deep oceans to the vast landscapes of Africa and diverse jungles of South America.",
                "2019",
                "April 5, 2019",
                "8",
                "TV-G",
                "48-53min",
                "Documentary",
                "-",
                "-",
                "David Attenborough",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BN2I1ZjA5YjQtYmQ0ZS00ZmE1LTk1ZjktNTQ5ODIzY2JiZDdhXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_.jpg"
            )
        )
        tvShow.add(
            ProgrammeEntity(
                "TV7",
                "Cosmos: A Spacetime Odyssey",
                "An exploration of our discovery of the laws of nature and coordinates in space and time.",
                "2014",
                "March 9, 2014",
                "13",
                "TV-PG",
                "41-44min",
                "Documentary",
                "-",
                "Ann Druyan, Steven Soter",
                "Neil deGrasse Tyson, Stoney Emshwiller, Piotr Michael",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BZTk5OTQyZjYtMDk3Yy00YjhmLWE2MTYtZmY4NTg1YWUzZTQ0XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY1200_CR90,0,630,1200_AL_.jpg"
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV8",
                "Game of Thrones",
                "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.",
                "2011",
                "April 17, 2011",
                "73",
                "TV-MA",
                "57min",
                "Action, Adventure, Drama, Fantasy",
                "Alan Taylor",
                "David Benioff, D.B. Weiss",
                "Emilia Clarke, Peter Dinklage, Kit Harington",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg"
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV9",
                "Sherlock",
                "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
                "2010",
                "July 25, 2010",
                "15",
                "TV-14",
                "85-90min",
                "Crime, Drama, Mystery, Thriller",
                "Paul McGuigan",
                "Mark Gatiss, Steven Moffat",
                "Benedict Cumberbatch, Martin Freeman, Una Stubbs",
                "9.1/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BMWY3NTljMjEtYzRiMi00NWM2LTkzNjItZTVmZjE0MTdjMjJhL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTQ4NTc5OTU@._V1_UY1200_CR88,0,630,1200_AL_.jpg"
            )
        )

        tvShow.add(
            ProgrammeEntity(
                "TV10",
                "Loki",
                "The mercurial villain Loki resumes his role as the God of Mischief in a new series that takes place after the events of “Avengers: Endgame.",
                "2021",
                "June 9, 2021",
                "6, ongoing",
                "TV-14",
                "42-54min",
                "Action, Adventure, Fantasy, Sci-Fi",
                "Kate Herron",
                "Michael Waldron",
                "Tom Hiddleston, Owen Wilson, Gugu Mbatha-Raw",
                "8.9",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNTkwOTE1ZDYtODQ3Yy00YTYwLTg0YWQtYmVkNmFjNGZlYmRiXkEyXkFqcGdeQXVyNTc4MjczMTM@._V1_.jpg"
            )
        )

        return tvShow
    }

    fun generateRemoteDummyMovies(): List<ProgrammeResponse> {
        val movies = ArrayList<ProgrammeResponse>()
        movies.add(
            ProgrammeResponse(
                "M1",
                "The Tomorrow War",
                "A family man is drafted to fight in a future war where the fate of humanity relies on his ability to confront the past.",
                "2021",
                "July 2, 2021",
                "1",
                "PG-13",
                "2h 20min",
                "Action, Adventure, Sci-Fi, Thriller",
                "Chris McKay",
                "Zach Dean",
                "Chris Pratt, Yvonne Strahovski, J.K. Simmons",
                "6.7/10",
                "English",
                "https://gamezero.id/wp-content/uploads/2021/06/The-Tomorrow-War-696x696.jpg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M2",
                "F9",
                "Cipher enlists the help of Jakob, Dom's younger brother to take revenge on Dom and his team.",
                "2021",
                "June 16, 2021",
                "1",
                "PG-13",
                "2h23min",
                "Action, Adventure, Crime, Thriller",
                "Justin Lin",
                "Daniel Casey, Justin Lin, Alfredo Botello",
                "Vin Diesel, Michelle Rodriguez, Jordana Brewster",
                "5.5/10",
                "English",
                "https://movies.universalpictures.com/media/ff9-teaser-1sheet-group-thursday-rgb-1sm-5e334ab003740-1.jpg"
            )
        )
        movies.add(
            ProgrammeResponse(
                "M3",
                "Luca",
                "On the Italian Riviera, an unlikely but strong friendship grows between a human being and a sea monster disguised as a human.",
                "2021",
                "June 18, 2021",
                "1",
                "PG",
                "1h 35min",
                "Animation, Adventure, Comedy",
                "Enrico Casarosa",
                "Enrico Casarosa, Jesse Andrews, Simon Stephenson",
                "Jacob Tremblay, Jack Dylan Grazer, Emma Berman",
                "7.5/10",
                "English, Italian",
                "https://www.joblo.com/assets/images/joblo/posters/2021/04/luca-disney-pixar-trailer-poster-2021.jpg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M4",
                "Fear Street",
                "A circle of teenage friends accidentally encounter the ancient evil responsible for a series of brutal murders that have plagued their town for over 300 years. Welcome to Shadyside.",
                "2021",
                "July 2, 2021",
                "1",
                "R",
                "1h 47min",
                "Horror, Mystery",
                "Leigh Janiak",
                "R.L. Stine, Kyle Killen, Phil Graziadei",
                "Kiana Madeira, Olivia Scott Welch, Benjamin Flores Jr.",
                "6.2/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNzQzYjIyZDQtMjBhZS00MzU3LTk0MTQtNTVmMDI3ZWY0ZWU3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M5",
                "The Ice Road",
                "After a remote diamond mine collapses in far northern Canada, a ‘big-rig’ ice road driver must lead an impossible rescue mission over a frozen ocean to save the trapped miners.",
                "2021",
                "June 25, 2021",
                "1",
                "PG-13",
                "1h 49min",
                "Action, Adventure, Drama, Thriller",
                "Jonathan Hensleigh",
                "Jonathan Hensleigh",
                "Liam Neeson, Marcus Thomas, Laurence Fishburne",
                "5.5/10",
                "English",
                "https://cinemags.co.id/wp-content/uploads/2021/05/The-Ice-Road-Poster.jpg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M6",
                "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.",
                "2021",
                "May 26, 2021",
                "1",
                "13+",
                "1h 37min",
                "Drama, Horror, Sci-Fi",
                "John Krasinski",
                "John Krasinski, Scott Beck, Bryan Woods",
                "Emily Blunt, Millicent Simmonds, Cillian Murphy",
                "7.5/10",
                "English",
                "https://lsf.go.id/wp-content/uploads/2021/05/Quiet2.jpeg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M7",
                "No Sudden Move",
                "A group of criminals are brought together under mysterious circumstances and have to work together to uncover what's really going on when their simple job goes completely sideways.",
                "2021",
                "July 1, 2021",
                "1",
                "R",
                "1h 55min",
                "Crime, Drama, Mystery, Thriller",
                "Steven Soderbergh",
                "Ed Solomon",
                "Don Cheadle, Benicio Del Toro, David Harbour",
                "6.6/10",
                "English",
                "https://www.cineplex.com.au/MovieImages/nosuddenmove.jpg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M8",
                "Black Widow",
                "A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.",
                "2021",
                "July 7, 2021",
                "1",
                "PG-13",
                "2h 13min",
                "Action, Adventure, Sci-Fi",
                "Cate Shortland",
                "Jac Schaffer, Ned Benson, Eric Pearson",
                "Scarlett Johansson, Florence Pugh, David Harbour",
                "6.8/10",
                "English",
                "https://terrigen-cdn-dev.marvel.com/content/prod/1x/blackwidow_lob_crd_06.jpg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M9",
                "In the Heights",
                "A film version of the Broadway musical in which Usnavi, a sympathetic New York bodega owner, saves every penny every day as he imagines and sings about a better life.",
                "2021",
                "June 9, 2021",
                "1",
                "13+",
                "2h 23min",
                "Drama, Music, Musical, Romance",
                "Jon M. Chu",
                "Quiara Alegría Hudes, Lin-Manuel Miranda",
                "Anthony Ramos, Corey Hawkins, Leslie Grace",
                "7.5/10",
                "English, Spanish",
                "https://www.theatermania.com/s/tm-photos-production/150855.jpg"
            )
        )

        movies.add(
            ProgrammeResponse(
                "M10",
                "Cruella",
                "A live-action prequel feature film following a young Cruella de Vil.",
                "2021",
                "May 26, 2021",
                "1",
                "17+",
                "2h 14min",
                "Comedy, Crime",
                "Craig Gillespie",
                "Dana Fox, Tony McNamara, Aline Brosh McKenna",
                "Emma Stone, Emma Thompson, Joel Fry",
                "7.4/10",
                "English, French",
                "https://m.media-amazon.com/images/M/MV5BOWI5YTUxOWEtZmRiZS00ZmQxLWE2NzctYTRiODA2NzE1ZjczXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg"
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShows(): List<ProgrammeResponse> {
        val tvShows = ArrayList<ProgrammeResponse>()

        tvShows.add(
            ProgrammeResponse(
                "TV1",
                "Planet Earth II",
                "Wildlife documentary series with David Attenborough, beginning with a look at the remote islands which offer sanctuary to some of the planet's rarest creatures, to the beauty of cities, which are home to humans, and animals.",
                "2016",
                "November 6, 2016",
                "6",
                "TV-G",
                "60min",
                "Nature Documentary",
                "-",
                "-",
                "David Attenborough",
                "9.5/10",
                "French, English",
                "https://images-na.ssl-images-amazon.com/images/I/51Tlm-10rjL._SX300_SY300_QL70_FMwebp_.jpg",
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV2",
                "Band of Brothers",
                "The story of Easy Company of the U.S. Army 101st Airborne Division, and their mission in World War II Europe, from Operation Overlord, through V-J Day.",
                "2001",
                "September 9, 2001",
                "10",
                "TV-MA",
                "49-70min",
                "Action, Drama, History, War",
                "Phil Alden Robinson",
                "Erik Jendresen, Tom Hanks, John Orioff, E.Max Frye, Graham Yost, Bruce C. Mc.Kenna, Erik Bork",
                "Scott Grimes, Damian Lewis, Ron Livingston, Donnie Wahlberg",
                "9.4/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/51DRuxxRJxL.__AC_SX300_SY300_QL70_FMwebp_.jpg"
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV3",
                "Chernobyl",
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "2019",
                "May 6, 2019",
                "5",
                "TV-MA",
                "60-72min",
                "Drama, History, Thriller",
                "Johan Renck",
                "Craig Mazin",
                "Jessie Buckley, Jared Harris, Stellan Skarsgård",
                "9.4/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/91qFtxYzkcL._AC_SY879_.jpg"
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV4",
                "The Wire",
                "The Baltimore drug scene, as seen through the eyes of drug dealers and law enforcement.",
                "2002",
                "June 2, 2002",
                "60",
                "TV-MA",
                "55-60min",
                "Crime, Drama, Thriller",
                "-",
                "David Simon",
                "Dominic West, Lance Reddick, Sonja Sohn",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNTllYzFhMjAtZjExNS00MjM4LWE5YmMtOGFiZGRlOTU5YzJiXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SX178_AL_.jpg"
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV5",
                "Blue Planet II",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face.",
                "2017",
                "October 29, 2017",
                "7",
                "TV-G",
                "60min",
                "Documentary",
                "-",
                "-",
                "David Attenborough, Peter Drost, Roger Horrocks",
                "9.3/10",
                "English",
                "https://images-na.ssl-images-amazon.com/images/I/81HgqrFSmqL._SY445_.jpg"
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV6",
                "Our Planet",
                "Documentary series focusing on the breadth of the diversity of habitats around the world, from the remote Arctic wilderness and mysterious deep oceans to the vast landscapes of Africa and diverse jungles of South America.",
                "2019",
                "April 5, 2019",
                "8",
                "TV-G",
                "48-53min",
                "Documentary",
                "-",
                "-",
                "David Attenborough",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BN2I1ZjA5YjQtYmQ0ZS00ZmE1LTk1ZjktNTQ5ODIzY2JiZDdhXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_.jpg"
            )
        )
        tvShows.add(
            ProgrammeResponse(
                "TV7",
                "Cosmos: A Spacetime Odyssey",
                "An exploration of our discovery of the laws of nature and coordinates in space and time.",
                "2014",
                "March 9, 2014",
                "13",
                "TV-PG",
                "41-44min",
                "Documentary",
                "-",
                "Ann Druyan, Steven Soter",
                "Neil deGrasse Tyson, Stoney Emshwiller, Piotr Michael",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BZTk5OTQyZjYtMDk3Yy00YjhmLWE2MTYtZmY4NTg1YWUzZTQ0XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY1200_CR90,0,630,1200_AL_.jpg"
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV8",
                "Game of Thrones",
                "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.",
                "2011",
                "April 17, 2011",
                "73",
                "TV-MA",
                "57min",
                "Action, Adventure, Drama, Fantasy",
                "Alan Taylor",
                "David Benioff, D.B. Weiss",
                "Emilia Clarke, Peter Dinklage, Kit Harington",
                "9.3/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg"
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV9",
                "Sherlock",
                "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
                "2010",
                "July 25, 2010",
                "15",
                "TV-14",
                "85-90min",
                "Crime, Drama, Mystery, Thriller",
                "Paul McGuigan",
                "Mark Gatiss, Steven Moffat",
                "Benedict Cumberbatch, Martin Freeman, Una Stubbs",
                "9.1/10",
                "English",
                "https://m.media-amazon.com/images/M/MV5BMWY3NTljMjEtYzRiMi00NWM2LTkzNjItZTVmZjE0MTdjMjJhL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTQ4NTc5OTU@._V1_UY1200_CR88,0,630,1200_AL_.jpg"
            )
        )

        tvShows.add(
            ProgrammeResponse(
                "TV10",
                "Loki",
                "The mercurial villain Loki resumes his role as the God of Mischief in a new series that takes place after the events of “Avengers: Endgame.",
                "2021",
                "June 9, 2021",
                "6, ongoing",
                "TV-14",
                "42-54min",
                "Action, Adventure, Fantasy, Sci-Fi",
                "Kate Herron",
                "Michael Waldron",
                "Tom Hiddleston, Owen Wilson, Gugu Mbatha-Raw",
                "8.9",
                "English",
                "https://m.media-amazon.com/images/M/MV5BNTkwOTE1ZDYtODQ3Yy00YTYwLTg0YWQtYmVkNmFjNGZlYmRiXkEyXkFqcGdeQXVyNTc4MjczMTM@._V1_.jpg"
            )
        )
        return tvShows
    }

    fun setBookmarkMovie(entity: ProgrammeEntity, bookmarked: Boolean): ProgrammeEntity {
        entity.bookmarked = bookmarked
        return entity
    }
}