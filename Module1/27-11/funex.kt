package tops27

//with para with return
fun add1(a:Int,b:Int):Int
{
    return a+b
}

//with para without return
fun add2(a:Int,b:Int)
{
    var c = a+b
   println(c)
}

//without para with return
fun add3():Int
{
    var a = 6
    var b = 5
    var c = a+b

   return c
}

//without para without return
fun add4()
{
    var a = 6
    var b = 5
    var c = a+b
    println(c)

}

fun main()
{
    println(add1(6,5))
    add2(6,5)
    println(add3())
    add4()
}