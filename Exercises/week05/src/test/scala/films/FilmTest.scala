package films

import org.scalatest.FunSpec

/**
  * Created by David Tucker on 19/04/2017.
  */
class FilmTest extends FunSpec {

  describe("A director") {
    it("has a name") {
      assert(new Director("Dave", "Tucker", 1982).name == "Dave Tucker")
    }
    it("has a date of birth") {
      assert(new Director("D", "T", 1982).yearOfBirth == 1982)
    }
  }

  describe("A film") {
    val DaveT = new Director("Dave", "T", 1982)
    val YoungerDave = new Director("Dave", "T", 1985)
    val SpyFilm = new Film("The Software Spy", 2016, 3.2, DaveT)

    it("has a director identified by name and year of birth") {
      assert(SpyFilm.isDirectedBy(DaveT))
      assert(SpyFilm.isDirectedBy(new Director("Dave", "T", 1982)))
      assert(!SpyFilm.isDirectedBy(YoungerDave))
    }

    it("director was some age when directing it") {
      assert(SpyFilm.directorsAge == 34)
    }

    it("can be copied preserving Director") {
      val SpySequel = SpyFilm.copy(name="Spyware Everywhere", yearOfRelease = 2017, imdbRating = 2.0)
      assert(SpySequel.isDirectedBy(DaveT))
      assert(SpyFilm.isDirectedBy(SpySequel.director))
    }

    it("can be copied preserving name") {
      val OldSpyFilm = SpyFilm.copy(yearOfRelease = 1972, imdbRating = 5.6, director = new Director("Johnny", "Briggs", 1921))
      assert(OldSpyFilm.name == SpyFilm.name)
    }

    it("can be copied preserving year of release") {
      val OtherFilm = SpyFilm.copy(name = "something else", imdbRating = 7.2, director = new Director("Johnny", "Briggs", 1921))
      assert(OtherFilm.yearOfRelease == 2016)
    }

    it("can be copied preserving imdb rating") {
      val OtherFilm = SpyFilm.copy(name = "something else", yearOfRelease = 2012, director = new Director("Johnny", "Briggs", 1921))
      assert(OtherFilm.imdbRating == 3.2)
    }
  }

  describe("These films") {
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val nolan = new Director("Christopher", "Nolan", 1970)

    val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
    val invictus = new Film("Invictus", 2009, 7.4, eastwood)

    it("eastwood was born in 1930") {
      assert(eastwood.yearOfBirth == 1930)
    }
    it("die hard was directed by John McTiernan") {
      assert(dieHard.director.name == "John McTiernan")
    }
    it("invictus is not directed by nolan") {
      assert(!invictus.isDirectedBy(nolan))
    }
  }

  describe("Copying films is video piracy") {
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val nolan = new Director("Christopher", "Nolan", 1970)

    val inception = new Film("Inception", 2010, 8.8, nolan)
    val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
    val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

    it("can be translated to French"){
      val FrenchFilm = highPlainsDrifter.copy(name = "L’homme des hautes plaines")
      assert(FrenchFilm.name == "L’homme des hautes plaines")
      assert(FrenchFilm.yearOfRelease == 1973)
      assert(FrenchFilm.imdbRating - 7.7 < 0.01)
      assert(FrenchFilm.imdbRating - 7.7 > -0.01)
      assert(FrenchFilm.isDirectedBy(eastwood))
    }

    it("can be a remake of a film with the same name") {
      val originalThomasCrownAffair = thomasCrownAffair.copy(yearOfRelease = 1968,
        director = new Director("Norman", "Jewison", 1926))
      assert(originalThomasCrownAffair.isDirectedBy(new Director("Norman", "Jewison", 1926)))
      assert(originalThomasCrownAffair.name == "The Thomas Crown Affair")
      assert(originalThomasCrownAffair.yearOfRelease == 1968)
    }

    it("can just be copied entirely") {
      val piratedInception = inception.copy().copy().copy()
      assert(piratedInception.name == "Inception")
      assert(piratedInception.yearOfRelease == 2010)
      assert(piratedInception.isDirectedBy(nolan))
      assert(piratedInception.imdbRating - 8.8 < 0.01)
      assert(piratedInception.imdbRating - 8.8 > -0.01)
    }
  }

  describe("director companion object") {
    it("can be created with Director.apply") {
      val one = Director.apply("Mr", "Dave", 1982)
      val other = new Director("Mr", "Dave", 1982)
      assert(one.firstName == other.firstName)
      assert(one.lastName == other.lastName)
      assert(one.yearOfBirth == 1982)
    }

    it("gives oldest director with oldest") {
      val older = Director.apply("Rich", "Notice", 1980)
      val younger = new Director("Damien", "Like", 1985)
      assert(Director.older(older, younger) == older)
      assert(Director.older(younger, older) == older)
      assert(Director.older(older,younger).yearOfBirth == 1980)
    }
  }

  describe("film companion object") {
    it("can be created with Film.apply") {
      val testDir = Director.apply("Mr", "Dave", 1982)
      val oneFilm = Film.apply("Some Film", 1991, 7.2, testDir)
      val otherFilm = new Film("Some Film", 1991, 7.2, testDir)
      assert(oneFilm.name == otherFilm.name)
      assert(oneFilm.yearOfRelease == otherFilm.yearOfRelease)
      assert(oneFilm.isDirectedBy(otherFilm.director))
      assert(oneFilm.imdbRating - otherFilm.imdbRating < 0.01)
      assert(oneFilm.imdbRating - otherFilm.imdbRating > -0.01)
    }

    it("can return the highest rating film") {
      val testDir = new Director("Miss", "Brilliant", 1982)
      val goodFilm = new Film("Good Film", 1999, 6.99991, testDir)
      val badFilm = new Film("Bad Film", 2016, 6.999901, new Director("Ms", "Mediocre", 1979))
      assert(Film.highestRating(goodFilm, badFilm) == goodFilm)
      assert(Film.highestRating(badFilm, goodFilm) == goodFilm)
      assert(Film.highestRating(goodFilm,badFilm).imdbRating > goodFilm.imdbRating - 0.01)
      assert(Film.highestRating(badFilm,goodFilm).imdbRating > badFilm.imdbRating - 0.01)
    }

    it("can return the oldest aged director (at time of release)") {
      val oneDir = new Director("Mrs", "GenX", 1977)
      val otherDir = new Director("Mr", "GenY", 1977)
      val oldDir = new Director("Mr", "GenY", 1797)
      val earlyFilm = new Film("Earlier Film", 2015, 8.1, oneDir)
      val laterFilm = new Film("Later Film", 2016, 7.7, otherDir)
      assert(Film.oldestDirectorAtTheTime(earlyFilm, laterFilm) == laterFilm.director)
      val oneFilm = new Film("Made Now", 2017, 2.2, oneDir)
      val otherFilm = new Film("Made Now", 2017, 2.2, oldDir)
      assert(Film.oldestDirectorAtTheTime(oneFilm, otherFilm) == oldDir)
    }
  }

}
