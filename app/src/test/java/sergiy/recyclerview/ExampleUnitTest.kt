package sergiy.recyclerview

import org.junit.Test

import org.junit.Assert.*
import java.util.SortedSet
import java.util.TreeSet

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    var treeSet = TreeSet<Int>()

    @Test
    fun testTreeSet() {
        treeSet.add(1)
        treeSet.add(2)
        treeSet.add(3)

        println(treeSet.higher(1))
        println(treeSet.lower(3))

        println(getPrevElems(3))
    }

    //region test
    fun getPrevElems(int: Int) {
//        for (d : treeSet)
        var subSet = TreeSet<Int>()
        treeSet.iterator().forEach { if (it < int) subSet.add(it) }
        print(subSet)
    }
    //endregion

    fun a() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("  end")
        toString()
    }

    @Test
    fun t() {
        println(a())
    }

    //region Test variants

    data class Producer<out T : Beverage>(
            val beverage: T
    ) {
        fun produce() : T = beverage
    }

    class Consumer<in T: Beverage> {
        fun consume(t: T) = println("Thanks for the drink $t!")
    }


    interface Beverage
    object Coffee : Beverage
    object Whisky : Beverage

    @Test
    fun mainTest() {
        val colombia: Producer<Coffee> = Producer(Coffee)
        val scottland: Producer<Whisky> = Producer(Whisky)
        val noCoffeeThere : Coffee = scottland.produce() // error

        val beverages: List<Beverage> = listOf(colombia, scottland).map { it.produce() }

        val starbucks = Consumer<Coffee>()
        starbucks.consume(colombia.produce())
        starbucks.consume(scottland.produce()) // error

        val pub = Consumer<Whisky>()
        pub.consume(scottland.produce())
        pub.consume(colombia.produce()) // error

    }
    //endregion
}
