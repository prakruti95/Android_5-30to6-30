package tops22

//Secondary constructor
class Student
{
    constructor(name:String,surname:String,email:String,mob:String)
    {
        println("-------------------")
        println("Your Name is $name")
        println("Your Name is $surname")
        println("Your Name is $email")
        println("Your Name is $mob")
    }
    constructor(name:String,surname:String)
    {
        println("-------------------")
        println("Your Name is $name")
        println("Your Name is $surname")


    }
    constructor(name:String,surname:String,email:String)
    {
        println("-------------------")
        println("Your Name is $name")
        println("Your Name is $surname")
        println("Your Name is $email")

    }
    constructor(name:String,surname:String,mob:Double)
    {
        println("-------------------")
        println("Your Name is $name")
        println("Your Name is $surname")
        println("Your Name is $mob")
    }

}


fun main()
{
    var s1 = Student("a","a")
    var s2 = Student("a","a","a@gmail.com")
    var s3 = Student("a","a","a@gmail.com","1234")
}