package tops29

import java.io.FileOutputStream

fun main()
{

    var data = "Welcome to tops"
    var fout = FileOutputStream("E://tops1.txt")
    fout.write(data.toByteArray())
    println("success")


}