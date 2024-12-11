package tops1112

import java.util.Collections

class Emp
{
    var salary:Int=0
    var name:String=""

    constructor(name:String,salary:Int)
    {
        this.salary=salary
        this.name=name
    }
}
class Salary : Comparator<Emp>
{
    override fun compare(o1: Emp, o2: Emp): Int
    {
        var value=0

        if(o1.salary>o2.salary)
        {
            return 1
        }
        else if(o1.salary<o2.salary)
        {
            return -1
        }
        else if(o1.salary==o2.salary)
        {
            return 0
        }
        return value
    }

}

fun main()
{
    var e1 = Emp("Drasti", 80000)
    var e2 = Emp("Lisha-1", 10000)
    var e3 = Emp("Ashil-2", 20000)
    var e4 = Emp("Bilal-3", 70000)


    var list = ArrayList<Emp>()
    list.add(e1)
    list.add(e2)
    list.add(e3)
    list.add(e4)

    Collections.sort(list,Salary())

    for(s:Emp in list)
    {
        println("${s.salary} and ${s.name}")
    }

}