package tops27

class Calculation
{
    fun cal(a:Int,b:Int) : Int
    {
            return a+b
    }
    fun cal(c:Double,d:Double) :Double
    {
        return c*d
    }
}
fun main()
{
    var c = Calculation()
    println(c.cal(3,2)) //5
    println(c.cal(1.0,2.0)) //2
}