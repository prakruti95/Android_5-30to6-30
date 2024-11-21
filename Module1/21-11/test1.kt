package tops21

class Student
{
    //data memebers //variables
    var name=""
    var surname=""

    //functions
    fun display()
    {
        println("$name and $surname")

    }


}

fun main()
{
    var s1 = Student()
    s1.name="bhumi"
    s1.surname="abcd"

    var s2 = Student()
    s2.name="aditi"
    s2.surname="abcd"

    var s3 = Student()
    s3.name="bhumit"
    s3.surname="abcd"

    var s4 = Student()
    s4.name="smit"
    s4.surname="abcd"

    var s5 = Student()
    s5.name="utsav"
    s5.surname="abcd"

    var s6 = Student()
    s6.name="rajan"
    s6.surname="abcd"

    s1.display()
    s2.display()
    s3.display()
    s4.display()
    s5.display()
    s6.display()

//    println("${s1.name} and ${s1.surname}")
//    println("${s2.name} and ${s2.surname}")
//    println("${s3.name} and ${s3.surname}")
//    println("${s4.name} and ${s4.surname}")
//    println("${s5.name} and ${s5.surname}")
//    println("${s6.name} and ${s6.surname}")

}