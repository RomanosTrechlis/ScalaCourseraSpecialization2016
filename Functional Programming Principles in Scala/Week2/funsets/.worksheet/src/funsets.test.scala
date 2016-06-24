package funsets

object test {
  type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  var bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(53); 
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: funsets.test.Set, elem: Int)Boolean""");$skip(136); 
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  };System.out.println("""toString: (s: funsets.test.Set)String""");$skip(54); 
  def printSet(s: Set) {
    println(toString(s))
  };System.out.println("""printSet: (s: funsets.test.Set)Unit""");$skip(47); 
  def singletonSet(elem: Int): Set = Set(elem);System.out.println("""singletonSet: (elem: Int)funsets.test.Set""");$skip(26); 
	var s1 = singletonSet(1);System.out.println("""s1  : funsets.test.Set = """ + $show(s1 ));$skip(26); 
	var s2 = singletonSet(2);System.out.println("""s2  : funsets.test.Set = """ + $show(s2 ));$skip(54); 
	def union(s: Set, t: Set): Set = {i => s(i) || t(i)};System.out.println("""union: (s: funsets.test.Set, t: funsets.test.Set)funsets.test.Set""");$skip(57); 
	def intersect(s: Set, t: Set): Set = {i => s(i) & t(i)};System.out.println("""intersect: (s: funsets.test.Set, t: funsets.test.Set)funsets.test.Set""");$skip(63); 
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p);System.out.println("""filter: (s: funsets.test.Set, p: Int => Boolean)funsets.test.Set""");$skip(106); 
  // def filter(s: Set, p: Int => Boolean): Set = {i => s(i) & p(i)}
  var b = filter(Set(1,2,3), Set(3));System.out.println("""b  : funsets.test.Set = """ + $show(b ));$skip(4); val res$0 = 
  b;System.out.println("""res0: funsets.test.Set = """ + $show(res$0));$skip(13); val res$1 = 
	toString(b);System.out.println("""res1: String = """ + $show(res$1));$skip(37); 
	
	
	
	var s = union(Set(1,2,3), s2);System.out.println("""s  : funsets.test.Set = """ + $show(s ));$skip(16); val res$2 = 
	contains(s, 1);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(252); 
	def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a < -1000) true
      //else if (contains(s, a) != contains(p, a)) false
      else if (s(a) & !p(a)) false
      else iter(a - 1)
    }
    iter(1000)
  };System.out.println("""forall: (s: funsets.test.Set, p: Int => Boolean)Boolean""");$skip(21); 
  var t = Set(1,2,1);System.out.println("""t  : scala.collection.immutable.Set[Int] = """ + $show(t ));$skip(19); val res$3 = 
	forall(t, Set(1));System.out.println("""res3: Boolean = """ + $show(res$3));$skip(74); 

	def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x));System.out.println("""exists: (s: funsets.test.Set, p: Int => Boolean)Boolean""");$skip(20); val res$4 = 
  exists(t, Set(3));System.out.println("""res4: Boolean = """ + $show(res$4));$skip(82); 
 	def map(s: Set, f: Int => Int): Set = {(e: Int) => exists(s, (x => f(x) == e))};System.out.println("""map: (s: funsets.test.Set, f: Int => Int)funsets.test.Set""");$skip(39); 
  
  var m = map(Set(1,2,3), x => x+1);System.out.println("""m  : funsets.test.Set = """ + $show(m ));$skip(14); val res$5 = 
  toString(m);System.out.println("""res5: String = """ + $show(res$5))}
}
