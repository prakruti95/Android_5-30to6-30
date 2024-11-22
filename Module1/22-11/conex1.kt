package tops22

//primary constructor
class Emp(var name:String,var surname:String)
{
    fun display()
    {
        println("Your name is ${name}")
        println("Your surname is ${surname}")

    }
}


fun main()
{
    var e1 = Emp("ajay","shukla")
    var e2 = Emp("vijay","shukla")

    e1.display()
    e2.display()

}