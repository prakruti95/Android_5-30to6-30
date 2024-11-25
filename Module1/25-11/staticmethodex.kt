package tops23

import tops23.Student.Companion.change

//this is a refrence keyword
class Student
{
    //data memeber ,variables
    var id:Int=0
    var name:String=""
    companion object
    {
        var college:String="VVP"

        fun change()
        {
            Companion.college ="XYZ"
        }
    }


    constructor(id:Int,name:String)
    {
          this.id=id
          this.name = name
    }

    fun display()
    {
        print(" \n Your id is $id , Your name is $name , Your College is $college")
    }





}


fun main()
{
    var s1 = Student(101,"a")
    var s2 = Student(102,"b")

    change()//static method


    s1.display()
    s2.display()




}