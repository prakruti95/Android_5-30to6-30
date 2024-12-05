package tops512

import java.util.*


fun main()
{

    var v = Vector<String>(5)

    v.addElement("a")
    v.addElement("b")
    v.addElement("c")
    v.addElement("d")
    v.addElement("e")
    v.addElement("e")
    v.addElement("b")
    v.addElement("c")
    v.addElement("d")
    v.addElement("e")
    v.addElement("e")
    v.addElement("e")

   println(v.capacity())
   println(v.size)

}