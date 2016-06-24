package funsets

object test {
  type Set = Int => Boolean
  var bound = 1000                                //> bound  : Int = 1000
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: funsets.test.Set, elem: Int)Boolean
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: funsets.test.Set)String
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: funsets.test.Set)Unit
  def singletonSet(elem: Int): Set = Set(elem)    //> singletonSet: (elem: Int)funsets.test.Set
	var s1 = singletonSet(1)                  //> s1  : funsets.test.Set = Set(1)
	var s2 = singletonSet(2)                  //> s2  : funsets.test.Set = Set(2)
	def union(s: Set, t: Set): Set = {i => s(i) || t(i)}
                                                  //> union: (s: funsets.test.Set, t: funsets.test.Set)funsets.test.Set
	def intersect(s: Set, t: Set): Set = {i => s(i) & t(i)}
                                                  //> intersect: (s: funsets.test.Set, t: funsets.test.Set)funsets.test.Set
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)
                                                  //> filter: (s: funsets.test.Set, p: Int => Boolean)funsets.test.Set
  // def filter(s: Set, p: Int => Boolean): Set = {i => s(i) & p(i)}
  var b = filter(Set(1,2,3), Set(3))              //> b  : funsets.test.Set = <function1>
  b                                               //> res0: funsets.test.Set = <function1>
	toString(b)                               //> res1: String = {3}
	
	
	
	var s = union(Set(1,2,3), s2)             //> s  : funsets.test.Set = <function1>
	contains(s, 1)                            //> res2: Boolean = true
	def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a < -1000) true
      //else if (contains(s, a) != contains(p, a)) false
      else if (s(a) & !p(a)) false
      else iter(a - 1)
    }
    iter(1000)
  }                                               //> forall: (s: funsets.test.Set, p: Int => Boolean)Boolean
  var t = Set(1,2,1)                              //> t  : scala.collection.immutable.Set[Int] = Set(1, 2)
	forall(t, Set(1))                         //> res3: Boolean = false

	def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))
                                                  //> exists: (s: funsets.test.Set, p: Int => Boolean)Boolean
  exists(t, Set(3))                               //> res4: Boolean = false
 	def map(s: Set, f: Int => Int): Set = {(e: Int) => exists(s, (x => f(x) == e))}
                                                  //> map: (s: funsets.test.Set, f: Int => Int)funsets.test.Set
  
  var m = map(Set(1,2,3), x => x+1)               //> m  : funsets.test.Set = <function1>
  toString(m)                                     //> res5: String = {2,3,4}
}