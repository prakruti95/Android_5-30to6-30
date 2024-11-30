open class A
{
    open var color = "black"
}
class B : A()
{
    override var color = "white"

    fun display()
    {
        print(color)
        print(super.color)
    }
}

fun main()
{
    var b = B()
    b.display()
}