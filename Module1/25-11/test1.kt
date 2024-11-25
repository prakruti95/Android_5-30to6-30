package tops23

import tops23.A.Companion.a3

class A
{
    companion object
    {
        fun a3()
        {
            println("a1")
        }
    }
    constructor()
    {
        println("a2")
    }

}

fun main()
{

    var a = A()//construcor call
    a3()
}