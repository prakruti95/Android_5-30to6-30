package tops212

import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
{

    var s1 = Student(101,"aditi")
    var fout = FileOutputStream("E://topstech.txt")
    var out = ObjectOutputStream(fout)
    out.writeObject(s1)
    println("success")

}
//
//String s = ""//String format
//var s = Student()//object format