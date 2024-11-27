package tops27

open class RBI
{
    open fun roi():Int
    {
        return 0
    }
}
class SBI : RBI()
{
    override fun roi():Int
    {
        return 7
    }
}
class ICICI : RBI()
{
    override fun roi():Int
    {
        return 8
    }
}
class AXIS : RBI()
{
    override fun roi():Int
    {
        return 9
    }
}

fun main()
{
    var r = RBI()//object

    //refrence variables
    r = SBI()
    println(r.roi())

    r= ICICI()
    println(r.roi())

    r=AXIS()
    println(r.roi())


}