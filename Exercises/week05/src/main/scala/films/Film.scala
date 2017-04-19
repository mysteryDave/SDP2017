package films

/**
  * Created by David Tucker on 19/04/2017.
  */

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  val name: String = firstName + " " + lastName
}

class Film(val name: String,
           val yearOfRelease: Int,
           val imdbRating: Double,
           val director: Director) {
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(wasIt: Director): Boolean = wasIt.name.equals(director.name) && wasIt.yearOfBirth == director.yearOfBirth //would wasIt == director work? No - Only if system exclusively uses same instance.
  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director) = new Film(name, yearOfRelease, imdbRating, director)
}