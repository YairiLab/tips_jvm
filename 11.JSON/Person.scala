class Person(var firstName: String, var familyName: String, var age: Int) {
  def marry(other: Person) {
    familyName = other.familyName
  }

  def aging() {
    age += 1
  }

  def goToSpace() {
    print(s"${firstName} 宇宙へ!!!")
  }
}

