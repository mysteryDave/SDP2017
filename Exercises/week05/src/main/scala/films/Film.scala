package films

/**
  * Created by David Tucker on 19/04/2017.
  */

case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  val name: String = firstName + " " + lastName
}

object Director {
  /*def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = new Director(firstName, lastName, yearOfBirth)*/
  def older(one: Director, other: Director) = if (one.yearOfBirth < other.yearOfBirth) one else other
}

case class Film(name: String,
           yearOfRelease: Int,
           imdbRating: Double,
           director: Director) {
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(wasIt: Director): Boolean = wasIt.name.equals(director.name) && wasIt.yearOfBirth == director.yearOfBirth //would wasIt == director work? No - Only if system exclusively uses same instance.
  /*def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director) = new Film(name, yearOfRelease, imdbRating, director)*/
}

object Film {
  /*def apply(name: String,
            yearOfRelease: Int,
            imdbRating: Double,
            director: Director): Film = new Film(name, yearOfRelease, imdbRating, director)*/
  def highestRating(one: Film, other: Film): Film = if (one.imdbRating > other.imdbRating) one else other
  def oldestDirectorAtTheTime(one: Film, other: Film): Director = if (one.directorsAge > other.directorsAge) one.director else other.director
}